package autoIT;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITDemo {

	@Test
	public void autoITtest() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("uploadfile"))).click().build().perform();
		Runtime.getRuntime().exec("C:\\Users\\srina\\eclipse-workspace\\MavenProject-Selenium\\AutoITExeFiles\\AutoIt02.exe");
	}
}
