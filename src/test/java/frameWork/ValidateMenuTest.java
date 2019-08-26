package frameWork;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateMenuTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialization() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void ValidateAppNavigationBar() 
	{
		LandingPage l = new LandingPage(driver);
		
		Assert.assertTrue(l.NavBar().isDisplayed());
		log.info("Menu Bar is Validated");
		
	}
		@AfterTest
		public void teardown()
			{
			driver.close();
			driver=null;
			}
}
