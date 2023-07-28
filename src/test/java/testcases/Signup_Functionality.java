package testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Signup_Functionality {
	
	public static WebDriver driver;

	
	public static void main(String[] args) throws Exception {
		register_Zintlr();
	}
	
	
	public static void register_Zintlr() throws Exception {

		WebDriverManager.chromedriver().setup();
		ChromeOptions cp = new ChromeOptions();
		cp.addArguments("--incognito");
		cp.setAcceptInsecureCerts(true);
		cp.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		DesiredCapabilities dsp = new DesiredCapabilities();
		dsp.setCapability(ChromeOptions.CAPABILITY, cp);
		cp.merge(dsp);
		driver = new ChromeDriver(cp);
		driver.manage().window().maximize();
		driver.get("https://zintlr.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[text()='Accept all']")).click();
		driver.findElement(By.xpath("//div[@class='ease transform duration-700']//a[text()='Use case']")).click();
		Thread.sleep(5000); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='my-3 flex flex-row items-center']//a[text()='Sign Up']")).click();
		driver.findElement(By.xpath("//div[@class='flex']//input[@name='email']")).sendKeys("sana@zintlr.com");
		driver.findElement(By.xpath("//div[@class='flex']//button[text()='Sign Up']")).click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Java");
			Thread.sleep(5000);
			driver.findElement(By.name("email")).sendKeys("sana@zintlr.com");
			WebElement country = driver.findElement(By.xpath("//div[@class='flex gap-2']//select[@name='countryCode']"));
			Thread.sleep(5000);
			Select select = new Select(country);
			select.selectByValue("+91");
			Thread.sleep(3000);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='flex gap-2']//input[@name='phone']")));
			driver.findElement(By.xpath("//div[@class='flex gap-2']//input[@name='phone']")).sendKeys("8519818703");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sana@999");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("Sana@999");
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("#privacy")).click();
			driver.findElement(By.xpath("//button[text()='Sign Up']"));
			Thread.sleep(5000);
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		driver.quit();

	}
	
}
