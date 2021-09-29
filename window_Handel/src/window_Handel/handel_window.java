package window_Handel;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class handel_window {
	public static void main(String[] args) throws InterruptedException
	{
		//To open the browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sunilna\\Desktop\\IBM Data on Desktop\\IBM Upskill Project\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// This is to open the parent window URL
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		driver.manage().window().maximize();
		// This is to identify the parent window
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's Name -> " + parentWindowHandle);
		WebElement clickElement = driver.findElement(By.id("button1")); 
 // To open 3 child windows
		for(int i = 0; i < 3; i++)
		{
			clickElement.click();
			Thread.sleep(3000);
		}
 // This is to store my child windows
		Set<String> allWindowHandles = driver.getWindowHandles();
		String lastWindowHandle = "";
		for(String handle : allWindowHandles)
		{
			System.out.println("Switching to window - > " + handle);
			System.out.println("Navigating to google.com");
			// To navigate all my child window to google.com
			driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
			driver.get("http://google.com");
			lastWindowHandle = handle;
		}
 
		//Switch to the parent window
		driver.switchTo().window(parentWindowHandle);
		//close the parent window
		driver.close();
		//at this point there is no focused window, we have to explicitly switch back to some window.
		driver.switchTo().window(lastWindowHandle);
		driver.get("http://www.gmail.com");
		
	}

}
