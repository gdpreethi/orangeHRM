package com.framework.testng.api.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.framework.selenium.api.base.SeleniumBase;
import com.framework.utils.DataLibrary;

public class ProjectSpecificMethods extends SeleniumBase {
	public static Properties prop;
	
	@BeforeSuite(alwaysRun = true)
	public synchronized void getConfigProperties() {
		FileInputStream config;
		try {
			config = new FileInputStream("./src/main/resources/config.properties");
			prop = new Properties();
			prop.load(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@DataProvider(name = "fetchData", indices = 0)
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(excelFileName);
	}

	@BeforeMethod
	public void preCondition() {
		
		startApp("chrome", false, prop.getProperty("url"));
		setNode();
	}

	@AfterMethod
	public void postCondition() {
		close();

	}

}
