package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
	
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + 
				"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
	
	if (browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + 
				"\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	} else if (browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir" + 
				"\\src\\main\\java\\resources\\geckodriver.exe"));
		driver = new FirefoxDriver();
	} else if (browser.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir" + 
				"\\src\\main\\java\\resources\\IEDriverServer.exe"));
		driver = new InternetExplorerDriver();
	} else if (browser.equalsIgnoreCase("opera")) {
		System.setProperty("webdriver.opera.driver", System.getProperty("user.dir" +
				"\\src\\main\\java\\resources\\operadriver.exe"));
		driver = new OperaDriver();
	} else if (browser.equalsIgnoreCase("edge")) {
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir" + 
				"\\src\\main\\java\\resources\\msedgedriver.exe"));
		driver = new EdgeDriver();
	}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
	}
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileHandler.copy(source, new File(destinationFile));
		return destinationFile;
	}
}

