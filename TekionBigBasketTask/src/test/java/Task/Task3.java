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

public class Task3 {
	@Test
	void task3() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com");
		driver.findElement(By.xpath("//button[.='Login/ Sign Up']")).click();
		driver.findElement(By.xpath("//input[@id='multiform']")).sendKeys("6296477764");
		driver.findElement(By.xpath("//button[.='Continue']")).click();
		Thread.sleep(30000);
		driver.findElement(By.xpath("//button[.='Verify & Continue']")).click();
		
//		Actions act = new Actions(driver);
//		act.click().perform();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='MemberDropdown___StyledMenuButton-sc-ce95dd-1 ezacJo']/*[name()='svg']/*[name()='g']")).click();
		
		WebElement myAccount = driver.findElement(By.xpath("//span[.='My Account']/parent::a"));
		myAccount.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[.='Customer Service']")).click();
		
		List<WebElement> allopts = driver.findElements(By.xpath("//div[@class='uiv2-two-col-box']/descendant::div[@class='uiv2-col ng-scope icon-disabled']/descendant::h6"));
		for(WebElement ele : allopts) {
			System.out.println(ele.getText());
		}
		
		if (allopts.size()>10) {
			System.out.println("Yes count are more then 10");
		} else {
			System.out.println("No count are not more then 10");
		}
		
		driver.findElement(By.xpath("//a[.='My Orders' and @id='link-my-orders']")).click();
		
		Random r = new Random();
		int res = r.nextInt(200);
		
		TakesScreenshot take = (TakesScreenshot) driver;
		File temp = take.getScreenshotAs(OutputType.FILE);
		File per = new File("./screenshots/orders"+res+".png");
		try {
			FileHandler.copy(temp, per);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.close();
		
	}
}

