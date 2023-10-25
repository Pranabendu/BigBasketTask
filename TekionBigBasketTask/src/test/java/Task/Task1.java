package Task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 {
	@Test
	void task1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='https://www.bigbasket.com/offers/?nc=b-header-2-tile&b_t=header-2-tile&b_camp=hp_cmc_m_offer_28_220921_all']")).click();

		ArrayList<String> a1 = new ArrayList<String>();

		// List<WebElement> banner1 =
		// driver.findElements(By.xpath("(//div[@class='owl-stage-outer'])[position()=1]//div[@class='owl-stage']/descendant::a[@class='ng-binding']"));
		List<WebElement> banner1 = driver.findElements(By.xpath(
				"//h2[.='Best Sellers']/parent::div/following-sibling::div/descendant::div[@class='owl-stage']/descendant::a[@class='ng-binding']"));
		System.err.println("The total count of Banner1 is " + banner1.size());
		System.out.println("The Items are.....");
		WebElement arrow1 = driver.findElement(By.xpath(
				"(//div[@class='owl-stage-outer'])[position()=1]/following-sibling::div[@class='owl-nav']/descendant::div[@class='owl-next']"));
		int X1 = arrow1.getLocation().x;
		int Y1 = arrow1.getLocation().y;
		for (int i = 0; i < banner1.size(); i++) {
			System.out.println(banner1.get(i).getText() + " " + i);
			a1.add(banner1.get(i).getText());
			try {
				if ((i + 1) % 5 == 0) {
					arrow1.click();
					Thread.sleep(1000);
				}
				if (i == banner1.size()) {
					break;
				}

			} catch (Exception e) {
				e.getMessage();
			}
		}
		Thread.sleep(2000);
		System.out.println();
		List<WebElement> banner2 = driver.findElements(By.xpath(
				"(//div[@class='owl-stage-outer'])[position()=2]//div[@class='owl-stage']/descendant::a[@class='ng-binding']"));
		System.err.println("The total count of Banner2 is " + banner2.size());
		System.out.println("The Items are.....");

		WebElement arrow2 = driver
				.findElement(By.xpath("(//div[@class='owl-nav'])[2]/descendant::div[@class='owl-next']"));
		int X = arrow2.getLocation().x - 100;
		int Y = arrow2.getLocation().y - 100;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + X + "," + Y + ")");

		for (int i = 0; i < banner2.size(); i++) {
			System.out.println(banner2.get(i).getText() + " " + i);
			a1.add(banner2.get(i).getText());
			try {
				if ((i + 1) % 5 == 0) {
					arrow2.click();
					Thread.sleep(1000);
				}
				if (i == banner2.size()) {
					break;
				}

			} catch (Exception e) {
				e.getMessage();
			}
		}
		System.out.println();

		List<WebElement> banner3 = driver.findElements(By.xpath(
				"//h2[.='Frequently Bought Items']/../following-sibling::div/descendant::div[@class='owl-stage']/descendant::a[@class='ng-binding']"));

		System.err.println("The total count of Banner3 is " + banner3.size());
		System.out.println("The Items are.....");

		WebElement arrow3 = driver.findElement(By.xpath(
				"(//div[@class='owl-stage-outer'])[position()=3]/following-sibling::div[@class='owl-nav']/descendant::div[@class='owl-next']"));
//		int X3 = arrow3.getLocation().x-200;
//		int Y3 = arrow3.getLocation().y-200;
//		js.executeScript("window.scrollBy("+arrow2.getLocation().x+400+","+arrow3.getLocation().y+400+")");

		for (int i = 0; i < banner3.size(); i++) {
			System.out.println(banner3.get(i).getText() + " " + i);
			a1.add(banner3.get(i).getText());
			try {
				if ((i + 1) % 5 == 0) {
					arrow3.click();
					Thread.sleep(1000);
				}
				if (i == banner3.size()) {
					break;
				}

			} catch (Exception e) {
				e.getMessage();
			}
		}

//		List<WebElement> all = driver.findElements(By.xpath("//div[@class='owl-stage-outer']/div[@class='owl-stage']//h6"));
//		System.err.println("Tolal items in the page are "+all.size());
//		for(WebElement ele : all) {
//			System.out.println(ele.getText());
//		}

		List<WebElement> allimg = driver.findElements(By.xpath(
				"//div[@id='dynamicDirective']/descendant::div[@class='owl-stage']/descendant::img[@class='img-responsive blur-up lazyautosizes lazyloaded']"));

		WebElement second = allimg.get(1);
		js.executeScript("window.scrollBy(" + X1 + "," + Y1 + ")");
		File temp = second.getScreenshotAs(OutputType.FILE);
		File per = new File("./screenshots/pic.png");
		try {
			FileHandler.copy(temp, per);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (allimg.size() >= 10) {
			System.out.println("titels are more than 10");
		} else {
			System.out.println("no titels are not more than 10");
		}

		System.out.println();

		System.err.println("All the items are....");

		for (int i = 0; i < a1.size(); i++) {
			System.out.println(a1.get(i) + " " + i);
		}

		driver.close();
	}
}
