package paketic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactUs {
	

	public static String urlContactUs= "http://automationpractice.com/index.php?controller=contact";
	
	// XPath Strings
	
	public static String subjectHeadingXpath = "//select[@id='id_contact']";
	
	public static String emailAddressXpath = "//input[@id='email']";
	
	public static String orderReferenceXpath = "//input[@id='id_order']";
	
	
	public static String imageUploadXpath = "//input[@id='fileUpload']";
	
	public static String messageFieldXpath = "//textarea[@id='message']";
	
	public static String sendXpath = "//span[contains(text(),'Send')]";
	
	public static String sendingSuccessfulAlertXpath = "//p[@class='alert alert-success']";
	
	// auxiliary string
	
	public static String size = "1";
	
	
	// WebElement getters
	
	public static WebElement getSubjectHeading(WebDriver wd) {
		return wd.findElement(By.xpath(subjectHeadingXpath));
	}
	
	public static WebElement getEmailAddress(WebDriver wd) {
		return wd.findElement(By.xpath(emailAddressXpath));
	}
	
	public static WebElement getOrderReference(WebDriver wd) {
		return wd.findElement(By.xpath(orderReferenceXpath));
	}
	
	public static WebElement getAttachFile(WebDriver wd) {
		return wd.findElement(By.xpath(imageUploadXpath));
	}
	
	public static WebElement getSend(WebDriver wd) {
		return wd.findElement(By.xpath(sendXpath));
	}
	
	public static WebElement getMessageField(WebDriver wd) {
		return wd.findElement(By.xpath(messageFieldXpath));
	}
	
	public static WebElement getSendingSuccessfulAlert(WebDriver wd) {
		return wd.findElement(By.xpath(sendingSuccessfulAlertXpath));
	}
	
	
	//Methods
	
	public static void dropDownSubject(WebDriver wd) {
		getSubjectHeading(wd).click();
		Select dropDownMenu = new Select(wd.findElement(By.xpath(subjectHeadingXpath)));
		dropDownMenu.selectByIndex(1);
	}
	
	
	public static void sendPicture (WebDriver wd) {
		
		getAttachFile(wd).sendKeys("C:\\Users\\user\\Desktop\\HR.png");
	}
	
	
}
