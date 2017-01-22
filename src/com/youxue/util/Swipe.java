package com.youxue.util;

import io.appium.java_client.AppiumDriver;

public class Swipe {
	
	public static void swipeToUp(AppiumDriver driver,int during){
		//获取屏幕宽度
		int width=driver.manage().window().getSize().width;
		//获取高度
		int height=driver.manage().window().getSize().height;
		driver.swipe(width/2, height*3/4, width/2, height/4, during);
		//wait for page loading
		
		Wait.waitMilliSeconds(5000);
	}
	
	 public static void swipeToDown(AppiumDriver driver, int during) {
	        int width = driver.manage().window().getSize().width;
	        int height = driver.manage().window().getSize().height;
	        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
	        // wait for page loading
	 }
	 
	 public static void swipeToLeft(AppiumDriver driver, int during) {
	        int width = driver.manage().window().getSize().width;
	        int height = driver.manage().window().getSize().height;
	        driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);
	        // wait for page loading
	    } 
	  public static void swipeToRight(AppiumDriver driver, int during) {
	        int width = driver.manage().window().getSize().width;
	        int height = driver.manage().window().getSize().height;
	        driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
	        // wait for page loading
	    }
	
	

}
