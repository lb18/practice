package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//import com.google.api.client.http.HttpResponse;

public class BrokenImage
{
	WebDriver driver;
	
	int broken_image_count() throws ClientProtocolException, IOException
	{
		/*DesiredCapabilities caps = new DesiredCapabilities(); 
		caps.setJavascriptEnabled(true);     
		caps.setCapability("takesScreenshot", true); 
		caps.setCapability(
		PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, 
		"C:/Users/lokeshbisht/eclipse-workspace/practice/phantomjs.exe" 
		);
		driver = new PhantomJSDriver(caps);*/
		driver = new ChromeDriver();
		driver.get("C:/Users/lokeshbisht/Desktop/broken_images.html");
		int cnt = 0;
		List<WebElement> images = driver.findElements(By.tagName("img"));
		for (int i = 0; i < images.size(); i++)
		{
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(images.get(i).getAttribute("src"));
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != 200) cnt++;
		}
		return cnt;
	}
	
	int broken_link_count() throws IOException, MalformedURLException
	{
		int cnt = 0;
		driver = new ChromeDriver();
		driver.get("C:/Users/lokeshbisht/Desktop/broken_images.html");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (Iterator it = links.iterator(); it.hasNext();)// it.next())
		{
			String str = ((WebElement) it.next()).getAttribute("href");
			 URL link = new URL(str);
			 HttpURLConnection httpconn = (HttpURLConnection)(link.openConnection());
			 httpconn.setConnectTimeout(200);
			 httpconn.connect();
			 if (httpconn.getResponseCode() >= 400) cnt++;
		}
		return cnt;
	}
	
	public static void main(String ...args) throws ClientProtocolException, IOException
	{
		BrokenImage obj = new BrokenImage();
		//System.out.println(obj.broken_image_count());
		System.out.println(obj.broken_link_count());
	}
}
