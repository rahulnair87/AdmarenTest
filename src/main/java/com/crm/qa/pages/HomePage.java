package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.locators.RelativeLocator;
import com.crm.qa.base.BaseTest;

//Dashboard
public class HomePage extends BaseTest{

    //Object Repository
	By btnAddNewPort = By.xpath("//button/span[contains(text(),'ADD NEW PORT OPERATION')]");
	By lblPortName = By.xpath("//span[text() ='Port Name']");
	By linkDashboard = By.xpath("//a[text()='Dashboard']");
	
	
	String portEntry = "//div[contains(text(),'%s')]";

	//Actions
	
	public String validatePageTitle(){
		return driver.getTitle();
	}
	
	public Boolean findDashboardEntry(String portName){
		
		portEntry = String.format(portEntry, portName);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(portEntry))));
		List<WebElement> portEntries = driver.findElements(By.xpath(portEntry));
		String date = "";
		Boolean found = false;
		
		for(WebElement p : portEntries)
		{
			date = p.getText();
			if (date.contains(prop.getProperty("layStartDate")))
			{
				if(date.contains(prop.getProperty("layEndDate")))
				{
					found = true;
					break;
				}
			}
		}
		
		return found;
	}
	
	public Boolean findFixtureInCalendar(){
		//By layDayTab = By.xpath("//div[@class='ng-star-inserted']/div[text()='PO-202121']");
		//By layDayTab = By.xpath("//div[@class='ng-star-inserted']/div[text()='Cochin']");
		By layDayTab = By.xpath("//div[@class='ng-star-inserted']/div[text()='Captain 5']");
		WebElement ele1 = driver.findElement(layDayTab);
		
		Point point1 = ele1.getLocation();
		int x1 = point1.getX();
		
		int ele1Width = ele1.getSize().getWidth();
		
		int w1 = ele1.getSize().width;
		
		int x1Span = x1 + ele1Width;
		
		Boolean fnd = false;
		String xpathDate= "";
		WebElement eleDate = null;
		List<String> datesOfActivity = new ArrayList<String>();
		for(int i=1; i<=31 ; i++){
			xpathDate = "//td[contains(@class,'e-date-header')]/span[text()='%s']";
			xpathDate = String.format(xpathDate, String.valueOf(i));
			eleDate = driver.findElement(By.xpath(xpathDate));
			if(eleDate.isDisplayed()){
				Point point2 = eleDate.getLocation();
				int x2 = point2.getX();
				int eleDateWidth = eleDate.getSize().getWidth();
				int x2Span = x2 + eleDateWidth;
				
				if(x2Span >x1 && x2Span<x1Span){
					//datesOfActivity.add(String.valueOf(i));
					datesOfActivity.add(eleDate.getAttribute("title"));
					System.out.println("Props of date identified");
					System.out.println("Date : "+String.valueOf(i));
					System.out.println("X = "+x2);
					System.out.println("Width : "+eleDateWidth);
					System.out.println();
				}
			}
		}
		
		
		String StartDay = datesOfActivity.get(0);
		String EndDay = datesOfActivity.get(datesOfActivity.size()-1);
		
		
		System.out.println("Properties of ele 1:");
		System.out.println("X = "+x1);	
		System.out.println("Width : "+ele1Width);
		System.out.println("W1New : "+w1);
		
		System.out.println();
		System.out.println("Selected Dates");
		System.out.println("StartDay = "+StartDay);
		System.out.println("EndDay = "+EndDay);
		
		
		/*List<WebElement> dts = driver.findElements(RelativeLocator.withTagName("span").above(ele1));
		//RelativeLocator.RelativeBy.xpath("//td[contains(@class,'e-date-header')]/span[text()='8']").ab
		
		String str = "";
		for(WebElement e : dts){
			str = "";
			str = e.getText().trim();
			if(str == "8"){
				fnd = true;
				break;
			}
		}*/
		return fnd;
	}
	
	public void clickAddNewPort(){
		driver.findElement(btnAddNewPort).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(lblPortName)));
	}
	
	
	public void goToDashboard(){
		driver.findElement(linkDashboard).click();
	}
	
	public void expandVessel(String vesselName){
		
		String xpathVesselExpand = "//div[text()='%s']/preceding-sibling::div";
		xpathVesselExpand = String.format(xpathVesselExpand, vesselName);
		String attr = driver.findElement(By.xpath(xpathVesselExpand)).getAttribute("class");
		if(!attr.contains("collapse"))
			driver.findElement(By.xpath(xpathVesselExpand)).click();
		
	}
	
	
	
}
