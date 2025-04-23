package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class AdminPage extends ProjectSpecificMethods{

	public AdminPage enterSearchUsername(String searchUsername) {
		clearAndType(locateElement(Locators.XPATH, "//label[text()='Username']/../following-sibling::div/input"), searchUsername);
		return this;
	}
	
	public AdminPage selectUserRole(String userRole) {
		click(locateElement(Locators.XPATH,"//div[contains(text(),'"+prop.getProperty("divDefaultValueDD")+"')]"));	
		click(locateElement(Locators.XPATH,"//div/span[contains(text(),'"+userRole+"')]"));
		
		//clickUsingJs(locateElement(Locators.XPATH,"//div/span[contains(text(),'"+prop.getProperty(userRole)+"')]"));
		return this;
	}
	
	public AdminPage enterSearchEmpName(String empName) {
		clearAndType(locateElement(Locators.XPATH,"//input[contains(@placeholder,'Type for hints...')]"), empName);
		return this;
	}
	
	public AdminPage selectStatus(String status) {
		click(locateElement(Locators.XPATH,"//div[contains(text(),'"+prop.getProperty("divDefaultValueDD")+"')]"));	
		click(locateElement(Locators.XPATH,"//div[contains(text(),'"+status+"')]"));
		return this;
		
	}
	
	public AdminPage clickReset() {
		click(locateElement(Locators.XPATH,"//button[contains(@class,'ghost')]"));
		return this;
	}
	
	public AdminPage clickSearch() {
		click(locateElement(Locators.XPATH,"//button[contains(@type,'submit')]"));
		reportStep("Search Results displayed","pass");
		return this;
	}
	
	public SaveSystemUser clickAdd() {
		click(locateElement(Locators.XPATH,"//button[contains(.,'Add')]"));
		return new SaveSystemUser();
		
	}
	
	public AdminPage chooseUserSearchResult(String[] username,String selectAllUsername) {
		if(selectAllUsername.contains("All") && selectAllUsername!=null) {
			clickUsingJs(locateElement(Locators.XPATH,"//div[contains(@class,'oxd-table-header')]/div/label/input"));
			reportStep("selected all checkboxes", "pass");
		}else {
			for(int i=0;i<username.length;i++) {
				click(locateElement(Locators.XPATH,"//div[@class='oxd-table-card'][.//div[text()='"+username[i]+"']]//input[@type='checkbox']"));				
			}
			reportStep("selected mentioned checkboxes ", "pass");
		}
		return this;
	}
	
	public AdminPage clickDeleteSelectedUser() {
		click(locateElement(Locators.XPATH,"//button[contains(.,'Delete Selected')]"));
		reportStep("selected users got deleted","pass");
		return this;
	}
	
	public void editSingleUser(String username) {
		click(locateElement(Locators.XPATH,"//div[@class='oxd-table-card'][.//div[text()='"+username+"']]//button[2]"));
		reportStep("Editing user "+username,"pass");

	}
	public AdminPage deleteSingleUser(String username) {
		click(locateElement(Locators.XPATH,"//div[@class='oxd-table-card'][.//div[text()='"+username+"']]//button"));
		reportStep("Deleted user "+username,"pass");
		return this;
	}
	

}
