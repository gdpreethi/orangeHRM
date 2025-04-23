package com.orangehrm.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.framework.testng.api.base.ProjectSpecificMethods;
import com.orangehrm.pages.LoginPage;

public class TC001_SelectUser extends ProjectSpecificMethods{
	 LoginPage l = new LoginPage();
	@BeforeTest
	public void setValues() {
		excelFileName="Login";
		testcaseName="OrangeHRM Application";
		testDescription="Select User";
		authors="Preethi";
		category="Sanity";
	}
  @Test
  public void selectUser() {
	  String[] username= {"Testing"};
	  l.enterUsername(prop.getProperty("username")).enterPassword(prop.getProperty("password"))
	  .clickLogin().clickAdminMenu().enterSearchUsername(prop.getProperty("searchusername")).clickSearch().chooseUserSearchResult(null,"All");
  }
  
}
