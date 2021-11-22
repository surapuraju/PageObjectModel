package com.apc.kaiser.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apc.kaiser.base.TestBase;

public class ClaimsSearch4Claims extends TestBase{
	
	@FindBy(id="superSearch")
	WebElement searchBox;
	
	@FindBy(id="taxIds")
	WebElement taxId;
	
	// Initializing the Page Objects:
	public ClaimsSearch4Claims() {
		PageFactory.initElements(driver, this);
		
		//System.out.println("Reached Home Page... Driver Below...");
		//System.out.println(driver);
	}
	
//	public String verifyHomePageTitle(){
//		return driver.getTitle();
//	}
	
	public ClaimsSearch4Claims claimsSearch4ClaimsVerify(){
		searchBox.sendKeys("ProviderName");
		taxId.sendKeys("112645333");
		
		System.out.println("Reached claimsSearchPage ");
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ClaimsSearch4Claims();
	}
		
}
