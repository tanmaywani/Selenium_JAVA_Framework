package frameWork;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePageTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeMethod
	public void initialization() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text)
	{
		LandingPage l = new LandingPage(driver);
		//l.noThanks().click();
		l.getLogIn().click();
		log.info("Navigated to login page");
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		log.info("Entered User name and password");
		System.out.println(text);
		lp.LogIn().click();
		log.info("Click on Submit Button");
		
	}
	
	@AfterMethod
	public void teardown()
		{
		driver.close();
		driver=null;
		}

	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//columns stands for how many values per test
		//1st row
		Object[][] data = new Object[2][3];
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="qwqwqw";
		data[0][2]="Non Restricted user";
		//2nd row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="qwqwqww";
		data[1][2]="Restricted User";
		
		return data;
	}
}
