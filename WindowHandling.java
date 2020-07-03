package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElementByXPath("//button[@id=\"home\"]").click();
		Set<String> allWindow = driver.getWindowHandles();
	    List<String> List = new ArrayList<String>(allWindow);
		 driver.switchTo().window(List.get(1));
		System.out.println("Pop Up window Title : "+driver.getTitle());
		driver.close();
		driver.switchTo().window(List.get(0));
		System.out.println("Main window Title : "+driver.getTitle());
		driver.close();

	}

}
