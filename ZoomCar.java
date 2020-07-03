package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomCar {

	public static void main(String[] args) throws InterruptedException, IOException {
		
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("https://www.zoomcar.com/chennai");
		
		driver.findElementByXPath("//a[@title=\"Start your wonderful journey\"]").click();
		
		driver.findElementByXPath("//div[@class=\"component-popular-locations\"]/div[2]").click();
		
		driver.findElementByXPath("//button[text()='Next']").click();
		
		driver.findElementByXPath("//div[@class=\"days\"]/div[2]").click();
		
		driver.findElementByXPath("//button[text()='Next']").click();
		
        driver.findElementByXPath("//div[@class=\"days\"]/div[3]").click();
		
		driver.findElementByXPath("//button[text()='Done']").click();
		
		Thread.sleep(3000);
		
		List<WebElement> noOfCars = driver.findElementsByXPath("//h3");
		
		int totalResult = noOfCars.size();
		
		System.out.println("No of cars available: "+ totalResult);
		
		List<WebElement> carPrice = driver.findElementsByXPath("//div[@class=\"price\"]");
		
		// To find highest paid car using Map
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		// Pass the values inside a map
		for (int i = 0; i < totalResult; i++) {
			String textPrice = carPrice.get(i).getText().trim();
			String Carname = noOfCars.get(i).getText();
			map.put(Carname, (Integer.parseInt(textPrice.replaceAll("[^\\d]", ""))));
		}
		// Find maximum price
		int maxKey = Collections.max(map.values());
		
		

		
		System.out.println(maxKey);
		
		//Printing all car and its values
		
		for (Entry<String, Integer> eachEntry : map.entrySet()) {
			
			System.out.println("Car Name: "+ eachEntry.getKey() + "Car Price: " + eachEntry.getValue());
			
			
		}
		
		//Printing max car value and submit that 
		
        int totalCount = map.size();
        
        for (Entry<String, Integer> eachEntry : map.entrySet()) {
			
			if (maxKey == eachEntry.getValue()) {
				
				
				System.out.println("Car Name with Maximum Value: "+ eachEntry.getKey() + "Car Price: " + eachEntry.getValue());
				
				String carName = eachEntry.getKey();
				
				WebElement snap = driver.findElementByXPath("(//h3[normalize-space(text())='"+carName+"']/ancestor::div)[9]");
				
				File snap0 = snap.getScreenshotAs(OutputType.FILE);
				File image0 = new File("./results/image1.jpg");
				FileUtils.copyFile(snap0, image0);
				
				//[normalize-space(text())='"+newUser+"']
				
				driver.findElementByXPath("//h3[normalize-space(text())='"+carName+"']/parent::div/following-sibling::div/div/button").click();
				}
			}
       
    	 
        Thread.sleep(2000);
		
        driver.close();
        
		  
	}

}
