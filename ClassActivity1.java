package Week4.Day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassActivity1 {
	public static void main(String arg[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Yogesh");
		Thread.sleep(5000);
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();

		if(text.contains("Yogesh")) {
			System.out.println("Name is correctly entered and entered name is: " + text);
		}
		else {
			System.out.println("Entered Name is not correct");
		}
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
		
		
	}
}
