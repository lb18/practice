package practice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.javascript.host.Console;

import net.sourceforge.htmlunit.corejs.javascript.ScriptableObject;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Search {
	WebDriver driver;
	Scanner in = new Scanner(System.in);
	List<String> links = new ArrayList<String>();
	public void getSearchInput() throws IOException
	{
		String str = in.nextLine();
		DesiredCapabilities caps = new DesiredCapabilities(); 
		caps.setJavascriptEnabled(true);     
		caps.setCapability("takesScreenshot", true); 
		caps.setCapability(
		PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, 
		"C:/Users/lokeshbisht/eclipse-workspace/practice/phantomjs.exe" 
		); 
		driver = new PhantomJSDriver(caps);
		//driver = new ChromeDriver();
		performSearch(str);
	}
	
	public void performSearch(String str) throws IOException
	{
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		// to capture screenshot
		/*File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("d:/sample.jpg"), true);*/
		String search_path = "#tsf > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(3)";
		driver.findElement(By.name("q")).sendKeys(str);
		driver.findElement(By.name("q")).submit();
		getSearchData();
	}
	
	public void getSearchData()
	{
		List<WebElement> search_results = driver.findElements(By.tagName("cite"));
		//List<String> links = new ArrayList<String>();
		for (int i = 0; i < search_results.size(); i++) links.add(search_results.get(i).getText());
		//for (int i = 0; i < links.size(); i++) System.out.println(links.get(i));
		/*for (int i = 0; i < links.size(); i++)
		{
			String str = links.get(i), tmp = "";
			int dots = 0;
			for (int j = 0; j < str.length(); j++) if (str.charAt(j) == '.') dots++;
			if (dots != 2) links.set(i, "-1");
			for (int j = 8; j < str.length(); j++)
			{
				if (links.get(i) == "-1") continue;
				if (str.charAt(j) == ' ' || str.charAt(j) == '/') break;
				else tmp += str.charAt(j);
			}
			if (links.get(i) != "-1") links.set(i, tmp);	
		}
		//for (int i = 0; i < links.size(); i++) if (links.get(i) != "-1")System.out.println(links.get(i));
		for (int i = 0; i < links.size(); i++) if (links.get(i) == "-1") {links.remove(i); i--;}*/
	}

	/*public static void main(String args[]) throws IOException, GeneralSecurityException
	{
		WriteInGoogleSheet.main(args);	
	}*/
}
