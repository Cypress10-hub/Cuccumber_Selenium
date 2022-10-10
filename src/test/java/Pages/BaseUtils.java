package Pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtils {

	public static WebDriver driver=null;	
	public static ChromeOptions options;
	public static By SignIn=By.xpath("//a[@class=\"login\"]");
	
	
	public void initilization()
	
	{
		options = new ChromeOptions();
		options.addArguments("--disable-notifications"); 
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver(options);
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
		driver.findElement(SignIn).click();
		
	}
	
	public static String getScreenShot(WebDriver driver)
	{
TakesScreenshot ts=(TakesScreenshot)driver;
File src=ts.getScreenshotAs(OutputType.FILE);
String path=System.getProperty("C:/Users/mohsin.muhammadali/eclipse-workspace/CuccumberSelenium/src/test/resources/ScreenShots");
File destination=new File(path);
try
{
	FileUtils.copyFile(src, destination);
}
catch(IOException e)
{
	System.out.println("Capture Failed" +e.getMessage());
}


return path;
}
	
}

