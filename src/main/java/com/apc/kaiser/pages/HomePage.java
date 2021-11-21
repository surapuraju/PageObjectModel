package com.apc.kaiser.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apc.kaiser.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//*[@id=\'navigationBar\']/ul/li[1]/span/span")
	WebElement kpClaimsLink;
	
	@FindBy(xpath="//*[@id='navigationBar']/ul/li[1]/ul/li[1]/span/a")
	WebElement kpClaimsSearch;
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
		
		//System.out.println("Reached Home Page... Driver Below...");
		//System.out.println(driver);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public HomePage claimsSearchTest(){
		kpClaimsLink.click();
		kpClaimsSearch.click();
		
		System.out.println("Reached claimsSearchPage ");
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new HomePage();
	}
		
//	public ContactsPage clickOnContactsLink(){
//		contactsLink.click();
//		return new ContactsPage();
//	}
//			
//	public void clickOnNewContactLink(){
//		Actions action = new Actions(driver);
//		action.moveToElement(contactsLink).build().perform();
//		newContactLink.click();
//		
//	}
	
	
	
	
	
	
	

}
