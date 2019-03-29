package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class a {
	WebDriver driver;
	void setter()
	{
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}
}
