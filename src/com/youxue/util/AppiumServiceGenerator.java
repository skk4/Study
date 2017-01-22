package com.youxue.util;

import java.io.File;
import java.util.Properties;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServiceGenerator {
	
	private static Properties pp=PropertyConfigure.configure("./properties/service.properties");
	
	/**
	 * 生成appium本地服务
	 * @return
	 */
	public static AppiumDriverLocalService createAppiumService(String IPAddress,String port){
		
		AppiumDriverLocalService service=AppiumDriverLocalService
		  .buildService(new AppiumServiceBuilder()
				  .usingDriverExecutable(new File(pp.getProperty("DriverExecutable")))
				  .withAppiumJS(new File(pp.getProperty("AppiumJS")))
				  .withLogFile(new File(pp.getProperty("LogFile")))
				  .withIPAddress(IPAddress)
				  .usingPort(Integer.parseInt(port)));
		return service;
	}
}
