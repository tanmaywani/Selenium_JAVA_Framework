package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
    public static WebDriver driver;
    public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\tanmay\\Desktop\\Selenium\\WorkSpace\\E2E_Framework\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		prop.getProperty("browser");
		String browserName = prop.getProperty("browser");
		if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\tanmay\\Desktop\\Selenium\\FIREFOX\\64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\tanmay\\Desktop\\Selenium\\CHROME\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", 
					"C:\\Users\\tanmay\\Desktop\\Selenium\\IE\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\tanmay\\Desktop\\Framework\\framework_learning\\E2E_Framework\\screenshot\\"+result+"screenshot.png"));
		
	}
	
}