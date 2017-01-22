package com.youxue.page;

import org.openqa.selenium.WebElement;

import com.youxue.util.Wait;

import io.appium.java_client.AppiumDriver;

public class MenuPage {
	private AppiumDriver driver;
	
	public MenuPage(AppiumDriver driver){
		
		this.driver=driver;
	}
	
	/**
	 * 设置页
	 * @return
	 */
	public AppiumDriver enterSet(){
		
		WebElement e=this.driver.findElementByXPath("//android.view.View[@index='0']/android.view.View[@content-desc=' Link']");
		e.click();
		Wait.waitMilliSeconds(5000);
		return driver;
	}
	
	/**
	 * 学习动态页
	 * @return
	 */
	public AppiumDriver enterStudyProcess(){
		WebElement e=this.driver.findElementByXPath("//android.view.View[@index='0']/android.view.View[@index='5']");
		e.click();
		return driver;
	}
	/**
	 * 学习难点页
	 * @return
	 */
	public AppiumDriver enterStudyDifficulties(){
		WebElement e=this.driver.findElementByXPath("//android.view.View[@index='0']/android.view.View[@index='6']");
		e.click();
		return driver;
	}
	
	/**
	 * 我的课程页
	 * @return
	 */
	public AppiumDriver enterMyCourse(){
		WebElement e=this.driver.findElementByXPath("//android.view.View[@index='0']/android.view.View[@index='7']");
		e.click();
		return driver;
	}
	
	/**
	 * 我的活动页
	 * @return
	 */
	public AppiumDriver enterMyActivity(){
		WebElement e=this.driver.findElementByXPath("//android.view.View[@index='0']/android.view.View[@index='8']");
		e.click();
		return driver;
	}
	/**
	 * 我的校园页
	 * @return
	 */
	public AppiumDriver enterMyCampus(){
		WebElement e=this.driver.findElementByXPath("//android.view.View[@index='0']/android.view.View[@index='9']");
		e.click();
		return driver;
	}
	
	/**
	 * 我的消息页
	 */
	public AppiumDriver enterMyMessage(){
		return driver;
	}
	
	

}
