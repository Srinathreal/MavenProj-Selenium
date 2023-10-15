package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRespository.LoginPage;
import objectRespository.LoginPageUsingPagefactory;
import objectRespository.MyAccountPage;
import objectRespository.MyAccountPageusingPageFactory;

public class LoginTest {

	WebDriver driver;

	@Test
	public void logintest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://careers.zohocorp.com/candidateportal");
		WebElement iframe3 = driver.findElement(By.xpath("//iframe[@scrolling=\"no\"]"));
		driver.switchTo().frame(iframe3);
		// LoginPage loginPage = new LoginPage(driver);
//		loginPage.emailAddress().sendKeys("srinathnk07@gmail.com");
//		loginPage.password().sendKeys("Srinath@Zoho#7");
//		loginPage.loginbutton().click();

		LoginPageUsingPagefactory loginPageUsingPagefactory = new LoginPageUsingPagefactory(driver);
		loginPageUsingPagefactory.emailAddress().sendKeys("srinathnk07@gmail.com");
		loginPageUsingPagefactory.password().sendKeys("Srinath@Zoho#7");
		loginPageUsingPagefactory.loginbutton().click();

		// MyAccountPage accountPage = new MyAccountPage(driver);
		// Assert.assertTrue(accountPage.MyProfile().isDisplayed());
		
		
		MyAccountPageusingPageFactory accountPagepf = new MyAccountPageusingPageFactory(driver);
		driver.switchTo().defaultContent();
		Assert.assertTrue(accountPagepf.MyProfilepf().isDisplayed());

	}

	@AfterMethod
	public void finish() {
		driver.quit();
	}

}
