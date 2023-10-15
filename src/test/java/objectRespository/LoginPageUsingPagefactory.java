package objectRespository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageUsingPagefactory {
	WebDriver driver;

	public LoginPageUsingPagefactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement emailAddress;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(id = "submit")
	private WebElement loginbutton;

	public WebElement emailAddress() {
		return emailAddress;
	}

	public WebElement password() {
		return password;
	}

	public WebElement loginbutton() {
		return loginbutton;
	}

}
