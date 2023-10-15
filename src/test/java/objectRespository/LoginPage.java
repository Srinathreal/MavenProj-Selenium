package objectRespository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {  //constructor..   here driver comes from logintest class
		this.driver = driver;   //to access this page's driver !
	}

	private By emailAddress = By.name("username");
	private By password = By.name("password");
	private By loginbutton = By.id("submit");

	public WebElement emailAddress() {
		return driver.findElement(emailAddress);
	}

	public WebElement password() {
		return driver.findElement(password);
	}

	public WebElement loginbutton() {
		return driver.findElement(loginbutton);
	}

}
