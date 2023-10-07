package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_Junit {                            // j_Unit can't work with static methods

	WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass");
		
	}
	@AfterClass
	public static  void afterClass() {
		System.out.println("afterClass");
		
	}
	
	@Before
	public void launchChrome() {

		// LaunchBrowser
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

		// Clear Cookies
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");

		// maximize window
		driver.manage().window().maximize();

		// manage time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@After
	public  void closeBrowser() throws InterruptedException {
		
           System.out.println("closeBrowser");
		Thread.sleep(10000);

	//	driver.close();
		driver.quit();
	}

	@Test
	public void positiveLonginTest() {

		System.out.println("possitiveLonginTest");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
	}
	//@Test
	public void negLoginTest() {
		
		System.out.println("negLoginTest");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.name("password")).sendKeys("abc1234");
		driver.findElement(By.name("login")).click();
	}
	
		
	}
