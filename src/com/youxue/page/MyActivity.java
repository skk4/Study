package com.youxue.page;

import io.appium.java_client.AppiumDriver;

public class MyActivity {
	
	private AppiumDriver driver;
	/**
	 * 返回菜单页
	 * @return
	 */
	public AppiumDriver clickMenuIcon(){
		return driver;
	}
	
	/**
	 * 进入待完成的活动页
	 */
	public void unfinishedActivities(){
		
	}
	
	/**
	 * 进入已完成的活动页
	 */
	public void finishedActivities(){
		
	}
	/**
	 * 已过期的活动
	 */
	public void expiredActivities(){
		
	}
	
	
	/**
	 * 进入活动
	 */
	public AppiumDriver enterActivity(String activityname){
		return driver;
	}
	

	
}
