package test.java.bIntro;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class YahooSearchMethods {

	static WebDriver driver;

	public static void main(String[] args) {
		setUp("chrome", "http://www.yahoo.com");

		searchYahoo("Selenium");
		
		clickLink("/html/body/div[1]/div[3]/div/div/div[1]/div/div/div/div/ol/li[1]/div/div[1]/h3/a");
		selectPopUp();

		clickLink("//a[@href='/downloads']");

		
		closeBrowser();

	}

	private static void selectPopUp() {
		ArrayList<String> windowIds = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Number of windows: " + windowIds.size());

		for(String windowId: driver.getWindowHandles()) {
			driver.switchTo().window(windowId);
		}
		
	}

	private static void clickLink(String linkText) {
		WebElement link = driver.findElement(By.xpath(linkText));
		link.click();
		
	}

	private static void searchYahoo(String topic) {//metodo para buscar elementos
		//busqueda
		WebElement searchBox = driver.findElement(By.id("ybar-sbq"));
		WebElement searchButton = driver.findElement(By.id("ybar-search"));

		searchBox.clear();
		searchBox.sendKeys(topic);
		searchButton.click();


	}

	private static void setUp(String browser, String url) {//metodo para abrir el navegador
		switch(browser) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "/usr/jnavarro/test");
			driver = new ChromeDriver();
			break;
		case "firefox":
			
			driver = new FirefoxDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Ese browser no existe");
			System.exit(-1);
		}
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		driver.get(url);

	}
	
	private static void closeBrowser() {//metodo para cerrar
		driver.close();
	}

}
