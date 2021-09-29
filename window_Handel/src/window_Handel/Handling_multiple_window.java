package window_Handel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Handling_multiple_window {
	WebDriver driver;
  @Test
  public void f() {
	  driver.findElement(By.xpath("//*[@id='content']/p[3]/button")).click();
	  String parent_window = driver.getWindowHandle();
	  System.out.println(parent_window);
	  for (String child_window:driver.getWindowHandles())
	  {
		  driver.switchTo().window(child_window);
		  String title = driver.getTitle();
		  System.out.println(title);
		  driver.switchTo().window(parent_window);
		  String title1 = driver.getTitle();
		  System.out.println(title1);
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\sunilna\\Desktop\\IBM Data on Desktop\\IBM Upskill Project\\chromedriver_win32\\chromedriver.exe");
	   driver = new ChromeDriver();
		driver.get("https://toolsqa.wpengine.com/automation-practice-switch-windows/");
		driver.manage().window().maximize();
  }
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
