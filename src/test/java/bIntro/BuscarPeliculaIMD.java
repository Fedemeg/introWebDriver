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

	private static void verificarPaginaHome() { //asigne las variable con sus valores, ahora faltaria verificar que est�n presentes.
		//verifar logo IMDB  //a[@id = 'home_img_holder']
		WebElement logoIMDB = driver.findElement(By.xpath("//a[@id = 'home_img_holder']"));
		//verificar campo busqueda //input[@name = 'q']
		WebElement campoBusqueda = driver.findElement(By.xpath("//input[@name = 'q']"));
		//verifcar boton LUPA //button[@id = 'suggestion-search-button'] 
		WebElement botonLupa = driver.findElement(By.xpath("//button[@id = 'suggestion-search-button']"));
		
		
	}

	private static void ingresarPelicula(String nombrePelicula) {
		// Metodo para realizar la busqueda
		WebElement campoBusqueda = driver.findElement(By.xpath("//input[@name = 'q']")); //tengo que volver a crear la variable porque no me deja usar la del metodo anterior.
		campoBusqueda.clear();//limpio el campo busqueda
		campoBusqueda.sendKeys(nombrePelicula);//ingreso el valor "It" en el cmapoBusqueda
		WebElement menuOpcional = driver.findElement(By.xpath("//div[contains(@class, 'imdb-header__search-menu')]"));//verifico que se despliega un menu al buscar //div[contains]@class, 'imdb-header__search-menu']
		
		
	}

	private static void clickBusqueda() {
		// TODO Auto-generated method stub
		WebElement botonLupa = driver.findElement(By.xpath("//button[@id = 'suggestion-search-button']"));
		botonLupa.click();
	}
	
	
	private static void verificarBusqueda(String nombrePelicula) {
		WebElement fraseResults = driver.findElement(By.xpath("//h1[@class='findHeader']"));// verifico que esta  la palabra results
		WebElement movieLink = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/table/tbody/tr[1]/td[2]/a"));
		
		
	}
	private static void cerrarNavegador() { //creo el metodo para cerrar la pagina y el navegador
		driver.close();
		driver.quit();
		
		
	}
}