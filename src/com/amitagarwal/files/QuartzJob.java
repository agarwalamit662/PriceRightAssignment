package com.amitagarwal.files;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
public class QuartzJob implements Job {
    
	
	@Override
	public void execute(JobExecutionContext context)
                        throws JobExecutionException {
        		
			if(!Constants.executedJobOnce){
				System.out.println("Quartz Job Initialized");
				Constants.executedJobOnce = true;
			}
		
        		
    }    
           
}
