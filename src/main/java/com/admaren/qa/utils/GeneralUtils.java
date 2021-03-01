package com.retail.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.BaseTest;



public class GeneralUtils extends BaseTest {
	
	public static void printExceptionMessage( Exception e){
		System.out.println("Test is exiting. " + e.getClass());
		System.out.println("Error Message : " +e.getMessage());
		System.out.println("Cause : " +e.getCause());
	}
	
	public static void moveToElementAndClick(WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();;
	}
	
	public static String removeLeadingZeroes(String str){
		String strPattern = "^0+(?!$)";
		str = str.replaceAll(strPattern, "");
		return str;
		
	}

}
