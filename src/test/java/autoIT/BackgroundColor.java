package autoIT;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BackgroundColor {

	WebDriver driver;

	@Test
	public void testZoho() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		driver.findElement(By.name("email")).sendKeys("srinathnk23@gmail.com");
		actions.sendKeys(Keys.TAB).sendKeys("Srinath@QAfox").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
				.build().perform();

		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("ScreenShots//Shot01.png"));

	}

}
