
package com.amitagarwal.files;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.amitagarwal.files.model.Products;
//Path: http://localhost/<appln-folder-name>/latestsongs
@Path("/")
public class PriceRight {
	
	
	private static HashMap<String, ArrayList<String>> sendNotifMap = new HashMap<>();
	
	@POST
	@Path("/subscribe")
	@Consumes(MediaType.APPLICATION_JSON)
	public void subsribeUsers(Users users) {

		String user_id = users.getUser_id();
		ArrayList<Subscribe> sbsProdandReason = users.getSubscribe();
		
		Iterator<Subscribe> iterator = sbsProdandReason.iterator();
		
		while (iterator.hasNext()) {
			
			Subscribe subObj = iterator.next();
			if(null != Constants.productsMap && Constants.productsMap.containsKey(subObj.getProduct_id())){
				Map<String,String> subsList = Constants.productsMap.get(subObj.getProduct_id()).getSubscribedUsers();
				if(subsList == null || subsList.isEmpty() ){
					subsList = new HashMap<>();
					subsList.put(user_id, subObj.getWhen());
					Constants.productsMap.get(subObj.getProduct_id()).setSubscribedUsers(subsList);
					
					System.out.println("User: "+user_id+" has subscribed for Product Id: "+subObj.getProduct_id()+" with reason : "+subObj.getWhen());
					
				}
				else if(!subsList.containsKey(user_id)){
					subsList.put(user_id, subObj.getWhen());
					Constants.productsMap.get(subObj.getProduct_id()).setSubscribedUsers(subsList);
					
					System.out.println("User: "+user_id+" has subscribed for Product Id: "+subObj.getProduct_id()+" with reason : "+subObj.getWhen());
					
				}
				else if(subsList.containsKey(user_id)){
					System.out.println("You have already subscribed this product");
				}
				
			}
			else{
				System.out.println("Either No Products are there or you are trying to add wrong Product ID");
			}
			
		}
		
		return;

	}
	
	@POST
	@Path("/priceDataPoint")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addorChangeProductPrice(Product product) {

		
		if(null == Constants.productsMap )
		{
			Constants.productsMap = new HashMap<>();
			Products products = new Products(product.getProduct_id(), product.getPrice(), product.getPrice(), new HashMap<String,String>(), product.getUrl());
			Constants.productsMap.put(product.getProduct_id(), products);
			
			System.out.println("Product: "+product.getProduct_id()+" is being added to the system ");
			
		}
		else if(!Constants.productsMap.containsKey(product.getProduct_id())){
			
			Products products = new Products(product.getProduct_id(), product.getPrice(), product.getPrice(), new HashMap<String,String>(), product.getUrl());
			Constants.productsMap.put(product.getProduct_id(), products);
			System.out.println("Product: "+product.getProduct_id()+" is being added to the system ");
		}
		else if(Constants.productsMap.containsKey(product.getProduct_id())){
			
			sendNotifMap = new HashMap<>();
			Map<String,String> subList = Constants.productsMap.get(product.getProduct_id()).getSubscribedUsers();
			
			Iterator it = subList.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        
		        if(sendNotifMap.containsKey(pair.getValue())){
		        	
		        	ArrayList<String> user = sendNotifMap.get(pair.getValue());
		        	user.add((String)pair.getKey());
		        	sendNotifMap.put((String)pair.getValue(), user);
		        	
		        }
		        else{
		        	ArrayList<String> user = new ArrayList<>();
		        	user.add((String)pair.getKey());
		        	sendNotifMap.put((String)pair.getValue(), user);
		        }
		        //it.remove(); // avoids a ConcurrentModificationException
		    }
			
			Products oldProduct = Constants.productsMap.get(product.getProduct_id());
			
			float oldPrice = oldProduct.getCurrPrice();
			float lowestPrice = oldProduct.getAllTimeLowPrice();
			if(product.getPrice() < oldPrice ){

				// find ALWAYS WALE LOG
				
				if(null != sendNotifMap.get(Constants.reasons[0]) && !sendNotifMap.get(Constants.reasons[0]).isEmpty()){
					System.out.println("Sending ALWAYS PRICE Notification to: "+sendNotifMap.get(Constants.reasons[0]).size()+ " with user ids: "+sendNotifMap.get(Constants.reasons[0]).toString());
				}
				else{
					System.out.println("No Individual has subscribed yet for ALWAYS PRICE Notification "); 
				}
				
				float tenPercentFall =( (float)oldPrice*((float)90/100));
				
				
				if(product.getPrice() < tenPercentFall){
					
					// find ALL 10 % Wale Log
					
					if(null != sendNotifMap.get(Constants.reasons[2]) && !sendNotifMap.get(Constants.reasons[2]).isEmpty()){
						System.out.println("Sending MORE THAN 10% Notification to: "+sendNotifMap.get(Constants.reasons[2]).size()+ " with user ids: "+sendNotifMap.get(Constants.reasons[2]).toString());
					}
					else{
						System.out.println("No Individual has subscribed yet for More than 10% fall Notification "); 
					}
					
				}
				
				if(product.getPrice() < lowestPrice){
					
					lowestPrice = product.getPrice();
					// Find all lowest wale log
					
					if(null != sendNotifMap.get(Constants.reasons[1]) && !sendNotifMap.get(Constants.reasons[1]).isEmpty()){
						System.out.println("Sending ALL TIME LOW Notification to: "+sendNotifMap.get(Constants.reasons[1]).size()+ " with user ids: "+sendNotifMap.get(Constants.reasons[1]).toString());
					}
					else{
						System.out.println("No Individual has subscribed yet for ALL TIME LOW PRICE Notification "); 
					}
					
				}
				
				 
			}
			else{
					System.out.println("Price has increased or not changed from Previous Price and hence no notification needs to be send "); 
			}
			
			Products products = new Products(product.getProduct_id(), product.getPrice(), lowestPrice, Constants.productsMap.get(product.getProduct_id()).getSubscribedUsers(), product.getUrl());
			Constants.productsMap.put(product.getProduct_id(), products);
			
			// do something send Notifications
		}
	}
	
	@POST
	@Path("/unsubscribe")
	@Consumes(MediaType.APPLICATION_JSON)
	public void unsubscribeProducts(UnsubscribeProducts unsubscribeProd) {

		String userId = unsubscribeProd.getUser_id();
		ArrayList<Unsubscribe> unsList = unsubscribeProd.getUnsubscribe();
		Iterator<Unsubscribe> iterator = unsList.iterator();
		
		while (iterator.hasNext()) {
			Unsubscribe proUns = iterator.next();
			String productId = proUns.getProduct_id();
			
			Products p = Constants.productsMap.get(productId);
			Map<String,String> subMap = p.getSubscribedUsers();
			if(null != subMap && subMap.containsKey(userId)){
				subMap.remove(userId);
				p.setSubscribedUsers(subMap);
				System.out.println("Successfully Unsubscribed User : "+userId);
				
				System.out.println("Modified Product Map is: "+Constants.productsMap.get(productId).toString());
			}
			else{
				System.out.println("The User has not subscribed notifications for this product");
				System.out.println("Product Map is: "+Constants.productsMap.get(productId).toString());
			}
			
			
			
			
		}
		
		return;

	}
	
	
	
}
