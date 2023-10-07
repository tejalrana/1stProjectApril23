package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		launchChrome();
		possitiveLoginTest();
		closeBrowser();

		launchChrome();
		negLoginTest();
		closeBrowser();

	}

	public static void launchChrome() {
		// System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Tejal
		// Rana\\SeleniumNew-workspace\\crm\\driver\\chromedriver.exe");

		// LaunchChrome

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		driver = new ChromeDriver();

		// clear cookies
		driver.manage().deleteAllCookies();

		driver.get("http://www.techfios.com/billing/?ng=admin/ ");

		// maximize window
		driver.manage().window().maximize();

		// manage time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void closeBrowser() throws InterruptedException {

		Thread.sleep(10000);

		driver.close();
	}

	public static void possitiveLoginTest() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

	}

	public static void negLoginTest() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");

		driver.findElement(By.name("password")).sendKeys("abc1234");

		driver.findElement(By.name("login")).click();

	}
}
