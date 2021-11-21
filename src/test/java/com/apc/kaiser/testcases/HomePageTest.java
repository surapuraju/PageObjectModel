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
import com.apc.kaiser.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
//	TestUtil testUtil;
//	ContactsPage contactsPage;
	private static Logger log =LogManager.getLogger(HomePageTest.class.getName());
	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
//		testUtil = new TestUtil();
//		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "APC Oregon & SW Washington - Welcome page");
	}
	
	@Test(priority=2)
	public void claimsSearchTest(){
		homePage.claimsSearchTest();
		System.out.println("Reached claimsSearchTest ");
		log.info("Successfully Accessed Claims Page to Search for Claims");
	}
		
	
//	@Test(priority=2)
//	public void verifyUserNameTest(){
//		testUtil.switchToFrame();
//		Assert.assertTrue(homePage.verifyCorrectUserName());
//	}
	
//	@Test(priority=3)
//	public void verifyContactsLinkTest(){
//		testUtil.switchToFrame();
//		contactsPage = homePage.clickOnContactsLink();
//	}

	
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}
	
	

}
