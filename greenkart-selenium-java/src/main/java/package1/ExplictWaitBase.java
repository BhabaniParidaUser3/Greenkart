package package1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplictWaitBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.setProperty("webdriver.chrome.driver", "G:\\RahulShetty\\chromedriver-win64\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
				WebDriverWait w=new WebDriverWait(driver,5);
				String[] itemsneeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot", "Brinjal" };
				addItems(driver, itemsneeded);
				driver.findElement(By.xpath("//img[@alt='Cart']")).click();
				driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
				driver.findElement(By.cssSelector("input.promoCode")).sendKeys("Bhabani");
				driver.findElement(By.cssSelector("button.promoBtn")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
				System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
				driver.close();


			}

			public static void addItems(WebDriver driver, String[] itemsneeded) {
				
				int j = 0;
				List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
				for (int i = 0; i < products.size(); i++) {
					String[] name = products.get(i).getText().split("-");
					String formattedname = name[0].trim();

					List itemsNeededList = Arrays.asList(itemsneeded);
					if (itemsNeededList.contains(formattedname)) {
						j++;
						driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
						if (j == itemsneeded.length) {
							break;
						}
					}
				}
				
			}


	}


