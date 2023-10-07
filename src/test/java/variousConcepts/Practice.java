package variousConcepts;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

	WebDriver driver;

	@Before
	public void LaunchBrowser() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void LoginTest() throws InterruptedException {
		// Type variable = identify the element
		WebElement txtUsername = driver.findElement(By.name("username"));
		// variable . value
		txtUsername.sendKeys("Admin");
		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys("admin123");

		WebElement txtLogin = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		txtLogin.click();
		

		// driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

		/*
		 * String act_title = driver.getTitle(); // run time title //String Exp_title =
		 * "OrangeHRM"; // expected title ----Passed String Exp_title = "OrangeHRM123";
		 * // expected title ---Failed
		 * 
		 * if (act_title.equals(Exp_title)) { System.out.println("Passed"); } else {
		 * System.out.println("failed"); }
		 */

		// Lable validation after successful login---if we r going wrong n we got a NoSuchElementException then if u want to continus to check ur forther test then go with try ---catch for avoid the wrong part n excecute the other part
		String act_lable = null;
		try {
			act_lable = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6"))
					.getText();
		} catch (NoSuchElementException e) {
		}

		act_lable = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		String exp_lable = "Dashboard";
		if (act_lable.equals(exp_lable)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("failed");
		}

		Thread.sleep(5000);

		driver.quit();
	}

}
