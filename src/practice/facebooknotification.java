package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class facebooknotification {
	WebDriver driver;
	
	void get_notification()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("psefacebook15@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Tester@123");
		driver.findElement(By.id("u_0_2")).submit();
		System.out.println(driver.getTitle());
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#u_0_2i > ul > li > div > a > div > div:nth-child(2) > div > div > div > div:nth-child(2) > div > abbr")));
		System.out.println(driver.getTitle());
		String str = driver.findElement(By.cssSelector("#u_0_2i > ul > li > div > a > div > div:nth-child(2) > div > div > div > div:nth-child(2) > div > abbr")).getText();
		System.out.println(str);
	}
	
	public static void main(String ...args)
	{
		facebooknotification obj = new facebooknotification();
		obj.get_notification();
	}
}
