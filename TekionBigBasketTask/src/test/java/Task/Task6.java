package Task;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task6 {
	@Test
	void task6() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com");
		driver.manage().window().maximize();
		WebElement category = driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:R5bclm:']"));
		category.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement beverage = driver.findElement(By.xpath("//div[@id='headlessui-menu-items-:R176alm:']/nav/descendant::a[.='Beverages']"));

		JavascriptExecutor j = (JavascriptExecutor) driver;
		
	    j.executeScript("arguments[0].click();", beverage);
	    category.click();
		
		List<WebElement> items = driver.findElements(By.xpath("//div[@class='slug___StyledFilterByCategory-sc-1pgl3kl-2 ebgQYS']/div/ul/descendant::li"));
		System.out.println("total count of items in the beverage are "+items.size());
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement coffee = driver.findElement(By.xpath("//div[@class='slug___StyledFilterByCategory-sc-1pgl3kl-2 ebgQYS']/div/ul/descendant::a[.='Coffee']"));

//		j.executeScript("arguments[0].scrollIntoView();", coffee);

		j.executeScript("window.scroll("+coffee.getLocation().x+","+coffee.getLocation().y+100+")");
//		j.executeScript("window.scrollTo("+500+","+600+")");
		
//		Actions act = new Actions(driver);
//		act.scrollToElement(coffee).perform();
		
		coffee.click();
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement ground_coffee = driver.findElement(By.xpath("//ul[@class='flex flex-col overflow-hidden  false lg:max-h-51 xl:max-h-60']/descendant::a[.='Ground Coffee']"));
		ground_coffee.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement starbox = driver.findElement(By.xpath("//span[@class='Label-sc-15v1nk5-0 FilterByRating___StyledLabel2-sc-17wxy9s-1 gJxZPQ jNeRcZ group']/child::input"));
//		WebElement brand = driver.findElement(By.xpath("//input[@id='i-Auric']"));
//		WebElement price = driver.findElement(By.xpath("//input[@id='i-MorethanRs500']"));
//		WebElement discount = driver.findElement(By.xpath("//input[@id='i-15%-25%']"));
		WebElement country = driver.findElement(By.xpath("//input[@id='i-India']"));
		
		ArrayList<WebElement> a1 = new ArrayList<WebElement>();
		a1.add(starbox);
		a1.add(country);
		
		for(WebElement ele : a1) {
			j.executeScript("window.scroll("+ele.getLocation().x+","+ele.getLocation().y+")");
			ele.click();
			Thread.sleep(2000);
		}
		
//		driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:r6:']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement first_item = driver.findElement(By.xpath("(//ul[@class='mt-5 grid gap-6 grid-cols-9']/descendant::li)[position()=1]/descendant::div[@class='SKUDeck___StyledDiv-sc-1e5d9gk-0 eA-dmzP']/descendant::div[@class='flex flex-col false']/div/child::div[@class='relative flex flex-col w-full lg:h-8 xl:h-9 overflow-hidden']"));
//		j.executeScript("window.scroll("+first_item.getLocation().x+","+first_item.getLocation().y+100+")");
		first_item.click();
		
		Thread.sleep(2000);
		
		WebElement area = driver.findElement(By.xpath("(//div[contains(@id,'headlessui-menu-items-:rd')])[1]/descendant::div[@class='AddressDropdown___StyledDiv-sc-i4k67t-7 eXGbTp']/descendant::input"));
		area.sendKeys("Bengaluru Palace");
		
		Thread.sleep(1000);
		
		List<WebElement> options = driver.findElements(By.xpath("//div/ul/li[contains(@class,'AddressDropdown')]"));
		for(WebElement ele : options) {
			if (ele.getText().contains("Bangaluru Palace")) {
				ele.click();
			}
		}
		
		
	}
}
