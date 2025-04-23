package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class IndividualsListViewPage extends ProjectSpecificMethods{
	public IndividualsListViewPage clickNew() {		
		click(locateElement(Locators.XPATH,"//div[text()='New']/parent::a"));
		return this;
	}
	public IndividualsListViewPage enterLastName() {
		
		clearAndType(locateElement(Locators.XPATH,"//span[text()='Last Name']/parent::label//following-sibling::input"),"Kumar");
		reportStep("Last Name entered successfully", "pass");
		return this;
	}
	public IndividualsDetailsPage clickSave() {
		click(locateElement(Locators.XPATH,"//button[@title='Save']"));
		return new IndividualsDetailsPage();
	}
}
