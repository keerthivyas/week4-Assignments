package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWebTable {
	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		/*
		 * driver.findElementById("txtStationFrom").clear();
		 * driver.findElementById("txtStationFrom").sendKeys("Chennai Egmore");
		 * driver.findElementById("txtStationFrom").clear();
		 * driver.findElementById("txtStationTo").sendKeys("Katpadi Jn");
		 * driver.findElementById("buttonFromTo").click();
		 *
	}

}
