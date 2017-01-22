package com.youxue.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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

public class StudyProgressTest {

	private StudyProgress process;
	private AppiumDriver driver;
	private AppiumDriverLocalService service;

  @BeforeTest
  @Parameters({"property_url","host_ip","port","user_name","pass_word"})
  public void beforeTest(String property_url,String host_ip,String port,String user_name,String pass_word) {
	  
	  service=AppiumServiceGenerator.createAppiumService(host_ip,port);
	  service.start();
	  	this.driver=AppiumDriverGenerator.createAPPdriver(property_url,host_ip,port);

	  	LoginPage login=new LoginPage(driver); 	
	  	this.driver=login.loginYouXueTwo(user_name, pass_word);
	  	
		this.process=new StudyProgress(this.driver);
		Wait.waitMilliSeconds(5000);
  }

  @AfterTest
  public void afterTest() {
	  this.driver.closeApp();
	  service.stop();
  }
  
  /**
   * 验证已完成和待完成的活动
   * @param activity_name
   * @param a_author
   * @param a_deadline
   * @param a_status
   * @param a_theme
   * @param a_desc
   */
  @Test(alwaysRun=true)
  @Parameters({"activity_name","a_author","a_deadline","a_status","a_theme","a_desc"})
  public void confirmActivityContents(String activity_name,String a_author,String a_deadline,String a_status,String a_theme,String a_desc){
	  //验证顶部内容
	  Assert.assertEquals(this.process.getPageTitle(),"学习动态"); 
	  Assert.assertNotNull(this.process.getMenuIcon());
	  Assert.assertNotNull(this.process.getSearchBtn());
	  Assert.assertNotNull(this.process.getRefreshIcon());
	  //寻找活动
	  WebElement activity=this.process.findActivity(activity_name);
	  //验证作者
	  Assert.assertEquals(this.process.getAuthor(activity), a_author);
	 
	  //验证状态
	  Assert.assertEquals(this.process.getStatus(activity),a_status);
	  //验证活动描述
	  Assert.assertEquals(this.process.getDescription(activity),a_desc);
  }
  
  /**
   * 验证已过期的活动
   */
  @Test(alwaysRun=true)
  @Parameters({"activity_name","a_author","a_deadline","a_status","a_theme","a_desc"})
  public void confirmActivityContentsTwo(String activity_name,String a_author,String a_deadline,String a_status,String a_theme,String a_desc){
	  //验证顶部内容
	  Assert.assertEquals(this.process.getPageTitle(),"学习动态"); 
	  Assert.assertNotNull(this.process.getMenuIcon());
	  Assert.assertNotNull(this.process.getSearchBtn());
	  Assert.assertNotNull(this.process.getRefreshIcon());
	  
	  //寻找活动
	  WebElement activity=this.process.findActivity(activity_name);
	  //验证作者
	  Assert.assertEquals(this.process.getAuthor(activity), a_author);
	 
	  //验证状态
	  Assert.assertEquals(this.process.getExpiredStatus(activity),a_status);
	  //验证活动描述
	  Assert.assertEquals(this.process.getDescription(activity),a_desc);
  }
  
  
  /**
   * 反馈课程学习
   */
  @Test(alwaysRun=true)
  @Parameters({"content_name","fb_type","fb_content"})
  public void feedbackStudy(String content_name,String fb_type,String fb_content){
	
	  //进入活动
	  this.process.enterContent(content_name);
	  
	  this.process.clickFinishedBtn();
	  
	  this.process.chooseFeedbackType(fb_type);
	  
	  this.process.inputfeedback(fb_content);
	  
	  this.process.clickSaveBtn();
	  
	  Assert.assertEquals(this.process.getFeedbackType(), fb_type);
	  Assert.assertEquals(this.process.getFeedbackContent(), fb_content);
  }
  
  
  
  
  

}
