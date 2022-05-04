package test.java.dWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by design on 11/17/17.
 */
public class ExplicitWaitTest {
	
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//espera implicita

		driver.get("http://songs-by-sinatra.herokuapp.com");

		WebDriverWait wait = new WebDriverWait(driver, 15); //espera explicita: necesita el driver/controlador del navegador; el tiempo maximo de espera en segundos

		WebElement loginLink = wait
								.until( //esperar hasta que cierto elemento sea clickeable
										ExpectedConditions
										.elementToBeClickable(
												By.xpath("//a[@href='/login']")//este seria el elemento en cuestion 
										)
								);
		loginLink.click(); //recien luego de que se cumpla la condicion, hacer CLICK
		WebElement usernameField = wait
								.until(//esperar hasta que el elemento cuyo ID=username sea visible
										ExpectedConditions
										.presenceOfElementLocated(
												By.id("username")
										)
								);

		WebElement passwordField = wait
								.until(//esperar hasta que el elemento cuyo ID=password sea visible
										ExpectedConditions
										.presenceOfElementLocated(
												By.id("password")
										)
								);
		//
		WebElement loginButton = wait
								.until(//esperar hasta que el elemento cuyo ID=password sea clickeable
										ExpectedConditions
										.elementToBeClickable(
												By.xpath("//input[@value = 'Log In']")
										)
								);

		usernameField.sendKeys("frank");//ingresar frak en el campo usernamefield
		passwordField.sendKeys("sinatra");//ingresar sinatra en el campo passwordfield
		loginButton.click();//hacer click em 

		WebElement loggedInMessage = wait
									.until(//esperar hasta que el cartel de que estoy logueado cuyo id=flash este presente
										ExpectedConditions
											.presenceOfElementLocated(
												By.id("flash")
											)
										);
		
		if (loggedInMessage.getText().equals("You are now logged in as frank")) //si el mensaje que aparece es igual a ....
			System.out.println("Test Passed");//... quiere decir que el test pasó...
		else
			System.out.println("Test Failed");//... si no, falló

		driver.close();
	}
}
