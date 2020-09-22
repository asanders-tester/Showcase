package PHPTravel.End2EndExample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class LandingPageHeaderTest extends Base {

	private LandingPage lp;
	private Actions action;
	
	@BeforeTest
	public void initialize() throws IOException {
		lp = new LandingPage(driver);
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	@Test
	public void clickCompanyLogo() {
		lp = new LandingPage(driver);
		lp.companyLogo().click();
	}
	
	@Test
	public void clickBackToHome() {
		lp = new LandingPage(driver);
		lp.backToHome().click();
	}
	
	@Test
	public void mouseOverCompany() {
		lp = new LandingPage(driver);
		action = new Actions(driver);
		action.moveToElement(lp.company()).build().perform();
		if(lp.companyDropDown().getAttribute("style").contains("display: block;")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void clickContact() {
		lp = new LandingPage(driver);
		lp.contact().sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
	}
	
	@Test
	public void clickAboutUs() {
		lp = new LandingPage(driver);
		action = new Actions(driver);
		action.moveToElement(lp.company()).build().perform();
		lp.aboutUs().sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
	}
	
	@Test
	public void callNowVerification() {
		lp = new LandingPage(driver);
		if (lp.callNow().isDisplayed()) {
			Assert.assertEquals(lp.callNow().getText(), "Call Now: +1-360-244-9610");
		}
	}
	
	@Test
	public void currencyDefaultTextVerification() {
		lp = new LandingPage(driver);
		Assert.assertEquals(lp.currency().getText(), "USD");
	}	
	
	@Test
	public void currencyDropDownVerification() {
		lp = new LandingPage(driver);
		lp.currencyClick().click();
		if(lp.currencyClick().getAttribute("aria-expanded").contains("true")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void currencyTypes() {
		lp = new LandingPage(driver);
		List<WebElement> currencyType = (List<WebElement>) lp.currencySelect();
		List<String> obtainedList = new ArrayList<String>();
		int countCurrency = currencyType.size();
		for(int i = 0; i < countCurrency; i++) {
			String text = currencyType.get(i).getText();
			obtainedList.add(text);
		}
		List<String> sortedList = new ArrayList<String>();
		for(String s:obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);
		Assert.assertTrue(sortedList.equals(obtainedList));
	}
	
	@Test(dependsOnMethods = {"currencyTypes"})
	public void currencySelection() {
		lp = new LandingPage(driver);
		List<WebElement> currencyType = (List<WebElement>) lp.currencySelect();
		int countCurrency = currencyType.size();
		for(int i = 0; i < countCurrency; i++) {
			String text = currencyType.get(i).getText();
			if(text.equalsIgnoreCase("INR")) {
				currencyType.get(i).click();
				break;
			}
		}
	}
	
	@Test
	public void languageDefaultTextVerification() {
		lp = new LandingPage(driver);
		Assert.assertEquals(lp.language().getText(), "ENGLISH");
	}	
	
	@Test
	public void languageDropDownVerification() {
		lp = new LandingPage(driver);
		lp.languageClick().click();
		if(lp.languageClick().getAttribute("aria-expanded").contains("true")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@Test (dependsOnMethods = {"myAccountDefaultText"})
	public void languageSelection() {
		lp = new LandingPage(driver);
		List<WebElement> languageType = (List<WebElement>) lp.languageSelect();
		int countLanguage = languageType.size();
		for(int i = 0; i < countLanguage; i++) {
			String text = languageType.get(i).getText();
			if(text.equalsIgnoreCase("French")) {
				languageType.get(i).click();
				break;
			}
		}
	}
	
	@Test
	public void languageTypes() {
		lp = new LandingPage(driver);
		List<WebElement> languageType = (List<WebElement>) lp.languageSelect();
		List<String> obtainedList = new ArrayList<String>();
		int countLanguage = languageType.size();
		for(int i = 0; i < countLanguage; i++) {
			String text = languageType.get(i).getText();
			obtainedList.add(text);
		}
		List<String> sortedList = new ArrayList<String>();
		for(String s:obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);
		System.out.println(obtainedList);
		System.out.println(sortedList);
		Assert.assertTrue(sortedList.equals(obtainedList));
	}
	
	@Test
	public void myAccountDefaultText() {
		lp = new LandingPage(driver);
		Assert.assertEquals(lp.myAccount().getText(), "MY ACCOUNT");
	}
	
	@Test
	public void myAccountDropDownVerification() {
		lp = new LandingPage(driver);
		lp.myAccountClick().click();
		if(lp.myAccountClick().getAttribute("aria-expanded").contains("true")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectLogin() {
		lp = new LandingPage(driver);
		action = new Actions(driver);
		action.moveToElement(lp.selectLogin()).build().perform();
		lp.selectLogin().sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
	}
}
