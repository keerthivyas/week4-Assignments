package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//input[@id='username']").sendKeys("Demosalesmanager");
		
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		
		driver.findElementByXPath("//input[contains(@class,'decorative')]").click();
		
		driver.findElementByXPath("//a[contains(text(),'CRM')]").click();
		
		driver.findElementByXPath("//a[text()='Contacts']").click();
		
		driver.findElementByXPath("//a[text()='Merge Contacts']").click();
		
		driver.findElementByXPath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a").click();
		
		Set<String> allWindow = driver.getWindowHandles();
		
		List<String> list = new ArrayList<String>(allWindow);
		
		driver.switchTo().window(list.get(1));
		
		driver.findElementByXPath("//a[text()='DemoCustomer']").click();
		
		driver.switchTo().window(list.get(0));
		
		driver.findElementByXPath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a").click();
        
        Set<String> allWindow2 = driver.getWindowHandles();
		
		List<String> list1 = new ArrayList<String>(allWindow2);
		
		driver.switchTo().window(list1.get(1));
		
	    driver.findElementByXPath("//a[text()='dontship2me']").click();
		
	    driver.switchTo().window(list1.get(0));
	    
		driver.findElementByClassName("buttonDangerous").click();
		
		Alert alert1 = driver.switchTo().alert();
		
		alert1.accept();
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		//Thread.sleep(20000);
		
		/*
		 * for (String eachWindow : allWindow) {
		 * 
		 * WebDriver window = driver.switchTo().window(eachWindow);
		 * 
		 * System.out.println(window.getTitle());
		 * 
		 * }
		 */

		
	}

}
