package m1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T1 {

	@Test
	public void m1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.pmi.org/");
		driver.findElement(By.cssSelector("button#pmi-adp-header__global-nav-button")).click();
		List<WebElement> items = driver.findElements(By.cssSelector("li.pmi-adp-slider__item"));

		for (WebElement item : items) {
			System.out.println(item.getText());
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#QSIFeedbackButton-btn")))).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button#QSIFeedbackButton-btn")).click();
		driver.findElement(By.xpath("//span[contains(text(),'dissatisfied')]")).click();
		//driver.quit();
		System.out.println("Test case is passed!!");
	}
}
