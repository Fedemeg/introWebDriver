package test.java.bIntro;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BuscarPeliculaIMD {
	static WebDriver driver;
	
	public static void main(String[] args) {
		

	navegarUrl("chrome", "http://imdb.com");
	verificarPaginaHome();
	ingresarPelicula("It");
	clickBusqueda();
	verificarBusqueda("It");
	cerrarNavegador();

}

	private static void navegarUrl(String navegador, String url) {
		
		switch(navegador) {
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
		driver.manage().timeouts().implicitlyWait(5,  TimeUnit.SECONDS);
		driver.get(url);
	}

	private static void verificarPaginaHome() { //asigne las variable con sus valores, ahora faltaria verificar que estén presentes.
		//verifar logo IMDB  //a[@id = 'home_img_holder']
		WebElement logoIMDB = driver.findElement(By.id("home_img_holder"));
		//verificar campo busqueda //input[@name = 'q']
		WebElement campoBusqueda = driver.findElement(By.xpath("//input[@name = 'q']"));
		//verifcar boton LUPA //button[@id = 'suggestion-search-button'] 
		WebElement botonLupa = driver.findElement(By.xpath("//button[@id = 'suggestion-search-button']"));
		
		if (logoIMDB.isDisplayed()) {
		System.out.println("El logo IMDB esta visible");
		}
		else {
			System.out.println("El logo IMDB no esta visible");
		}
			
		if (campoBusqueda.isDisplayed()) {
			System.out.println("El campo de busqueda esta visible");
		}
		else {
			System.out.println("El campo de busqueda no esta visible");
		}
		if (botonLupa.isDisplayed()) {
			System.out.println("El boton lupa esta visible");
			}
			else {
				System.out.println("El boton lupa no esta visible");
			}
		}	
		
	

	private static void ingresarPelicula(String nombrePelicula) {
		// Metodo para realizar la busqueda
		WebElement campoBusqueda = driver.findElement(By.xpath("//input[@name = 'q']")); //tengo que volver a crear la variable porque no me deja usar la del metodo anterior.
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
		// TODO Auto-generated method stub
		WebElement botonLupa = driver.findElement(By.xpath("//button[@id = 'suggestion-search-button']"));
		botonLupa.click();
	}
	
	
	private static void verificarBusqueda(String nombrePelicula) {
		WebElement fraseResults = driver.findElement(By.xpath("//h1[@class='findHeader']"));// verifico que esta  la palabra results
		WebElement movieLink = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/table/tbody/tr[1]/td[2]/a"));
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
	private static void cerrarNavegador() { //creo el metodo para cerrar la pagina y el navegador
		driver.close();
		driver.quit();
		
		
	}
}



/* FALTARIA PONER LOS ASSERT 
Es necesario importar la librería de Testng de los Asserts a la clase donde estoy realizando los tests:

import org.testng.Assert;


Existen varios tipos de validaciones que se pueden realizar:



💡 Assert.assertEquals (valor_obtenido, valor_esperado)

Para comparar si ambos valores son iguales, en caso de que no lo sea, el Test fallará!

Assert.assertEquals(valorObtenido, 3);


💡 Assert.assertNotEquals (valor_obtenido, valor_esperado)

Para comparar si ambos valores son distintos, en caso de que sean iguales, el Test fallará!

Assert.assertNotEquals(valorObtenido, 3);


💡 Assert.assertTrue (condición)

Para validar que la condición sea verdadera, de lo contrario, el Test fallará

Assert.assertTrue(encontreElemento);


💡 Assert.assertFalse (condición)

Para validar que la condición sea falsa, de lo contrario, el Test fallará

Assert.assertFalse(hayError);
*/