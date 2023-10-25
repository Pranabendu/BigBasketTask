package Task;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task5 {
	@Test
	void task5() throws InterruptedException {
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
		
		search.sendKeys(Keys.ENTER);
		
		List<WebElement> allitems = driver.findElements(By.xpath("//ul[@class='mt-5 grid gap-6 grid-cols-9']/descendant::li/descendant::div[@class='break-words h-10 w-full']"));
		System.out.println("total count of the titles are... "+allitems.size());
		
		for(WebElement ele : allitems) {
			System.out.println(ele.getText());
		}
		
		Random r = new Random();
		int res = r.nextInt(200);
		
		TakesScreenshot take = (TakesScreenshot) driver;
		File temp = take.getScreenshotAs(OutputType.FILE);
		File per = new File("./screenshots/items"+res+".png");
		try {
			FileHandler.copy(temp, per);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.close();
	}
}

