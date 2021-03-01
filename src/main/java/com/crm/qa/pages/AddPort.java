package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.BaseTest;
import com.retail.utils.GeneralUtils;
import com.retail.utils.Globals;


public class AddPort extends BaseTest{

    //Object Repository
	
	By portName = By.xpath("//input[@formcontrolname ='port']");
	By inpOperationInPort = By.xpath("//div/*[@ng-reflect-name='operation_in_port']//div[@class='mat-select-value']/span");
	By inpPlaceOfLoading = By.xpath("//div/*[@ng-reflect-name='place_of_load_discharge']//div[@class='mat-select-value']/span");
	By inpAgency = By.xpath("//div/*[@ng-reflect-name='agency']//div[@class='mat-select-value']/span");
	
	By dtpETA = By.xpath("//div/label[contains(text(),'ETA')]/../following-sibling::div//span[@aria-label='select']");
	By dtpETD = By.xpath("//div/label[contains(text(),'ETD')]/../following-sibling::div//span[@aria-label='select']");
	By inpStatus = By.xpath("//div/*[@ng-reflect-name='port_operation_status']//div[@class='mat-select-value']/span");
	
	String selectDateETA = "//td[@class='e-cell']/span[text()='%s']";
	String selectDateETD = "//td[@class='e-cell']/span[text()='%s']";
	
//	String selectFromListXpath = "//span[@class='mat-option-text' and contains(text(),'%s')]"; //Loading//From Shore // Admaren //Completed //test vessel //Captain 5 
	
	By tabFixtures = By.xpath("//div[@class='mat-tab-label-content' and contains(text(),'FIXTURE')]");
	
	By inpUHLFixtureNumber = By.xpath("//*[@ng-reflect-name='fixture_no']/span/input"); //123451
	By inpVessel = By.xpath("//div/*[@ng-reflect-name='vessel']//div[@class='mat-select-value']/span");
	By dtpLayDaysStart = By.xpath("//div/label[contains(text(),'Laydays Start')]/../following-sibling::div//span[@aria-label='select']");
	By dtpLaydaysEnd = By.xpath("//div/label[contains(text(),'Laydays End')]/../following-sibling::div//span[@aria-label='select']");
	
	String selectDateLayStart = "//td[@class='e-cell']/span[text()='%s']";
	String selectDateLayEnd = "//td[@class='e-cell']/span[text()='%s']";
	
	By tabPortCaptain = By.xpath("//div[@class='mat-tab-label-content' and contains(text(),'PORT CAPTAIN')]");
	
	By btnAddNewCaptain = By.xpath("//button/span[contains(text(),'Add New Port Captain')]");
	
	By inpCaptainName = By.xpath("//div/*[@ng-reflect-name='name']//div[@class='mat-select-value']/span");
	By dtpTimeOfArrival = By.xpath("//*[@formcontrolname='time_of_arrival']//span[@aria-label='select']");
	By dtpTimeOfDeparture = By.xpath("//*[@formcontrolname='time_of_departure']//span[@aria-label='select']");
	
	String selectDateCaptainArrival = "//td[@class='e-cell']/span[text()='%s']";
	String selectDateCaptainDeparture = "//td[@class='e-cell']/span[text()='%s']";
	
	By btnSave = By.xpath("//button/span[text()='SAVE']");
	
	By lblStatusCompleted = By.xpath("//span[contains(text(),'Completed')]");
	
	//Actions
	
	public void setPortName(String name ){
		driver.findElement(portName).sendKeys(name);
		driver.findElement(By.xpath("//span[@class='mat-option-text']/span")).click();
	}
	
	public void setOperationInPort(String operation){
		String selectFromListXpath = "//span[@class='mat-option-text' and contains(text(),'%s')]";
		driver.findElement(inpOperationInPort).click();
		selectFromListXpath = String.format(selectFromListXpath, operation);
		driver.findElement(By.xpath(selectFromListXpath)).click();;
	}
	
	public void setPlaceOfLoading(String placeOfLoading){
		String selectFromListXpath = "//span[@class='mat-option-text' and contains(text(),'%s')]";
		driver.findElement(inpPlaceOfLoading).click();
		selectFromListXpath = String.format(selectFromListXpath, placeOfLoading);
		driver.findElement(By.xpath(selectFromListXpath)).click();;
	}
	
	public void setAgency(String agency){
		String selectFromListXpath = "//span[@class='mat-option-text' and contains(text(),'%s')]";
		driver.findElement(inpAgency).click();
		selectFromListXpath = String.format(selectFromListXpath, agency);
		driver.findElement(By.xpath(selectFromListXpath)).click();;
	}
	
	public void setStatus(String status){
		String selectFromListXpath = "//span[@class='mat-option-text' and contains(text(),'%s')]";
		driver.findElement(inpStatus).click();
		selectFromListXpath = String.format(selectFromListXpath, status);
		driver.findElement(By.xpath(selectFromListXpath)).click();;
	}
	
	public void setETADate(String date){
		String[] arrDate = date.split("/");
		String day = arrDate[0];
		String month = arrDate[1];
		String year = arrDate[2];
		
		selectDateETA = String.format(selectDateETA, GeneralUtils.removeLeadingZeroes(day));		
		driver.findElement(dtpETA).click();		
		driver.findElement(By.xpath(selectDateETA)).click();
		
	}

	public void setETDDate(String date){
		String[] arrDate = date.split("/");
		String day = arrDate[0];
		String month = arrDate[1];
		String year = arrDate[2];
		
		selectDateETD = String.format(selectDateETD, GeneralUtils.removeLeadingZeroes(day));				
		driver.findElement(dtpETD).click();
		driver.findElement(By.xpath(selectDateETD)).click();
	}
	
	public void clickTabFixtures(){
		driver.findElement(tabFixtures).click();
	}
	
	public void setUHLFixtureNumber(String uhl){
		driver.findElement(inpUHLFixtureNumber).sendKeys(uhl);
		String xpathUHL = "//li[@class='e-list-item' and @data-value='%s']";
		xpathUHL = String.format(xpathUHL, uhl);
		driver.findElement(By.xpath(xpathUHL)).click();
	}
	
	public void setVessel(String vesselName){
		String selectFromListXpath = "//span[@class='mat-option-text' and contains(text(),'%s')]";
		driver.findElement(inpVessel).click();
		selectFromListXpath = String.format(selectFromListXpath, vesselName);
		driver.findElement(By.xpath(selectFromListXpath)).click();
	}
	
	public void setLayStartDate(String date){
		String[] arrDate = date.split("/");
		String day = arrDate[0];
		String month = arrDate[1];
		String year = arrDate[2];
		
		selectDateLayStart = String.format(selectDateLayStart, GeneralUtils.removeLeadingZeroes(day));				
		driver.findElement(dtpLayDaysStart).click();
		driver.findElement(By.xpath(selectDateLayStart)).click();
	}
	
	public void setLayEndtDate(String date){
		String[] arrDate = date.split("/");
		String day = arrDate[0];
		String month = arrDate[1];
		String year = arrDate[2];
		
		selectDateLayEnd = String.format(selectDateLayEnd, GeneralUtils.removeLeadingZeroes(day));						
		driver.findElement(dtpLaydaysEnd).click();
		driver.findElement(By.xpath(selectDateLayEnd)).click();
	}
	
	public void clickTabPortCaptain(){
		driver.findElement(tabPortCaptain).click();
	}
	
	public void clickAddNewCaptain(){
		driver.findElement(btnAddNewCaptain).click();
	}
	
	public void setCaptainName(String captainName){
		String selectFromListXpath = "//span[@class='mat-option-text' and contains(text(),'%s')]";
		driver.findElement(inpCaptainName).click();
		selectFromListXpath = String.format(selectFromListXpath, captainName);
		driver.findElement(By.xpath(selectFromListXpath)).click();;
	}
	
	public void setCaptainArrivalDate(String date){
		String[] arrDate = date.split("/");
		String day = arrDate[0];
		String month = arrDate[1];
		String year = arrDate[2];
		
		selectDateCaptainArrival = String.format(selectDateCaptainArrival, GeneralUtils.removeLeadingZeroes(day));						
		driver.findElement(dtpTimeOfArrival).click();
		driver.findElement(By.xpath(selectDateCaptainArrival)).click();
	}
	

	public void setCaptainDepartureDate(String date){
		String[] arrDate = date.split("/");
		String day = arrDate[0];
		String month = arrDate[1];
		String year = arrDate[2];
		
		selectDateCaptainDeparture = String.format(selectDateCaptainDeparture, GeneralUtils.removeLeadingZeroes(day));								
		driver.findElement(dtpTimeOfDeparture).click();
		driver.findElement(By.xpath(selectDateCaptainDeparture)).click();
	}
	
	public void clickSave(){
		driver.findElement(btnSave).click();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(lblStatusCompleted)));
		Globals.poNumber = driver.findElement(By.xpath("//h3[contains(text(),'PO-')]")).getText().trim();
		
	}
	
	
}
