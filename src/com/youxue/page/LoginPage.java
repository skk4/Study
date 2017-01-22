package com.youxue.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.youxue.util.ContextSwitcher;
import com.youxue.util.Wait;

import io.appium.java_client.AppiumDriver;
public class LoginPage {
	
	private  AppiumDriver driver;
	
	
	public LoginPage(AppiumDriver driver){
		this.driver=driver;
		Wait.waitMilliSeconds(5000);
		ContextSwitcher.printContexts(driver);
		//WEBVIEW_0  WEBVIEW_org.yoya.com.yoyaorg
		ContextSwitcher.switchToWebView(this.driver);
	}
	
	public AppiumDriver loginYouXueTwo(String user_name,String pass_word){
		
		this.inputUsername(user_name);
		this.inputPassword(pass_word);
		this.clickLoginBtnTwo();
		this.driver.context("NATIVE_APP");
		return this.driver;
	}
	
	
	public void inputUsername(String user_name){
		WebElement username=this.driver.findElement(By.id("name"));
		username.clear();
		username.sendKeys(user_name);
		Wait.waitMilliSeconds(5000);
	}
	
	public void clickLoginBtnTwo(){
		driver.findElement(By.id("submit")).click();
		this.driver.context("NATIVE_APP");
		Wait.waitMilliSeconds(10000);
	}
	
	public void inputPassword(String pass_word){
		WebElement password=this.driver.findElement(By.id("pwd"));
		password.clear();
		password.sendKeys(pass_word);
	}
	
	
	


	
	
	
}
