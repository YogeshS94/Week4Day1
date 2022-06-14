package Week4.Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		// Setting up the URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
				
		//Entering the username and password to login
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Clicking Create Contact button in contact page
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']//following-sibling::a")).click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windows);
		
		driver.switchTo().window(window.get(1));
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		Thread.sleep(1000);
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']//following-sibling::a")).click();
		Thread.sleep(3000);
		
		Set<String> windowsTo = driver.getWindowHandles();
		List<String> windowTo = new ArrayList<String>(windowsTo);
		
		driver.switchTo().window(windowTo.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]//a")).click();
		Thread.sleep(5000);
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		Alert al = driver.switchTo().alert();
		al.accept();
		
		System.out.println("Title of the page is: " + driver.getCurrentUrl());
		driver.close();
	}
}
