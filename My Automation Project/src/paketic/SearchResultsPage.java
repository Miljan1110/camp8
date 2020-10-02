package paketic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
	
	public static String urlSearchResultsPage = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=yellow&submit_search=";
	
// String
	
public static String numberOfResultsClassName = "heading-counter";


// WebElement getter

public static WebElement getNumberOfResultsClassName(WebDriver wd) {
	return wd.findElement(By.className(numberOfResultsClassName));
}



}
