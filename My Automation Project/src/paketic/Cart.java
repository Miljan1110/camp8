package paketic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
	
	public static String urlCart = "http://automationpractice.com/index.php?controller=order";
	
	// XPath Strings
	
	public static String dressNameXpath = "//td[@class='cart_description']//a[contains(text(),'Printed Summer Dress')]";
	public static String quantityXpath = "//input[@name='quantity_6_40_0_0']";
	public static String dressColorAndSizeXpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/small[2]/a[1]";
	
	
	// getters
	
	public static String getDressName(WebDriver wd) {
		  wd.get(urlCart);//mozda nepotrebna
		 
		return wd.findElement(By.xpath(dressNameXpath)).getText();
		
	}
	
	public static String getQuantity(WebDriver wd) {
		return wd.findElement(By.xpath(quantityXpath)).getAttribute("value"); 
	  }
	
	public static String getColor (WebDriver wd) {
		
				if (wd.findElement(By.xpath(dressColorAndSizeXpath)).getText().contains("White")) {
					return "White";}
					else return "";
				} 
	
	public static String getSize(WebDriver wd) {
		if (wd.findElement(By.xpath(dressColorAndSizeXpath)).getText().contains("Size : M")) {
			return "M";}
		else return "";
		}
	}
	
	
	
	


