package Week4.Day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3Amazon {
	/*Amazon:
		1.Load the URL https://www.amazon.in/
		2.search as oneplus 9 pro 
		3.Get the price of the first product
		4. Print the number of customer ratings for the first displayed product
		5. Click the first text link of the first image
		6. Take a screen shot of the product displayed
		7. Click 'Add to Cart' button
		8. Get the cart subtotal and verify if it is correct.
		9.close the browser */
	
	public static void main(String arg[]) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		// Setting up the URL
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		String parentWindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

		Set<String> sa = driver.getWindowHandles();
		List<String> wind = new ArrayList<String>(sa);
		
		driver.switchTo().window(wind.get(1));
		
		String price = driver.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium apexPriceToPay']")).getText();
		
		System.out.println("Price of the mobile: " + price);
		
		String rating = driver.findElement(By.xpath("(//div[@id='averageCustomerReviews']//span[@class='a-declarative']//span[@id='acrCustomerReviewText'])[1]")).getText();
		
		System.out.println("Rating is : " + rating);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./FirstProduct.png");
		FileUtils.copyFile(source, destination);
		
		
		
		
		
		
	}

}
