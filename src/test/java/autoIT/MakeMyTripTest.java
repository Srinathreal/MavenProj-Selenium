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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest {

	WebDriver driver;

	@Test
	public void testMakeMyTrip() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		WebElement clickmakemytrip = driver.findElement(By.xpath("//img[@alt=\"Make My Trip\"]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(clickmakemytrip).click().build().perform();
		driver.findElement(By.id("fromCity")).click();
		WebElement clickk2 = driver.findElement(By.xpath("//input[@placeholder=\"From\"]"));
		actions.moveToElement(clickk2).sendKeys("Che").perform();
		actions.moveToElement(clickk2).sendKeys(Keys.DOWN,Keys.ENTER).build().perform();
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("ScreenShots//Shot02.jpg"));

	}
}
