package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DoCarting extends BaseUtils

{

	public static By ClickonAddCartButton=By.xpath("(//a[@class=\"button ajax_add_to_cart_button btn btn-default\"])[1]");
	public static By GetCartDetail=By.xpath("//span[@class=\"ajax_cart_product_txt \"]");
	public static By ContinueShopping=By.xpath("//span[@class=\"continue btn btn-default button exclusive-medium\"]");
	
	
	public static void AddCarting() 
	{	
		driver.findElement(ClickonAddCartButton).click();
		
		String beta=driver.findElement(GetCartDetail).getText();
		
		System.out.println(beta);
		driver.findElement(ContinueShopping).click();
	}
		
}
