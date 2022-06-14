package Week4.Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassActivity2 {
	
	public static void main(String arg[]) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		String parentWin = driver.getWindowHandle();
		
		driver.findElement(By.linkText("FLIGHTS")).click();
		Thread.sleep(5000);
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		
		List<String> window = new ArrayList<String>(windows);
		
		driver.switchTo().window(window.get(1));
		
		String title = driver.getTitle();
		System.out.println("Title of the Next Tab/Window is: " + title);
		
		driver.close();
		
		driver.switchTo().window(parentWin);
		String title1 = driver.getTitle();
		System.out.println("Title of the Parent page is: " + title1);
	}
	
}
