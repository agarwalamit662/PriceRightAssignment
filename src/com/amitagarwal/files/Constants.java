package com.amitagarwal.files;

import java.util.HashMap;
import java.util.Map;

import com.amitagarwal.files.model.Products;



public class Constants {

	
	public static Map<String, Products> productsMap = new HashMap<>();
	
	
	public static String[] reasons = {"ALWAYS","ALL_TIME_LOW","MORE_THAN_10"};
	
	public static boolean executedJobOnce = false;
	
}
