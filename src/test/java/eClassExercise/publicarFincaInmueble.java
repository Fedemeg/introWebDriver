package test.java.eClassExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class publicarFincaInmueble {
	
	static WebDriver driver;

	public static void main(String[] args) {
		abrirNavegador("http://www.fincaraiz.com.co/");
		validarHomepage();
		presionarPublicar();
		validarFormularioDatosAviso();
		
	}

	private static void abrirNavegador(String url) {
		driver = new ChromeDriver();
		driver.get(url);
	}

	private static void validarHomepage() {

	}

	private static void presionarPublicar() {
		WebElement botonPublicar = driver.findElement(By.linkText("Publica gratis"));
		botonPublicar.click();	
		
	}

	private static void validarFormularioDatosAviso() {
		WebElement tipoOfertaBox = driver.findElement(By.id("ctl00_phMasterPage_AdvertControl_cboTransaction"));
		if( tipoOfertaBox.isDisplayed()) {
			System.out.println("El elemento de seleccion esta presente");
			Select elem = new Select(tipoOfertaBox);//esto es para interactuar con un BOX de seleccion de la pagina
			elem.selectByVisibleText("Venta");//selecciono la opcion dentro del box en este caso por Texto visible (pero hay mas opciones)
		}
		else {
			System.out.println("El elemento de seleccion no fue encontrado");

		}
			
	}

}
