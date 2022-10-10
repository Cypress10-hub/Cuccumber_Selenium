package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage extends BaseUtils{

	
	public static By SignIn=By.xpath("//a[@class=\"login\"]");
	public static By UserName=By.id("email");
	public static By Password=By.id("passwd");
	public static By SignButton=By.id("SubmitLogin");
				
//public static void initialization()
//  {
//		options = new ChromeOptions();
//		options.addArguments("--disable-notifications"); 
//		WebDriverManager.chromedriver().setup();
//		 driver = new ChromeDriver(options);
//		driver.get("http://automationpractice.com/index.php");
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);		
//	}

 public static void LoginwithUserNameandPassword()
   {
	 driver.findElement(SignIn).click();
	driver.findElement(UserName).sendKeys("mohsin.altaf28@gmail.com");
	 driver.findElement(Password).sendKeys("Mohsin@1234");
	 
   }
 
 public static void ClickOnSignButton()
   {
	 
	 driver.findElement(SignButton).click();
	 }
 
 public static void LoginwithInvalidUserNameandPassword()
 {
	 driver.findElement(SignIn).click();
driver.findElement(UserName).sendKeys("mohsin.altaf27gmail.com");
	 driver.findElement(Password).sendKeys("Mohsin@1234");
	 
 }
 public static void LoginwithdUserNameandInvalidPassword()
 {
	 driver.findElement(SignIn).click();
	driver.findElement(UserName).sendKeys("mohsin.altaf28@gmail.com");
	 driver.findElement(Password).sendKeys("Mohsin1234");
	 
 }
}

