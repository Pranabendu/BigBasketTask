package Task;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task4 {
	@Test
	void task4() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com");
		driver.findElement(By.xpath("//button[.='Login/ Sign Up']")).click();
		driver.findElement(By.xpath("//input[@id='multiform']")).sendKeys("6296477764");
		driver.findElement(By.xpath("//button[.='Continue']")).click();
		Thread.sleep(30000);
		driver.findElement(By.xpath("//button[.='Verify & Continue']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[@class='MemberDropdown___StyledMenuButton-sc-ce95dd-1 ezacJo']/*[name()='svg']/*[name()='g']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement myAccount = driver.findElement(By.xpath("//span[.='My Account']/parent::a"));
		myAccount.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[.='Customer Service']")).click();
		
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for Products..']"));
		search.sendKeys("non veg");
		
		List<WebElement> autosugge = driver.findElements(By.xpath("//ul[@id='uiv2-autosearch-list']/descendant::li/descendant::a[@class='uiv2-img-product-name']/descendant::span"));
		System.out.println("Total suggestions are "+autosugge.size());
		for(WebElement ele : autosugge) {
			System.out.println(ele.getText());
		}
		
		driver.findElement(By.xpath("(//ul[@id='uiv2-autosearch-list']/descendant::li/descendant::p)[position()=2]")).click();
		
		Random r = new Random();
		int res = r.nextInt(200);
		
		TakesScreenshot take = (TakesScreenshot) driver;
		File temp = take.getScreenshotAs(OutputType.FILE);
		File per = new File("./screenshots/2nditem"+res+".png");
		try {
			FileHandler.copy(temp, per);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.close();
	}
}

