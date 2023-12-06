package package1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\RahulShetty\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		int j=0;

		//Usecase01: To select particular one product(hardcoded)
		/*
		 * List<WebElement>productName=driver.findElements(By.cssSelector(
		 * "h4.product-name")); for(int i=0;i<productName.size();i++) {
		 * if(productName.get(i).getText().contains("Cucumber")) {
		 * driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(
		 * ); break; } }
		 */
        
		
		//usecase02: To select multiple product
		String[] itemsneeded = { "Cucumber", "Brocolli", "Beetroot","Carrot","Brinjal" };
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedname = name[0].trim();

			List itemsNeededList = Arrays.asList(itemsneeded);
			if (itemsNeededList.contains(formattedname)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsneeded.length)
				{
					break;
				}
			}
		}

		 //driver.close();

	}

}
