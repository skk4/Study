package com.youxue.util;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;

public class ContextSwitcher {
	
	
	public static WebDriver switchToWebView(AppiumDriver driver){
		WebDriver webdriver=null;
		@SuppressWarnings("unchecked")
		Set<String> contexts=
				driver.getContextHandles();
		for(String s:contexts){
			if(s.contains("WEBVIEW")){
				webdriver=driver.context(s);
			}
		}
		return webdriver;
	}
	
	public static void  switchToNativeApp(AppiumDriver driver){
		driver.context("NATIVE_APP");
	}
	
	public static void printContexts(AppiumDriver driver){
		@SuppressWarnings("unchecked")
		Set<String> contexts=driver.getContextHandles();
		
		for(String s:contexts){
			System.out.println("s="+s);
		}
	}
	
}
