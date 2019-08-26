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

public class ValidateTitle extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialization() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");

	}

	@Test
	public void ValidateAppTitle()
	{
		LandingPage l = new LandingPage(driver);
		//Compare the text from the browser with actual requirement
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Title is validated");
	}
		@AfterTest
		public void teardown()
			{
			driver.close();
			driver=null;
			}
}
