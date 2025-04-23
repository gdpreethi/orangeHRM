package com.salesforce.pages;

import org.testng.Assert;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class IndividualsDetailsPage extends ProjectSpecificMethods{
	
	public IndividualsDetailsPage getToastMessage() {
		
		//String elementText = getElementText(locateElement(Locators.XPATH,"//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		Assert.assertTrue(verifyExactText(locateElement(Locators.XPATH,"//span[@class='toastMessage slds-text-heading--small forceActionsText']"),"Individual \"Kumar\" was created."),"Individual not created");
		Assert.assertTrue(verifyExactText(locateElement(Locators.XPATH,"//div[text()='Individual']//following-sibling::div/span"),"Kumar"),"Individual not created");
		reportStep("Individual Kumar has been created", "pass");
		return this;
		
	}

}
