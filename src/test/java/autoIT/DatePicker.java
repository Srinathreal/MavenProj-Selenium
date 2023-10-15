package autoIT;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {
	WebDriver driver;

	@Test
	public void testDatePicker() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/datepicker/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.xpath("//p/iframe[@class=\"demo-frame lazyloaded\"]"));
		driver.switchTo().frame(frame);
		driver.findElement(By.id("datepicker")).click();

		while (!driver.findElement(By.className("ui-datepicker-title")).getText().equals("September 1997")) {
			driver.findElement(By.xpath("//a[@title=\"Prev\"]")).click();
		}
		List<WebElement> Days = driver.findElements(By.className("ui-state-default"));

		for (int i = 0; i < Days.size(); i++) {
			if (Days.get(i).getText().equalsIgnoreCase("10")) {
				Days.get(i).click();
				break;
			}

		}

	}

}
