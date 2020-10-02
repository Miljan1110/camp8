package paketic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Home {

	public static String urlGlavna= "http://automationpractice.com/index.php";
	
	public static String summerDressesUrl = "http://automationpractice.com/index.php?id_category=11&controller=category";
	
	//XPath strings
	
	public static String contactUsUpXpath = "//div[@id='contact-link']//a[contains(text(),'Contact us')]";
	public static String signInXPath = "//a[@class='login']";
	public static String cartXpath = "//span[@class='ajax_cart_no_product']";
	public static String searchBarXpath = "//input[@id='search_query_top']";
	public static String searchButtonXpath = "//button[@name='submit_search']";
	public static String womanOptionXpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]";
	
	
	public static String summerDressesizWomanXpath = "//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'Summer Dresses')]";
	public static String summerDressesizDressesXPath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[3]/a[1]";
	
	
	public static String dressesOptionXpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]";
	public static String tShirtOptionXpath = "//li[@class='sfHover']//a[contains(text(),'T-shirts')]";
	public static String popularXpath = "//li[@class='sfHover']//a[contains(text(),'T-shirts')]";
	public static String bestSellerXpath = "http://automationpractice.com/index.php#blockbestsellers";
	public static String facebookXpath = "//li[@class='facebook']//a";
	public static String twitterXpath = "//li[@class='twitter']";
	public static String youtubeXpath = "//li[@class='youtube']";
	public static String googlePlusXpath = "//li[@class='google-plus']";
	
	// social media links
	
	public static String facebookLink = "https://www.facebook.com/groups/525066904174158/";
	public static String twitterLink = "https://twitter.com/seleniumfrmwrk";
	public static String youtubeLink = "https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA";
	public static String googlePlusLink = "https://plus.google.com/111979135243110831526/posts";
	
	// auxiliary string

	public static java.lang.String s;
	
 // WebElement getters
	
    public static WebElement getContactUsUpXpath(WebDriver wd) {
        return wd.findElement(By.xpath(contactUsUpXpath));
    }
	
    public static WebElement getSearchBarXpath(WebDriver wd) {
    	return wd.findElement(By.xpath(searchBarXpath));
    }
    
    public static WebElement getSearchButtonXpath(WebDriver wd) {
    	return wd.findElement(By.xpath(searchButtonXpath));
    }
    
    public static WebElement getWomanOption (WebDriver wd) {
    	return wd.findElement(By.xpath(womanOptionXpath));
    }
    
    public static WebElement getSummerDressesizWoman (WebDriver wd) {
    	return wd.findElement(By.xpath(summerDressesizWomanXpath));
    }
    
    public static WebElement getSummerDressesizDresses (WebDriver wd) {
    	return wd.findElement(By.xpath(summerDressesizDressesXPath));
    }
    
 public static WebElement getDressesOption (WebDriver wd) {
	 return wd.findElement(By.xpath(dressesOptionXpath));
 }
    
 public static WebElement getFacebook(WebDriver wd) {
 	return wd.findElement(By.xpath(facebookXpath));
 }
 
 public static WebElement getTwitter(WebDriver wd) {
 return wd.findElement(By.xpath(twitterXpath));}
 
 public static WebElement getYoutube(WebDriver wd) {
 	return wd.findElement(By.xpath(youtubeXpath));
 }
	
public static WebElement getGoogleplus(WebDriver wd) {
	return wd.findElement(By.xpath(googlePlusXpath));}


//click methods

public static void clickFacebook(WebDriver wd) {
	Actions akcija = new Actions(wd);
	akcija.moveToElement(getFacebook(wd)).perform();
    getFacebook(wd).click();
}

public static void clickTwitter(WebDriver wd) {
	Actions akcija = new Actions(wd);
	akcija.moveToElement(getTwitter(wd)).perform();
    getTwitter(wd).click();
}

public static void clickYoutube(WebDriver wd) {
	Actions akcija = new Actions(wd);
	akcija.moveToElement(getYoutube(wd)).perform();
    getYoutube(wd).click();
}

public static void clickGooglePlus(WebDriver wd) {
	Actions akcija = new Actions(wd);
	akcija.moveToElement(getGoogleplus(wd)).perform();
    getGoogleplus(wd).click();
}


// drag and click methods
    
    public static WebDriver dragAndClickWoman(WebDriver wd) {
    	//WebDriver wd = Utility.getDriver();
    	Actions akcija = new Actions (wd);
    	
    	akcija.moveToElement(getWomanOption(wd)).moveToElement(getSummerDressesizWoman(wd)).click().perform();
    	return wd;
    	}

public static WebDriver dragAndClickDresses(WebDriver wd ) {
	Actions akcija = new Actions(wd);
	
	akcija.moveToElement(getDressesOption(wd)).moveToElement(getSummerDressesizDresses(wd)).click().perform();
	return wd;
	
}


}	
    	

   
	

