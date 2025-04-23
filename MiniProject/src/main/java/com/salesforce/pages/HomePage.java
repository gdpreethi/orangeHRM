package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class HomePage  extends ProjectSpecificMethods{
	
	public HomePage clickApplauncher() {
		click(locateElement(Locators.XPATH,"//button[@title='App Launcher']"));
		reportStep("App launcher clicked", "pass");
		return this;
	}
	public HomePage clickViewAll() {
		click(locateElement(Locators.XPATH,"//button[text()='View All']"));
		reportStep("View All clicked","pass");
		return this;
	}
	public IndividualsListViewPage clickIndividuals() {
		executeTheScript("arguments[0].scrollIntoView(true);",locateElement(Locators.XPATH,"//p[text()='Individuals']/ancestor::a"));
		clickUsingJs(locateElement(Locators.XPATH,"//p[text()='Individuals']/ancestor::a"));
		//click(locateElement(Locators.XPATH,"//p[text()='Individuals']/ancestor::a"));
		return new IndividualsListViewPage();
	}
	public OpportunityListViewPage clickOpportunity() {
		executeTheScript("arguments[0].scrollIntoView(true);",locateElement(Locators.XPATH,"//p[text()='Opportunities']/ancestor::a"));
		clickUsingJs(locateElement(Locators.XPATH,"//p[text()='Opportunities']/ancestor::a"));
		return new OpportunityListViewPage();
	}
  
}
