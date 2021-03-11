package com.admaren.qa.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.admaren.qa.base.BaseTest;

public class GeneralUtils extends BaseTest {

	public static void printExceptionMessage(Exception e) {
		System.out.println("Test is exiting. " + e.getClass());
		System.out.println("Error Message : " + e.getMessage());
		System.out.println("Cause : " + e.getCause());
	}

	public static void moveToElementAndClick(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
		;
	}

	public static String removeLeadingZeroes(String str) {
		String strPattern = "^0+(?!$)";
		str = str.replaceAll(strPattern, "");
		return str;

	}

	public static WebElement getVisibleElement(String xpath) {

		WebElement element = null;

		List<WebElement> elements = driver.findElements(By.xpath(xpath));

		int k = 0;
		for (WebElement e : elements) {
			if (e.isDisplayed()) {
				element = e;
				System.out.println("The matching element index :" + k);
				break;
			}
			k++;
		}

		return element;
	}

}
