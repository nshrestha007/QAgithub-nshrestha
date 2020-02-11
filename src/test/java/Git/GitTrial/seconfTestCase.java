package Git.GitTrial;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class seconfTestCase {

	public class AddNewAccount {

		WebDriver driver;
		
		@BeforeMethod
		public void addNewAccount() {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://techfios.com/test/billing/?ng=admin/");
			driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
			driver.findElement(By.xpath("//button[contains(text(),'Sign')]")).click();
		}
		@Test
		public void addNewAccountForm() throws InterruptedException {
			
			By BANKCASH_ELEMENT_LOCATOR = By.xpath("//span[ contains(text(),'Bank & Cash')]");
			By NEWACCOUNT_ELEMENT_LOCATOR = By.linkText("New Account");
			By ACCOUNTTITLE_ELEMENT_LOCATOR = By.id("account");
			By DESCRIPTION_ELEMENT_LOCATOR = By.id("description");
			By INITIALBALANCE_ELEMENT_LOCATOR = By.id("balance");
			By SUBMIT_ELEMENT_LOCATOR = By.xpath("//i[@class=\"fa fa-check\"]");
			
			driver.findElement(BANKCASH_ELEMENT_LOCATOR).click();
			driver.findElement(NEWACCOUNT_ELEMENT_LOCATOR).click();
			
			Random rnd = new Random();
			int rndNumber = rnd.nextInt(999);		
			
			String expectedAccountTitle = "Salaries" + rndNumber;
			String expectedDescription = "Operating Expenses" +rndNumber;
			String initialBalance = String.valueOf(rndNumber);
			
			driver.findElement(ACCOUNTTITLE_ELEMENT_LOCATOR).sendKeys(expectedAccountTitle);
			driver.findElement(DESCRIPTION_ELEMENT_LOCATOR).sendKeys(expectedDescription);
			driver.findElement(INITIALBALANCE_ELEMENT_LOCATOR).sendKeys(initialBalance);
			//driver.findElement(INITIALBALANCE_ELEMENT_LOCATOR).sendKeys("" +rndNumber);//another way
			driver.findElement(SUBMIT_ELEMENT_LOCATOR).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='alert alert-success fade in']")));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(0,600)");
			
			
		}
		
		
		
	}

}
