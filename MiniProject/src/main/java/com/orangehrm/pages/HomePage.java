package com.orangehrm.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
	
	public AdminPage verifyHomePage() {
		
		//verifyTitle(prop.getProperty("homepagetitle"));
		//reportStep("Homepage is loaded", "pass");
		return new AdminPage();
	}
	public AdminPage clickAdminMenu() {
		click(locateElement(Locators.XPATH,"//span[text()='Admin']/parent::a"));
		return new AdminPage();
	}
	
	
}
