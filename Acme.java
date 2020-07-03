package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Acme {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://acme-test.uipath.com/account/login");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement email = driver.findElement(By.id("email"));
		
		WebElement login = driver.findElement(By.id("buttonLogin"));
		
		Actions builder = new Actions(driver);
		
		builder.click(email).sendKeys("kumar.testleaf@gmail.com", Keys.TAB).sendKeys("leaf@12").perform();
		
		login.click();

		WebElement vendor = driver.findElement(By.xpath("//button[text()=' Vendors']"));
		
		WebElement searchVendor = driver.findElement(By.xpath("//button[text()=' Vendors']/following-sibling::ul/li"));
		
		builder.moveToElement(vendor).moveToElement(searchVendor).click().perform();
		
		WebElement vendorName = driver.findElement(By.id("vendorName"));
		
		WebElement Search = driver.findElement(By.id("buttonSearch"));
		
		builder.click(vendorName).sendKeys("Blue Lagoon").click(Search).perform();
		
		Thread.sleep(2000);
		
		WebElement Country = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[5]"));
		
		String CountryName = Country.getText();
		
		WebElement city = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[4]"));
		
		String cityName = city.getText();
		
		System.out.println("Country: " + CountryName);
		
		System.out.println("City: " + cityName);
		
		driver.close();

	}

}
