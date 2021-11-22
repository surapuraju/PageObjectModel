package com.apc.kaiser.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.apc.kaiser.base.TestBase;
import com.apc.kaiser.pages.HomePage;
import com.apc.kaiser.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}

	private static Logger log =LogManager.getLogger(LoginPageTest.class.getName());
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		
		log.debug("Setting chrome driver property");
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Kaiser Permanente "
				+ "Sign On");
	}
	
//	@Test(priority=2)
//	public void crmLogoImageTest(){
//		boolean flag = loginPage.validateCRMImage();
//		Assert.assertTrue(flag);
//	}
	
	@Test(priority=3)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
