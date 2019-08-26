package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	public WebDriver driver;
	
	//By NoThanks= By.className("sumome-react-wysiwyg-component sumome-react-wysiwyg-popup-button sumome-react-wysiwyg-button");
	By SignIn=By.linkText("Login");
	By title=By.cssSelector(".text-center h2");
	By NavBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	/*public WebElement noThanks()
	{
		return driver.findElement(NoThanks);
	}*/
	
	public WebElement getLogIn()
	{
		return driver.findElement(SignIn);
	}

	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement NavBar()
	{
		return driver.findElement(NavBar);
	}
}
