package genericUtiliyy;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.WelcomePage;

public class Baseclass {
	
	public static WebDriver driver;
	
	public Javautility jutil=new Javautility();
	public Webdriverutility wutil=new Webdriverutility();
	public Fileutility futil=new Fileutility();
	public Excelutility eutil=new Excelutility();
	
	@BeforeClass
	
	public void openBrowser() throws IOException
	{
		driver=new ChromeDriver();
		wutil.maximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(futil.getDataFromProperty("url"));
	}
	
	@BeforeMethod
	
	public void login() throws IOException
	{
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		LoginPage lp=new LoginPage(driver);
		lp.getEmailTextField().sendKeys(futil.getDataFromProperty("email"));
		lp.getPasswordTextField().sendKeys(futil.getDataFromProperty("password"));
		lp.getLoginButton().click();
		}
		
		@AfterMethod
		public void logout()
		
		{
			HomePage hp = new HomePage(driver);
			hp.getLogoutLink().click();
		}
		@AfterClass
		
		public void closeBrowser()
		{
			driver.quit();
		}
		
		
		
	}

