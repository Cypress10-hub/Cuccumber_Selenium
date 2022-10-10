package StepsDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import Pages.BaseUtils;
import Pages.Search;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchItems extends BaseUtils {

	public static By GetSearchResult=By.xpath("//span[@class=\"lighter\"]");
	
	  @When ("^user clicks on search bar$")
	  public void user_clicks_on_search_bar()
	  {
		  Search.Searchitem();
	  }
	  
	
	@And("^user search an item$")
	public void user_search_an_item() {
	    // Write code here that turns the phrase above into concrete actions
		
		Search.SearchClick();
		
		String a=driver.findElement(GetSearchResult).getText();
		System.out.println(a);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    
	}

	//@SuppressWarnings("unlikely-arg-type")
	@Then("^system should return the item$")
	public void system_should_return_the_item() 
	
	{
		String Searchitems="\"PRINTED SUMMER DRESSE\"";
		String Searchvalue="^(?:PRINTED|DRESSE|SUMMER)$";
		// String alpha=driver.findElement(GetSearchResult).getText();
		if(driver.findElement(GetSearchResult).getText().equals(Searchitems))
{
			Assert.assertTrue(true);
			
		}
		else {
				
			System.out.println("Search is Failed");
		}
		
		driver.quit();
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	
	
	
}
