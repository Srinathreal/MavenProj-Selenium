package objectRespository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver;
	private By MyProfile = By.xpath("(//*[text()='Jobs'])[1]");

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement MyProfile() {
		return driver.findElement(MyProfile);
	}

}
