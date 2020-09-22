package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LandingPage {
	
	private WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	//header
	private By companyLogo = By.xpath("//div[@class='header-logo go-right']//a//img");
	private By backToHome = By.cssSelector("a[title='home']");
	private By company = By.cssSelector("span[class='arrow-indicator']");
	private By companyDropDown = By.xpath("//ul[@style='display: block;']");
	private By contact = By.linkText("Contact");
	private By aboutUs = By.linkText("About Us");
	private By callNow = By.cssSelector("div[class='navbar-phone d-none d-lg-block o1']");
	private By currency = By.xpath("//div[@class='dropdown dropdown-currency']//a[@id='dropdownCurrency']");
	private By currencyClick = By.xpath("/html/body/div[2]/header/div[1]/div/div/div[2]/div/ul/li[1]/div/a");
	private By currencySelect = By.xpath("//div[@class='dropdown-menu dropdown-menu-right show']//div[@class='dropdown-menu-inner']//a[@class='dropdown-item text-center']");
	private By language = By.xpath("/html/body/div[2]/header/div[1]/div/div/div[2]/div/ul/li[2]/div");
	private By languageClick = By.xpath("/html/body/div[2]/header/div[1]/div/div/div[2]/div/ul/li[2]/div/a");
	private By languageSelect = By.cssSelector("a[class='dropdown-item']");
	private By myAccount = By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']");
	private By myAccountClick = By.xpath("/html/body/div[2]/header/div[1]/div/div/div[2]/div/ul/li[3]/div/a");
	private By myAccountSelectLogin = By.linkText("Login");
	
	//hotels
	private By hotelsTab = By.cssSelector("a[class='text-center hotels active']");
	private By titleText = By.cssSelector("label[class='fr']");
	private By destinationTextBox = By.xpath("//div[@id='s2id_autogen16']");
	private By destinationEnterText = By.xpath("/html/body/div[6]/div/input");
	private By checkinTextBox = By.xpath("//input[@id='checkin']");
	private By checkinDropDown = By.xpath("//body[@class='with-waypoint-sticky']/div[@id='datepickers-container']/div[1]");
	private By checkinCalendarTitle = By.xpath("//div[1]//nav[1]//div[2]");
	private By checkinBackArrow = By.xpath("/html/body/div[3]/div[1]/nav/div[1]");
	private By checkinForwardArrow = By.xpath("//div[1]//nav[1]//div[3]");
	private By checkinCurrentDay = By.cssSelector("div[class='datepicker--cell datepicker--cell-day']");
	
	
	//header
	public WebElement companyLogo() {
		return driver.findElement(companyLogo);
	}
	
	public WebElement backToHome() {
		return driver.findElement(backToHome);
	}
	
	public WebElement company() {
		return driver.findElement(company);
	}
	
	public WebElement companyDropDown() {
		return driver.findElement(companyDropDown);
	}
	
	public WebElement contact() {
		return driver.findElement(contact);
	}
	
	public WebElement aboutUs() {
		return driver.findElement(aboutUs);
	}
	
	public WebElement callNow() {
		return driver.findElement(callNow);
	}
	
	public WebElement currency() {
		return driver.findElement(currency);
	}
	
	public WebElement currencyClick() {
		return driver.findElement(currencyClick);
	}
	
	public List<WebElement> currencySelect() {
		return driver.findElements(currencySelect);
	}
	
	public WebElement language() {
		return driver.findElement(language);
	}
	
	public WebElement languageClick() {
		return driver.findElement(languageClick);
	}
	
	public List<WebElement> languageSelect() {
		return driver.findElements(languageSelect);
	}
	
	public WebElement myAccount() {
		return driver.findElement(myAccount);
	}
	
	public WebElement myAccountClick() {
		return driver.findElement(myAccountClick);
	}
	
	public WebElement selectLogin() {
		return driver.findElement(myAccountSelectLogin);
	}
	
	//hotels
	public WebElement hotelsTab() {
		return driver.findElement(hotelsTab);
	}
	
	public List<WebElement> titleText() {
		return driver.findElements(titleText);
	}
	
	public WebElement destinationTextBox() {
		return driver.findElement(destinationTextBox);
	}
	
	public WebElement destinationEnterText() {
		return driver.findElement(destinationEnterText);
	}
	
	public WebElement checkinTextBox() {
		return driver.findElement(checkinTextBox);
	}
	
	public WebElement checkinDropDown() {
		return driver.findElement(checkinDropDown);
	}
	
	public WebElement checkinCalendarTitle() {
		return driver.findElement(checkinCalendarTitle);
	}
	
	public WebElement checkinBackArrow() {
		return driver.findElement(checkinBackArrow);
	}
	
	public WebElement checkinForwardArrow() {
		return driver.findElement(checkinForwardArrow);
	}
	
	public WebElement checkinCurrentDayHighlighted() {
		return driver.findElement(checkinCurrentDay);
	}
}

