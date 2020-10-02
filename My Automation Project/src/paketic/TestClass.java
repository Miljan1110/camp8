package paketic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestClass {

	/*
	 * Testira se sajt http://automationpractice.com/index.php. Za rad sa elementima
	 * koji se nalaze na web stranici koristiti Selenium, a za pisanje testova
	 * TestNG. Primeniti Page Object Model.
	 */

	private static WebDriver d = new ChromeDriver();
	private static SoftAssert sa = new SoftAssert();

	@BeforeMethod
	public static void setDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		d.get(Home.urlGlavna);
		d.manage().window().maximize();
	}

	@Test

	public void test1() {

		/*
		 * Testirati da li kada se na poèetnoj stranici sajta mišem stane na dugme
		 * WOMEN, a zatim odatle odabere SummerDresses odlazi na korektnu stranu.
		 */

		sa.assertEquals(Home.dragAndClickWoman(d).getCurrentUrl(), Home.summerDressesUrl);

	}

	@Test
	public void test2() {

		/*
		 * Testirati da li kada se na poèetnoj stranici sajta mišem stane na dugme
		 * DRESSES, a zatim odatle odabere SUMMER DRESSES odlazi na korektnu stranu.
		 */

		sa.assertEquals(Home.dragAndClickDresses(d).getCurrentUrl(), Home.summerDressesUrl);

	}

	@Test

	public void test3() {
		/* Proverite da li prethodne dve taèke vode na istu stranicu. */
		sa.assertEquals(Home.dragAndClickDresses(d).getCurrentUrl(), Home.dragAndClickWoman(d).getCurrentUrl());

	}

	@Test

	public void test5IZahtev4() throws InterruptedException {
		/*
		 * Odabrati drugu haljinu koja se nalazi u Summer Dresses ponudi. Staviti u
		 * korpu dve takve haljine, M velièine u beloj boji. Proveriti da li se u korpi
		 * zaista nalaze dve haljine sa odgovarajuæim nazivom, u beloj boji, M velièine.
		 */

		PrintedSummerDress.uzmiHaljine(d);
		Thread.sleep(4000);
		sa.assertEquals(Cart.getColor(d), "White");
		sa.assertEquals(Cart.getDressName(d), PrintedSummerDress.dressName);
		sa.assertEquals(Cart.getSize(d), "M");

	}

	@Test

	public void test6() throws InterruptedException {

		/*
		 * Testirati da li radi ‘search’ bar. Ukucati ‘yellow’ i ispitati rezultat
		 * pretrage. Oèekivan ishod je prikaz tri artikla, pri èemu svaki od njih ima
		 * moguænost odabira žute boje.
		 */

		boolean zuta = false;
		Home.getSearchBarXpath(d).sendKeys("yellow");
		Home.getSearchButtonXpath(d).click();
		Thread.sleep(4000);
		String numberOfResults = SearchResultsPage.getNumberOfResultsClassName(d).getText();
		sa.assertEquals(numberOfResults, "3 results have been found.");
		java.util.List<WebElement> rezultati = d.findElements(By.className("color_to_pick_list"));
		for (int i = 0; i < rezultati.size(); i++) {
			java.util.List<WebElement> rezultatiZuta = rezultati.get(i).findElements(By.className("color_pick"));
			for (int j = 0; j < rezultatiZuta.size(); j++) {
				if (rezultatiZuta.get(j).getAttribute("style").contains("background: #F1C40F;"))

					zuta = true;
			}
		}

		sa.assertEquals(zuta, true);
	}

	@Test

	public static void test7() throws InterruptedException {

		/* Kliknuti na “Contact us” i proveriti formu za slanje korisnièkih pitanja. */

		String sendingSuccessful = "Your message has been successfully sent to our team.";
		d.get(ContactUs.urlContactUs);
		Thread.sleep(3000);
		ContactUs.dropDownSubject(d);
		ContactUs.getEmailAddress(d).sendKeys("miljanbiocanin@bootcamp8.com");
		ContactUs.getOrderReference(d).sendKeys("referenca 5");
		// ContactUs.sendPicture(d); Thread.sleep(4000);
		ContactUs.getMessageField(d).sendKeys("Ovo je poruka.");
		ContactUs.getSend(d).click();
		Thread.sleep(5000);
		String provera = ContactUs.getSendingSuccessfulAlert(d).getText();
		sa.assertEquals(provera, sendingSuccessful);
	}

	@Test

	public void test8() throws InterruptedException {

		/*
		 * Proveriti da li ikonice koje se nalaze u meniju na kraju stranice vode na
		 * odgovarajuæe adrese (ikonice za Facebook, Twitter, YouTube...)
		 */

		Thread.sleep(1000);
		Home.getFacebook(d);
		Home.clickFacebook(d);
		String newWindow = d.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(d.getWindowHandles());
		d.switchTo().window(tabs.get(1)); // novo tab
		d.get(d.getCurrentUrl());
		sa.assertEquals(d.getCurrentUrl(), Home.facebookLink);
	}

	@Test
	public void test8a() throws InterruptedException {
		Thread.sleep(1000);
		Home.getTwitter(d);
		Home.clickTwitter(d);
		String newWindow = d.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(d.getWindowHandles());
		d.switchTo().window(tabs.get(1));
		// switches to new tab d.get(d.getCurrentUrl());
		sa.assertEquals(d.getCurrentUrl(), Home.twitterLink);
	}

	@Test
	public void test8b() throws InterruptedException {

		Thread.sleep(1000);
		Home.getYoutube(d);
		Home.clickYoutube(d);
		String newWindow = d.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(d.getWindowHandles());
		d.switchTo().window(tabs.get(1));
		d.get(d.getCurrentUrl());
		sa.assertEquals(d.getCurrentUrl(), Home.youtubeLink);

	}

	@Test
	public void test8c() throws InterruptedException {
		Thread.sleep(1000);
		Home.getGoogleplus(d);
		Home.clickGooglePlus(d);
		String newWindow = d.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(d.getWindowHandles());
		d.switchTo().window(tabs.get(1));
		d.get(d.getCurrentUrl());
		sa.assertEquals(d.getCurrentUrl(), Home.googlePlusLink);
	}

	@Test
	public void test9() throws InterruptedException {

		/*
		 * Pronaæi kako da se automatski izgeneriše set podataka, i kreirati xlsx ili
		 * xls fajl koji je popunjen podacima potrebnim za slanje 30 pitanja.
		 */

		XSSFWorkbook wb;
		FileInputStream file;
		String sendingSuccessful = "Your message has been successfully sent to our team.";

		try {
			file = new FileInputStream("MOCK_DATA.xlsx");
			wb = new XSSFWorkbook(file);

			XSSFSheet list = wb.getSheetAt(0);

			for (int i = 1; i <= 30; i++) {
				Row red = list.getRow(i);
				d.get(ContactUs.urlContactUs);
				Thread.sleep(3000);
				ContactUs.dropDownSubject(d);
				ContactUs.getEmailAddress(d).click();//
				Cell celija = red.getCell(0);
				ContactUs.getEmailAddress(d).sendKeys(celija.toString());
				ContactUs.getOrderReference(d).click();//
				Cell celija2 = red.getCell(1);
				WebElement inputOrderReference = d.findElement(By.xpath(ContactUs.orderReferenceXpath));
				inputOrderReference.sendKeys(celija2.toString());
				ContactUs.sendPicture(d);

				Cell celija3 = red.getCell(2);

				ContactUs.getMessageField(d).sendKeys(celija3.toString());
				ContactUs.getSend(d).click();
				Thread.sleep(3000);
				WebElement tekstPoruke = d.findElement(By.xpath(ContactUs.sendingSuccessfulAlertXpath));
				String provera = tekstPoruke.getText();
				sa.assertEquals(provera, sendingSuccessful);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test10() throws InterruptedException {

		/*
		 * Poslati 30 pitanja pri èemu se podaci o svakoj poruci èitaju iz xlsx ili xls
		 * fajla. Za svaku poruku proveriti da li je slanje bilo uspešno.
		 */

		XSSFWorkbook wb;
		FileInputStream file;
		String sendingSuccessful = "Your message has been successfully sent to our team.";

		try {
			file = new FileInputStream("MOCK_DATA.xlsx");
			wb = new XSSFWorkbook(file);

			XSSFSheet list = wb.getSheetAt(0);

			for (int i = 1; i <= 30; i++) {
				Row red = list.getRow(i);
				d.get(ContactUs.urlContactUs);
				Thread.sleep(3000);
				ContactUs.dropDownSubject(d);
				ContactUs.getEmailAddress(d).click();//
				Cell celija = red.getCell(0);
				ContactUs.getEmailAddress(d).sendKeys(celija.toString());
				ContactUs.getOrderReference(d).click();//
				Cell celija2 = red.getCell(1);
				WebElement inputOrderReference = d.findElement(By.xpath(ContactUs.orderReferenceXpath));
				inputOrderReference.sendKeys(celija2.toString());
				ContactUs.sendPicture(d);

				Cell celija3 = red.getCell(2);

				ContactUs.getMessageField(d).sendKeys(celija3.toString());
				ContactUs.getSend(d).click();
				Thread.sleep(3000);
				WebElement tekstPoruke = d.findElement(By.xpath(ContactUs.sendingSuccessfulAlertXpath));
				String provera = tekstPoruke.getText();
				sa.assertEquals(provera, sendingSuccessful);
				sa.assertAll();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass

	public static void closeDriver() {
		d.close();
	}

}