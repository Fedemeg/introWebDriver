package test.java.bIntro;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchMoviesImdb {

	static WebDriver driver;
	static WebDriverWait wait;
	
	
	public static void main(String[] args) {
	
		navegarUrl("chrome", "http://imdb.com");
		verificarPaginaHome();
		ingresarPelicula("It");
		clickBusqueda();
		verificarBusqueda("It");
		cerrarNavegador();


	}

		private static void navegarUrl(String navegador, String url) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}

	private static void verificarPaginaHome() {
		// Wait que sea clickeble el campo de texto
		
		wait.
		until( //esperar hasta que cierto elemento sea clickeable
				ExpectedConditions
				.elementToBeClickable(
						By.name("q"))//este seria el elemento en cuestion 
			 );
				
		
		// wait que sea clickeable el link de SingIn
		
		wait.
		until( //esperar hasta que cierto elemento sea clickeable
				ExpectedConditions
				.elementToBeClickable(
						By.xpath("//a[@href='/registration/signin?ref=nv_generic_lgin']"))//este seria el elemento en cuestion 
			 );
		
		//wait for Logo to be visible
		wait.
		until( //esperar hasta que cierto elemento sea visible
				ExpectedConditions
				.visibilityOfElementLocated(
						By.id("home_img_holder"))//este seria el elemento en cuestion 
			 );
		
		//wait for Lupa to be clickeable
		wait.
		until( //esperar hasta que cierto elemento sea clickeable
				ExpectedConditions
				.elementToBeClickable(
						By.id("suggestion-search-button"))//este seria el elemento en cuestion 
			 );
		
	}
	
	private static void ingresarPelicula(String nombrePelicula) {
		// Metodo para realizar la busqueda
				WebElement campoBusqueda = driver.findElement(By.name("q")); //tengo que volver a crear la variable porque no me deja usar la del metodo anterior.
				campoBusqueda.clear();//limpio el campo busqueda
				campoBusqueda.sendKeys(nombrePelicula);//ingreso el valor "It" en el cmapoBusqueda
				WebElement menuOpcional = driver.findElement(By.xpath("//div[contains(@class, 'imdb-header__search-menu')]"));//verifico que se despliega un menu al buscar //div[contains]@class, 'imdb-header__search-menu']
				if (menuOpcional.isDisplayed()) {
					System.out.println("El menu opcional esta visible");
					}
					else {
						System.out.println("El menu opcional no esta visible");
					}
		
	}
	

	private static void clickBusqueda() {
		WebElement botonLupa = driver.findElement(By.xpath("//button[@id = 'suggestion-search-button']"));
		wait.
		until( //esperar hasta que cierto elemento sea clickeable
				ExpectedConditions
				.elementToBeClickable
				(By.xpath("//button[@id = 'suggestion-search-button']"))//este seria el elemento en cuestion 
			 );
		
		botonLupa.click();
		
	}

	private static void verificarBusqueda(String nombrePelicula) {
		WebElement fraseResults = driver.findElement(By.xpath("//h1[@class='findHeader']"));// verifico que esta  la palabra results
		WebElement movieLink = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/table/tbody/tr[1]/td[2]/a"));
		wait.
		until( //esperar hasta que cierto elemento sea clickeable
				ExpectedConditions
				.visibilityOfElementLocated
				(By.xpath("//h1[@class='findHeader']"))//este seria el elemento en cuestion 
			 );
		
		wait.
		until(
				ExpectedConditions
				.numberOfElementsToBeMoreThan(By.linkText(nombrePelicula), 1)//aca le digo que espere hasta que al menos haya mas de 1 resultado con el nombrePelicula
				);
		
		if (fraseResults.isDisplayed()) {
			System.out.println("El resultado de la busqueda resulto satisfactorio");
			}
			else {
				System.out.println("El resultado de la busqueda no fue preciso");
			}
		if (movieLink.isDisplayed()) {
			System.out.println("La busqueda de la pelicula " + nombrePelicula + " resulto satisfactoria");
			}
			else {
				System.out.println("La busqueda de la pelicula " + nombrePelicula + " no resulto satisfactoria");
			}
		
	}

	
	private static void cerrarNavegador() {
		driver.close();
		driver.quit();//cierra el chromeDriver
		
	}
}
