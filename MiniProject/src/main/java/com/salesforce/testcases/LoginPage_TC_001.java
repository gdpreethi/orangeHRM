package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class LoginPage_TC_001  extends ProjectSpecificMethods{
	
	
	@BeforeTest
	public void setValues() {
		excelFileName="Login";
		testcaseName="Salesforce Application";
		testDescription="Login page";
		authors="Preethi";
		category="Sanity";
	}
	
	
	@Test(dataProvider = "fetchData")
	public void login(String uName,String passWord) {
		
		LoginPage lp=new LoginPage();
		lp.enterUserName(uName).enterPassword(passWord).clickOnLogin().clickApplauncher().clickViewAll().clickIndividuals()
		.clickNew().enterLastName().clickSave().getToastMessage();
	}
	
	/*public LoginPage enterPassword() {         			//to get data from config.properties file
		clearAndType(locateElement(Locators.ID, "password"), prop.getProperty("password"));
		reportStep("Password entered successfully","pass");
		return this;
	}
	 * 
	 * 
	 * 
	 */

}
