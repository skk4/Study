package com.youxue.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.youxue.util.ContextSwitcher;
import com.youxue.util.LocateElement;
import com.youxue.util.Wait;

import io.appium.java_client.AppiumDriver;

public class StudyProgress {
	
	
	private AppiumDriver driver;
	
	public StudyProgress(AppiumDriver driver){
		this.driver=driver;
		ContextSwitcher.switchToWebView(this.driver);

	}
	/**
	 * 开启菜单页
	 * @return
	 */
	public AppiumDriver clickMenuIcon(){

		//System.out.println("click menu icon");
		WebElement menu=this.driver.findElement(By.xpath("//div[@class='main']/a[contains(@class,'icon-menu')]"));
		menu.click();
		Wait.waitMilliSeconds(5000);
		//this.driver.context("NATIVE_APP");
		return driver;
	}
	
	public AppiumDriver clickSearchBtn(){
		//System.out.println("click search button");
		WebElement search=this.driver.findElement(By.cssSelector("a.iconfont.icon-search"));
		search.click();
		Wait.waitMilliSeconds(5000);
		this.driver.context("NATIVE_APP");
		return this.driver;
	}
	

	
	
	/**
	 * 获取活动发布人
	 */
	public String getAuthor(WebElement activity){
		return activity.findElement(By.xpath(".//div[@class='author']/span")).getText();
	}
	
	/**
	 * 获取截至时间,过期不使用
	 */
/*	public String getDeadline(WebElement activity){
		return activity.findElement(By.xpath(".//div[@class='desc']/div[2]")).getText().trim();
	}*/
	
	
	/**
	 * 获取已完成或待完成状态
	 */
	public String getStatus(WebElement activity){
		return activity.findElement(By.xpath(".//div[@class='main']/div[1]/span")).getText();
	}
	
	/**
	 * 获取已过期的活动状态
	 */
	public String getExpiredStatus(WebElement activity){
		return activity.findElement(By.xpath(".//div[@class='main']/div[1]/span[2]")).getText();
	}
	
	/**
	 * 获取主题
	 */
	public String getTheme(WebElement activity){
		return activity.findElement(By.xpath(".//div[@class='main']/div[1]")).getText();
	}
	
	/**
	 * 获取描述
	 */
	public String getDescription(WebElement activity){
		return activity.findElement(By.xpath(".//div[@class='main']/div[2]")).getText();
	}
	
	/**
	 * 定位活动
	 */
	public WebElement findActivity(String activity_name){
		String xpath="//div[@class='main']/div[contains(@class,'title')]";
		WebElement target=LocateElement.locateElementUsePartialText(this.driver, xpath, activity_name);
		
		return target.findElement(By.xpath("./../div[contains(@class,'attachment')]"));
	}
	
	public WebElement getMenuIcon(){
		WebElement menu=this.driver.findElement(By.cssSelector("a.iconfont.icon-menu"));
		return menu;
	}
	
	public WebElement getSearchBtn(){
		WebElement search=this.driver.findElement(By.cssSelector("a.iconfont.icon-search"));
		return search;
	}
	public WebElement getRefreshIcon(){
		WebElement refresh=this.driver.findElement(By.cssSelector("a.iconfont.icon-refresh"));
		return refresh;
	}
	/**
	 * 获取页面标题
	 * @return
	 */
	public String getPageTitle(){
		return this.driver.findElement(By.xpath("//div[@class='main']/span[@class='title']")).getText();
	}
	
	public void enterContent(String content_name){
		WebElement m=this.findActivity(content_name);
		m.click();
		Wait.waitMilliSeconds(10000);
	}
	
	/**
	 * 点击完成按钮
	 */
	public void clickFinishedBtn(){
		this.driver.findElement(By.xpath("//button[contains(@class,'feedback')]")).click();
		Wait.waitMilliSeconds(5000);
	}
	
	/**
	 * 选择反馈类型
	 */
	public void chooseFeedbackType(String fb_type){
		this.driver.findElement(By.xpath("//div[@class='choose-option']/span[text()='"+fb_type+"']")).click();
		Wait.waitMilliSeconds(5000);
	}
	
	/**
	 * 输入反馈内容
	 */
	public void inputfeedback(String fb_content){
		WebElement e=this.driver.findElement(By.id("feedbackContent"));
		e.clear();
		e.sendKeys(fb_content);
		Wait.waitMilliSeconds(5000);
	}
	
	/**
	 * 确定保存
	 */
	public void clickSaveBtn(){
		this.driver.findElement(By.id("submit")).click();
		Wait.waitMilliSeconds(5000);
	}
	
	/**
	 * 获取反馈类型
	 */
	public String getFeedbackType(){
		Wait.waitMilliSeconds(5000);
		return this.driver.findElement(By.xpath("//div[contains(@class,'feedback-content')]/div[@class='content-title']//span[contains(@class,'ng-binding')]")).getText();
	}
	/**
	 * 获取反馈内容
	 */
	public String getFeedbackContent(){
		Wait.waitMilliSeconds(5000);
		return this.driver.findElement(By.xpath("//div[contains(@class,'feedback-content')]/div[@class='content-block']/div")).getText().trim();
	}
	
}
