package MavenStarted;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverManager {

	public static void main(String[] args) {
	//	 1st Method
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver2 = new FirefoxDriver();
		driver2.get("https://www.google.com");

		// 2nd Method
		WebDriver chrome = WebDriverManager.chromedriver().create();
		WebDriver firefox = WebDriverManager.firefoxdriver().create();
		WebDriver edge = WebDriverManager.edgedriver().create();

		chrome.get("https://www.google.com");
		firefox.get("https://www.google.com");
		edge.get("https://www.google.com");
		
		//3rd Method
		List<WebDriver> chromepages = WebDriverManager.chromedriver().create(3);
		chromepages.get(0).get("https://www.google.com");
		chromepages.get(1).get("https://www.amazon.com");
		chromepages.get(2).get("https://www.flipkart.com");
		

		
		
		
		
		
		
	}
}
