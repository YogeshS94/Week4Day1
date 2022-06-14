package Week4.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2Frame {
	public static void main(String arg[]) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		// Setting up the URL
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(ele);
		
		driver.findElement(By.xpath("//body//b[@id='topic']//following::input")).sendKeys("HI not friendly topic...");
		
//		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		WebElement ele2 = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(ele2);
		
		String text = driver.findElement(By.xpath("//body//b[contains(text(),'Inner Frame')]")).getText();
		System.out.println(text);
		
		WebElement checkB = driver.findElement(By.xpath("//body//b[contains(text(),'Inner Frame')]//following::input"));
		System.out.println(checkB.isSelected());
		
		checkB.click();
		System.out.println(checkB.isSelected());
		
		driver.switchTo().defaultContent();
		WebElement ele3 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(ele3);
		
		WebElement sel = driver.findElement(By.xpath("//select[@id='animals']"));
		
		Select s = new Select(sel);
		s.selectByValue("cat");
		s.selectByVisibleText("Avatar");
		System.out.println(sel.getAttribute("value"));
	}
}