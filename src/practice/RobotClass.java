package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Why Robot class?
   We use it to control keyboard or mouse to interact with OS windows like Download pop-up, Alerts, Print Pop-ups or to  
   native Operation System applications like Notepad, Skype, Calculator, etc.
   There are basically 2 types of alert pop ups: 1. Windows-based alert pop ups nd 2. Browser based.
   Selenium can only handle browser based alert pop ups as it is a browser automation tool.
   It can't handle windows based alert pop ups that's y we use robot class. 
*/

// Robot Class methods can be used to interact with keyboard/mouse events while doing browser automation. 
// Alternatively "AutoIT" can be used, but its drawback is that it generates an executable file (exe) which will only work on 
// windows, so it is not a good option to use.

// Disadvantages of Robot Class
// 1. Keyword/mouse event will only works on current instance of Window. E.g. suppose a code is performing any robot 
//    class event, and during the code execution user has moved to some other screen then keyword/mouse event will occur on 
//    that screen.
// 2. Most of the methods like mouseMove is screen resolution dependent so there might be a chance that code working on one 
//    machine might not work on other.

public class RobotClass {
	
	private WebDriver driver;
	
	void handleAlertBox() throws AWTException, InterruptedException
	{	
		driver = new FirefoxDriver();//ChromeDriver();
		driver.get("https://jira.corp.adobe.com");
		System.out.println("Link's Hit");
		Thread.sleep(8000);
		System.out.println("Wait Over!!");
		Robot rb = new Robot();
		Thread.sleep(6000);
		System.out.println("Starting to type.");
		System.out.println("Wait Over!!");
		rb.keyPress(KeyEvent.VK_Q);
		rb.keyRelease(KeyEvent.VK_Q);
		rb.keyPress(KeyEvent.VK_A);
		rb.keyPress(KeyEvent.VK_I);
		rb.keyPress(KeyEvent.VK_0);
		rb.keyPress(KeyEvent.VK_6);
		rb.keyPress(KeyEvent.VK_0);
		rb.keyPress(KeyEvent.VK_1);
		rb.keyPress(KeyEvent.VK_2);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_SHIFT);
		rb.keyPress(KeyEvent.VK_Q);
		rb.keyRelease(KeyEvent.VK_SHIFT);
		rb.keyPress(KeyEvent.VK_A);
		rb.keyPress(KeyEvent.VK_I);
		rb.keyPress(KeyEvent.VK_N);
		rb.keyPress(KeyEvent.VK_F);
		rb.keyPress(KeyEvent.VK_O);
		rb.keyPress(KeyEvent.VK_T);
		rb.keyPress(KeyEvent.VK_E);
		rb.keyPress(KeyEvent.VK_C);
		rb.keyPress(KeyEvent.VK_H);
		rb.keyPress(KeyEvent.VK_SHIFT);
		rb.keyPress(KeyEvent.VK_3);
		rb.keyRelease(KeyEvent.VK_SHIFT);
		rb.keyPress(KeyEvent.VK_4);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	public static void main(String args[]) throws AWTException, InterruptedException
	{
		RobotClass alert_box = new RobotClass();
		alert_box.handleAlertBox();
	}

}
