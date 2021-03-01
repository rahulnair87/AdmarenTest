package com.crm.qa.tests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.AddPort;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest2 extends BaseTest {
	
	LoginPage loginPage;
	HomePage homePage;
	AddPort addPort;
	
	//Constructor Added
	public  LoginPageTest2(){
		super();
		
	}

	@BeforeClass
	public void setUp() throws MalformedURLException{
		initialize();
		loginPage = new LoginPage();
		homePage = new HomePage();
		addPort = new AddPort();
	}
	
	
	@Test(priority = 1)
	public void loginTest(){ 
			
		String title = loginPage.validatePageTitle();
		System.out.println("Title : "+title);
		loginPage.sendUserName(prop.getProperty("username"));
		loginPage.sendPassword(prop.getProperty("password"));
		loginPage.clickLogin();
		loginPage.waitForPinSentMsg();
		loginPage.enterOtp1("2");
		loginPage.enterOtp2("2");
		loginPage.enterOtp3("1");
		loginPage.enterOtp4("5");
		loginPage.enterOtp5("6");
		loginPage.enterOtp6("7");
		loginPage.clickVerify();
		
	}
	
	@Test(priority = 2)
	public void addNewPortTest(){
		
		homePage.goToDashboard();
		homePage.expandVessel("test ship");
		homePage.findFixtureInCalendar();
		Assert.assertTrue(homePage.findDashboardEntry(prop.getProperty("portName")), "The Lay dates are verified as expected");
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}
