package ecom_shopping;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

 
public class eco_shopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//1.Access the demo site https://www.saucedemo.com
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String URL = "https://www.saucedemo.com";
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
//2.Login to the system with following credentials
		
		WebElement userName=driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		WebElement passwaord =driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement loginbutton=driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		userName.sendKeys("performance_glitch_user");
		passwaord.sendKeys("secret_sauce");
		loginbutton.click();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
//3.Check the price of product, Sauce Labs Fleece Jacket is $49.99
		
		String testPrice="$"+"49.99";
		String priceOfProduct=driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[4]/div[2]/div[2]/div")).getText();
		if (priceOfProduct.equalsIgnoreCase(testPrice)) {
			System.out.println("Correct Price");
			System.out.println(testPrice);
		 } else {
			System.out.println("Incorrect Price");
		 }	
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
//4.Add any two products into the cart
		
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
		
//5.Click cart icon in the top  
		
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
		
//6.Verify if the selected items are in the cart	
		
		String realProductNameOne="Sauce Labs Fleece Jacket";
		String realProductNameTwo="Sauce Labs Bike Light";
		String productOneName=driver.findElement(By.xpath("//*[@id=\"item_5_title_link\"]/div")).getText();
		String productTwoName=driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div")).getText();
		if (productOneName.equalsIgnoreCase(realProductNameOne) && productTwoName.equalsIgnoreCase(realProductNameTwo) ) {
			System.out.println("Two Products Added to Cart");
		 } else {
			System.out.println("Not Two Product Added in to Cart");
		 }
		
//7.Click checkout button
		
		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
		
//8.Provide a random firsname , lastname and a zip code in the next page
		
		driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("sutha");
		driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Ari");
		driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("31000");

//9.Click continue button
		
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		
//10.Click Finish
		
		driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();


	}

}
