package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.BaseTest;


public class LoginPage extends BaseTest{

    //Object Repository
	By txtUserName = By.xpath("//input[@formcontrolname='username']");
	By txtPassword = By.xpath("//input[@formcontrolname='password']");
	By btnLogin = By.xpath("//button/span[text()='LOGIN']");
	By msgPinSentToEmail = By.xpath("//h6[text()='Your PIN has been send to your E-mail']");
	By inpOtp1 = By.xpath("//input[@formcontrolname='otp1']");
	By inpOtp2 = By.xpath("//input[@formcontrolname='otp2']");
	By inpOtp3 = By.xpath("//input[@formcontrolname='otp3']");
	By inpOtp4 = By.xpath("//input[@formcontrolname='otp4']");
	By inpOtp5 = By.xpath("//input[@formcontrolname='otp5']");
	By inpOtp6 = By.xpath("//input[@formcontrolname='otp6']");
	By btnVerify = By.xpath("//button/span[text()='VERIFY']");
	
	//Actions
	
	public String validatePageTitle(){
		return driver.getTitle();
	}
	
	
	public void sendUserName(String name){
		driver.findElement(txtUserName).sendKeys(name);
	}
	
	public void sendPassword(String pwd){
		driver.findElement(txtPassword).sendKeys(pwd);
	}
	
	public void clickLogin(){
		driver.findElement(btnLogin).click();;
	}
	
	public void waitForPinSentMsg(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(msgPinSentToEmail));
	}
	
	public void enterOtp1(String otp1){
		driver.findElement(inpOtp1).sendKeys(otp1);
	}
	
	public void enterOtp2(String otp2){
		driver.findElement(inpOtp2).sendKeys(otp2);
	}
	
	public void enterOtp3(String otp3){
		driver.findElement(inpOtp3).sendKeys(otp3);
	}
	
	public void enterOtp4(String otp4){
		driver.findElement(inpOtp4).sendKeys(otp4);
	}
	
	public void enterOtp5(String otp5){
		driver.findElement(inpOtp5).sendKeys(otp5);
	}
	
	public void enterOtp6(String otp6){
		driver.findElement(inpOtp6).sendKeys(otp6);
	}
	
	public void clickVerify(){
		driver.findElement(btnVerify).click();
	}
	
}
