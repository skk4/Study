package com.youxue.page;

import org.openqa.selenium.WebElement;

import com.youxue.util.Wait;

import io.appium.java_client.AppiumDriver;

public class SetPage {
	
	private AppiumDriver driver;
	
	public SetPage(AppiumDriver driver){
		this.driver=driver;
	}

	
	public AppiumDriver getPersonalInformatioin(){
		
		WebElement pi=this.driver.findElementByAccessibilityId("个人信息 Link");
				
		pi.click();
		Wait.waitMilliSeconds(5000);
		return driver;
	}
	
	public AppiumDriver enterModifyPassword(){
		WebElement mp=this.driver.findElementByAccessibilityId("修改密码 Link");
			
		mp.click();
		Wait.waitMilliSeconds(5000);
		return driver;
	}
	
	public void clickLogoutBtn(){
		System.out.println("登出");
		WebElement logout=this.driver.findElementByAccessibilityId("退出登录");
		logout.click();
		Wait.waitMilliSeconds(5000);
	}
	
	
}
