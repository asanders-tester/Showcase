package PHPTravel.End2EndExample;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import resources.Base;

public class LandingPageHotelsTest extends Base {
	
	private LandingPage lp;
	
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
	public void verifyTabText() {
		lp = new LandingPage(driver);
		if(lp.hotelsTab().isDisplayed()) {
		Assert.assertEquals(lp.hotelsTab().getText(), "HOTELS");	
		}
	}
	
	@Test
	public void verifyTitlesText() {
		lp = new LandingPage(driver);
		List<WebElement> title = (List<WebElement>)lp.titleText();
		List<String> obtainedList = new ArrayList<String>();
		int countTitles = lp.titleText().size();
		for(int i = 0; i < countTitles; i++) {
			String text = title.get(i).getText();
			obtainedList.add(text);
		}
		List<String> actualList = new ArrayList<String>();
		actualList.add("DESTINATION");
		actualList.add("CHECK IN");
		actualList.add("CHECK OUT");
		actualList.add("ADULTS (13-75)");
		actualList.add("CHILD (2-12)");
		
		Assert.assertEquals(obtainedList, actualList);
	}
	
	@Test
	public void verifyDestinationDefaultText() {
		lp = new LandingPage(driver);
		String destinationText = lp.destinationTextBox().getText();
		Assert.assertEquals(destinationText, "Search By Hotel Or City Name");
	}
	
	@Test
	public void verifyDestinationSuggest() throws InterruptedException {
		lp = new LandingPage(driver);
		lp.destinationTextBox().click();
		lp.destinationEnterText().sendKeys("jam");
		Thread.sleep(3000);
		lp.destinationEnterText().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String destinationText = lp.destinationTextBox().getText();
		Assert.assertEquals(destinationText, "Cajamarca, Peru");
	}
	
	@Test
	public void verifyECheckinDefaultDate() {
		lp = new LandingPage(driver);
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dateFormatted = format.format(date);
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String script = "return document.getElementById(\"checkin\").value;";
		String checkinText = (String)executor.executeScript(script);
		Assert.assertEquals(checkinText, dateFormatted);
	}
	
	@Test
	public void verifyOnClickCheckin() {
		lp = new LandingPage(driver);
		lp.checkinTextBox().click();
		if(lp.checkinDropDown().getAttribute("class").contains("active")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	//Test is failing, but expected and actual text are same
	@Test
	public void checkinCalendarTitle() {
		lp = new LandingPage(driver);
		lp.checkinTextBox().click();
		String title = lp.checkinCalendarTitle().getText();
		
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("MMMMMMMMM" + "," + "yyyy");
		String dateFormatted = format.format(date);
		Assert.assertEquals(title, dateFormatted);
	}
	
	@Test (dependsOnMethods = {"checkinCalendarTitle", "verifyECheckinDefaultDate", "checkinForwardArrow"})
	public void checkinBackArrow() {
		lp = new LandingPage(driver);
		String title = lp.checkinCalendarTitle().getText();
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("MMMMMMMMM");
		String dateFormatted = format.format(date);
		if (title.contains(dateFormatted)) {
			lp.checkinBackArrow().getAttribute("class").contains("disabled");
		} else {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", lp.checkinBackArrow());
		}	
	}
	
	@Test (dependsOnMethods = {"checkinCalendarTitle", "verifyECheckinDefaultDate"})
	public void checkinForwardArrow() {
		lp = new LandingPage(driver);
		lp.checkinTextBox().click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", lp.checkinForwardArrow());
	}
	
	@Test
	public void currentDayHighlightedCheckin() {
		lp = new LandingPage(driver);
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("dd");
		String dateFormatted = format.format(date);
		if (lp.checkinCurrentDayHighlighted().getAttribute("class").contains("current")) {
			String day = lp.checkinCurrentDayHighlighted().getText();
			Assert.assertEquals(day, dateFormatted);
		}
	}
}
