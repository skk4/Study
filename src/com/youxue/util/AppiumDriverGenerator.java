package com.youxue.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AppiumDriverGenerator {

	public static AppiumDriver createAPPdriver(String property_url,String host_ip,String port){
		AppiumDriver driver=null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		Properties pps=new Properties();
		try {
			pps.load(new FileInputStream(property_url));
			Enumeration en = pps.propertyNames();
			
			while(en.hasMoreElements()){
				String capabilityName=(String)en.nextElement();
				String value=pps.getProperty(capabilityName);
				capabilities.setCapability(capabilityName, value);
			}		
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			driver = new AndroidDriver(new URL("http://"+host_ip+":"+port+"/wd/hub"),capabilities);
			//重置，相当于清除APP数据
			driver.resetApp();
			//清除数据正在进行中.....
	    	Wait.waitMilliSeconds(10000);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	
}
