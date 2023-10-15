package objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPageusingPageFactory {
	WebDriver driver;

	@FindBy(xpath = "(//*[text()='Jobs'])[1]")
	private WebElement MyProfilepf;

	public MyAccountPageusingPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement MyProfilepf() {
		return MyProfilepf;
	}
}
