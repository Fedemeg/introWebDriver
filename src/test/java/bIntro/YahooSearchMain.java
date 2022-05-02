package test.java.bIntro;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooSearchMain {
	
	

	
	public static void main(String[] args) {
		//INICIALIZACION DE SYSTEM.SETPROPERTY()
	    WebDriver driver;
		driver = new ChromeDriver();  //arranca el navegador, obvio Chrome
		driver.manage().timeouts().implicitlyWait(5,  TimeUnit.SECONDS); //configura las esperas implicitas hasta 5 segundos
		driver.get("http://www.yahoo.com"); //navega a la url que le indiquemos
		WebElement searchBox = driver.findElement(By.id("ybar-sbq"));//busca un campo de busqueda usando el ID
		WebElement searchButton = driver.findElement(By.id("ybar-search"));//busca el boton de busqueda por el ID
		
		searchBox.clear();//limpia el campo
		searchBox.sendKeys("Selenium");//escribe "Selenuim"
		searchButton.click();//hacer click en el boton
		
		WebElement seleniumLink = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div/div/div/div/ol/li[1]/div/div[1]/h3/a"));//busca un link por xpath
		seleniumLink.click();//le da click
		
		ArrayList<String> windowIds = new ArrayList<String>(driver.getWindowHandles());//abre una nueva pestaña
		System.out.println("Number of windows: " + windowIds.size()); //imprime la cantidad de pestañas que abrió
		
		for(String windowId: driver.getWindowHandles()) {
			driver.switchTo().window(windowId);
		}
		
		WebElement downloadLink = driver.findElement(By.linkText("Downloads"));//busca otro link
		downloadLink.click();//le da click
		
		driver.quit();//cierra la ventana

	}

}
