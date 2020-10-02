package paketic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PrintedSummerDress {
	
	public static String urlPrintedSummerDress = "http://automationpractice.com/index.php?id_product=6&controller=product";
	
	//Xpath Strings
	
	public static String quantityPlusXpath = "//a[@class='btn btn-default button-plus product_quantity_up']//span";
	
	public static String addToCartXpath = "//span[contains(text(),'Add to cart')]";
	
	public static String colorWhiteXpath = "//a[@id='color_8']";
	
	public static String proceedToCheckoutXpath = "//span[contains(text(),'Proceed to checkout')]";
	
	public static String drpDownMenuXpath = "//select[@id='group_1']";
	
	//Auxiliary Strings
	
	public static String sizeM = "M";
	
	public static String dressName = "Printed Summer Dress";
	
	//WebElement getters
	
	public static WebElement getdropDownMenu (WebDriver wd) {
		return wd.findElement(By.xpath(drpDownMenuXpath));
	}
	
	public static WebElement getColorWhite(WebDriver wd) {
		return wd.findElement(By.xpath(colorWhiteXpath));
	}
	
	
	public static WebElement getQuantityPlusXpath(WebDriver wd) {
		return wd.findElement(By.xpath(quantityPlusXpath));
		}
	
		public static WebElement getAddToCart(WebDriver wd) {
			return wd.findElement(By.xpath(addToCartXpath));
			
		}
		
		public static WebElement getProceedToCheckout(WebDriver wd) {
			return wd.findElement(By.xpath(proceedToCheckoutXpath));
		}
		
	
		/*
		 * Odabrati drugu haljinu koja se nalazi u Summer Dresses ponudi. Staviti u
		 * korpu dve takve haljine, M velièine u beloj boji.
		 */
	
		
		// Methods
	
	public static void uzmiHaljine(WebDriver wd) throws InterruptedException {
		wd.get(urlPrintedSummerDress);
		getColorWhite(wd).click();
		getQuantityPlusXpath(wd).click();
		Select dropSize = new Select (getdropDownMenu(wd));
		dropSize.selectByVisibleText(sizeM);
		getAddToCart(wd).click();
		Thread.sleep(3000);
		getProceedToCheckout(wd).click();
		
	}

}
