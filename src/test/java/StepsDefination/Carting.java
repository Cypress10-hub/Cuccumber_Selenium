package StepsDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Pages.BaseUtils;
import Pages.DoCarting;
import Pages.Search;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Carting extends BaseUtils

{
	public static By MouseOveronCart=By.className("col-sm-4 clearfix");
	public static By CartMouseOver=By.xpath("//span[@class=\"ajax_cart_quantity unvisible\"]");
	public static By RemoveItem=By.xpath("(//a[@class=\"ajax_cart_block_remove_link\"])");
	public static By EmptyCart=By.xpath("//span[@class=\"ajax_cart_no_product\"]");
	public static By UpdateCart=By.xpath("//span[@class=\"ajax_cart_quantity\"]");
	public static By QuantityOfItems=By.xpath("//span[@id=\"layer_cart_product_quantity\"]");
	public static By CartItems=By.xpath("//span[@class=\"ajax_cart_product_txt_s  unvisible\"]");
	
	
//	------------------------------------- Add Carting------------------------
	
	@And("^user add an item in the cart$")
	public void user_add_an_item_in_the_cart() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");

		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("((//a[@class=\"product_img_link\"])[1])"));
		//Performing the mouse hover action on the target element.
		action.moveToElement(element).build().perform();
		DoCarting.AddCarting();
		System.out.println("Item has been added in the cart");
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-350)");
		Actions action1 = new Actions(driver);
	    WebElement CartOver= driver.findElement(By.xpath("//a[@title=\"View my shopping cart\"]"));
	    action1.moveToElement(CartOver).build().perform();
		
	}

	@Then("^system should add the item$")
	public void system_should_add_the_item() 
	{
	    
		String product=driver.findElement(CartMouseOver).getText();
		   if(product != null)
		   {
			   System.out.println(product +"Product has been added in the cart");	 
			   Assert.assertTrue(true);
		   }
		   else
		   {
			   
			   System.out.println(product +"Product has not been added in the cart");
			   Assert.assertTrue(false);
			   getScreenShot(driver);
		   }
		   driver.quit();
	}
	
//	------------------------------------- Delete Carting------------------------
	
	@When("^user again deletes that item$")
	public void user_again_deletes_that_item() {
		
		driver.findElement(RemoveItem).click();
	   
	}

	@Then("^system should delete the item")
	public void system_should_delete_the_item() {
	
		String emp=driver.findElement(EmptyCart).getText();
		if(emp.isEmpty())
		{
			System.out.println("Item has been deleted from cart");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Item has not been deleted from cart");
			Assert.assertTrue(false);
		}
		driver.quit();
	}
//	------------------------------------- Update Carting------------------------
	
	@When("^user again updates an item in the cart$")
	public void user_again_updates_an_item_in_the_cart() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
//------------------------------ scroll Window down	-------------------------------------	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");

		Thread.sleep(2000);
//----------------------------- Mouse over on Dress to add into the cart---------------------------		
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("((//a[@class=\"product_img_link\"])[1])"));
		//Performing the mouse hover action on the target element.
		action.moveToElement(element).build().perform();
		DoCarting.AddCarting();
		System.out.println("Item is added in the cart");
		
//----------------------------Scroll Window Up------------------------------------------------------		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-350)");
		Actions action1 = new Actions(driver);
	    WebElement CartOver= driver.findElement(By.xpath("//a[@title=\"View my shopping cart\"]"));
	    action1.moveToElement(CartOver).build().perform();	
	}

	@Then("^system should update the cart$")
	public void system_should_update_the_cart() 
	
	{
		String CartMessage="There are 2 items in your cart.";
		String quanitity=driver.findElement(QuantityOfItems).getText();
		String text=driver.findElement(CartItems).getText();
		System.out.println("Cart is updated with "+quanitity+"Items");
		if((quanitity!=null)&& text.contains(CartMessage))
		{
			
			Assert.assertTrue(true);
			System.out.println(text);
		}
		else {
			
			Assert.assertTrue(false);
		}
	  driver.quit();
	}
	
}
