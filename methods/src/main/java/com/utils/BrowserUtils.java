package com.utils;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

	public static void switchTab(WebDriver driver)
	{
		String currentTab = driver.getWindowHandle();
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> driver.getWindowHandles().size()>1);

		Set<String> Tabs = driver.getWindowHandles();
		
		
		for(String tab : Tabs)
		{
			if(!tab.equals(currentTab))
			{
				driver.switchTo().window(tab);	
				break;
			}
		}
	}
}
