package Pages;

import org.openqa.selenium.By;

public class Search extends BaseUtils{
	
public static By SearchText=By.id("search_query_top");
public static By ClickOnSearch=By.name("submit_search");
	
	public static void Searchitem()
	
	{
		
		driver.findElement(SearchText).sendKeys("Printed Summer dresse");
	}

	
	public static void SearchClick()
	{
		
		driver.findElement(ClickOnSearch).click();
		
	}
	
	 
}
