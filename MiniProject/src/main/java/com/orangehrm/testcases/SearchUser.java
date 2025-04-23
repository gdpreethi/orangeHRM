package com.orangehrm.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.framework.testng.api.base.ProjectSpecificMethods;
import com.orangehrm.pages.LoginPage;

public class SearchUser extends ProjectSpecificMethods{
	 LoginPage l = new LoginPage();
	@BeforeTest
	public void setValues() {
		excelFileName="Login";
		testcaseName="OrangeHRM Application";
		testDescription="Search User";
		authors="Preethi";
		category="Sanity";
	}
  @Test(priority=1)
  public void searchUser() {
	 
	  l.enterUsername(prop.getProperty("username")).enterPassword(prop.getProperty("password"))
	  .clickLogin().clickAdminMenu().enterSearchUsername(prop.getProperty("searchusername")).clickSearch();
  }
  @Test(priority=2)
  public void searchUserRole() {
	  l.enterUsername(prop.getProperty("username")).enterPassword(prop.getProperty("password"))
	  .clickLogin().clickAdminMenu().selectUserRole(prop.getProperty("userroleESS")).clickSearch();
  }
  /*@Test(priority=3)
  public void searchEmpName() {
	  l.enterUsername(prop.getProperty("username")).enterPassword(prop.getProperty("password"))
	  .clickLogin().clickAdminMenu().enterSearchEmpName(prop.getProperty("empName")).clickSearch();
  }*/
  
  @Test(priority = 3)
  public void searchEnabledUsers() {
	  l.enterUsername(prop.getProperty("username")).enterPassword(prop.getProperty("password"))
	  .clickLogin().clickAdminMenu().selectStatus("Enabled").clickSearch();
  }
}
