package test.java.bIntro;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoginSinatra { //creamos la clase

	static WebDriver driver;
	
	public static void main(String[] args) {
		//ENUMERO LOS PASOS / METODOS
		abrirPagina("chrome", "http://songs-by-sinatra.herokuapp.com/");
		clickearLogin();
		login("frank", "sinatra");
		validacionLogin();
		cerrarNavegador();
		
		

	}

	private static void abrirPagina(String navegador, String url) { //creo metodo de abrirPagina
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
	
	private static void clickearLogin() { //creo metodo para buscar y clickear el boton Log In
		WebElement loginlink = driver.findElement(By.xpath("//a[@href ='/login']"));
		loginlink.click();
		
	}
	
	private static void login(String usuario, String contrasena) { //creo metodo para buscar , limpiar y completar los campos de usuario y pass, y hacer clic en el boton de logueo
		WebElement userField = driver.findElement(By.xpath("//input[@id ='username']"));
		WebElement passField = driver.findElement(By.xpath("//input[@id ='password']"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@value ='Log In']"));

		userField.clear();
		userField.sendKeys(usuario);

		passField.clear();
		passField.sendKeys(contrasena);
		
		loginButton.click();

		
		
		
	}
	private static void validacionLogin() { //creo el metodo para verificar que el logueo fue exitoso
		String textoEsperado = "You are now logged in as frank";
		WebElement textoLogueo = driver.findElement(By.xpath ("//div[@class ='flash notice']"));
		String textoMostrado = textoLogueo.getText(); 
		if (textoMostrado.contentEquals(textoEsperado)) {
			System.out.println("Prueba OK");
		}
		else {
			System.out.println("Prueba Fall�");
		}
	}

	private static void cerrarNavegador() { //creo el metodo para cerrar la pagina y el navegador
		driver.close();
		driver.quit();
		
		
	}
}
