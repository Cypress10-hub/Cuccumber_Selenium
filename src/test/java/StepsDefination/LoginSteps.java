package StepsDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.BaseUtils;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps extends BaseUtils{
	
	//public static WebDriver driver;

//	public static WebDriver driver=null;	
//	public static ChromeOptions options;
	
	public static By SignIn=By.xpath("//a[@class=\"login\"]");
	public static By UserName=By.id("email");
	public static By Password=By.id("passwd");
	public static By SignButton=By.id("SubmitLogin");
	public static By GetUserName= By.xpath("//a[@class=\"account\"]");
	public static By FailedMsg=By.xpath("(//div[@class=\"alert alert-danger\"])[1]");
	String URL="http://automationpractice.com/index.php?controller=my-account";
	
	
	 

	LoginPage login =new LoginPage();
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
		initilization();
		
			
//			options = new ChromeOptions();
//			options.addArguments("--disable-notifications"); 
//			WebDriverManager.chromedriver().setup();
//			 driver = new ChromeDriver(options);
//			driver.get("http://automationpractice.com/index.php");
//			driver.manage().window().maximize();
//			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
//			driver.findElement(SignIn).click();
		}
	// (.*)' and '(.*)'$
	@And("^user enter correct username and password$")
	public void user_enter_correct_username_and_password()
	{
		
		//LoginPage login =new LoginPage();
		LoginPage.LoginwithUserNameandPassword();
	
		
//			driver.findElement(UserName).sendKeys("mohsin.altaf28@gmail.com");
//			 driver.findElement(Password).sendKeys("Mohsin@1234");	
//			 Thread.sleep(2000);
	}

	@And("^user clicks on login button$")
	public void user_clicks_on_login_button() throws InterruptedException
	{
		LoginPage.ClickOnSignButton();
	}

	@Then("^user is navigated to the home page$")
	public void user_is_navigated_to_the_home_page() {
		String UserName= driver.findElement(GetUserName).getText();
		
		String URLlink= driver.getCurrentUrl();
	
		if(driver.getTitle().equalsIgnoreCase("My account - My Store")&& UserName.equalsIgnoreCase("Mohsin Ali")&& driver.getCurrentUrl().contains(URL))
		{
		
			Assert.assertTrue(true);
		
		}
		else 
		{
			Assert.assertTrue(false);
			System.out.println("Login is failed");
			
		}
		driver.quit();
	}

@When("^user enter incorrect username and password$")
public void user_enter_incorrect_username_and_password() {
	 //driver.findElement(SignIn).click();
	//LoginPage page=new LoginPage();
	LoginPage.LoginwithInvalidUserNameandPassword();
}

@Then ("^user should not navigate to the home page$")
public void user_should_not_Navigate_to_the_home_page()
{
	//String UserName1= driver.findElement(GetUserName).getText();
	String errormsg=driver.findElement(FailedMsg).getText();
	//errormsg.contains("Authentication failed.")&&
	if (driver.getCurrentUrl().contains(URL))
	
			{
				
		Assert.assertTrue(true);
		
			}
			else 
				
			{
				if(errormsg.contains("Authentication failed."))
				Assert.assertTrue(false);
				System.out.println(errormsg);
				 getScreenShot(driver);
				driver.quit();
			}	
	
}

@When("user enter correct username and invalid password")
public void user_enter_correct_username_and_invalid_password()
{
	
 LoginPage.LoginwithdUserNameandInvalidPassword();  

}

}
