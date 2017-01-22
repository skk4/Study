package com.youxue.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.youxue.page.LoginPage;
import com.youxue.page.StudyProgress;
import com.youxue.util.AppiumDriverGenerator;
import com.youxue.util.AppiumServiceGenerator;
import com.youxue.util.Wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class LoginTest {

	private AppiumDriver driver;
	private LoginPage login;
	private AppiumDriverLocalService service;
	
	@BeforeSuite
	public void beforeSuite(){
		DOMConfigurator.configure("./log/Log4j.xml");
	}
	
	@BeforeTest
	@Parameters({"property_url","host_ip","port"})
	public void beforeTest(String property_url,String host_ip,String port){
		
		service=AppiumServiceGenerator.createAppiumService(host_ip,port);
		service.start();
		
		//打开APP
		this.driver=AppiumDriverGenerator.createAPPdriver(property_url,host_ip,port);
		
		this.login=new LoginPage(this.driver);
		Wait.waitMilliSeconds(5000);
		
	}
	
	@AfterTest
	public void afterTest(){
		
		this.driver.closeApp();
		this.service.stop();
	}
	

	
	@Test(alwaysRun=true)
	@Parameters({"user_name","pass_word"})
	public void loginYXViaWebDriver(String user_name,String pass_word){
		
		
		this.login.inputUsername(user_name);
		this.login.inputPassword(pass_word);
		
		this.login.clickLoginBtnTwo();
		StudyProgress study=new StudyProgress(this.driver);
		Assert.assertEquals(study.getPageTitle(), "学习动态");
		driver.context("NATIVE_APP");
	}
	

}
