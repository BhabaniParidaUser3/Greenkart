package package1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\\\RahulShetty\\\\chromedriver-win64\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,10);
		driver.manage().window().maximize();
		String[] itemsNeed= {"iphone X","Samsung Note 8"};
		String username="rahulshettyacademy";
		String password="learning";
		login(driver,username,password,wait);
		additem(driver,itemsNeed);		
		

	}
	public static void login(WebDriver driver, String username, String password,WebDriverWait wait)
	{
		driver.findElement(By.cssSelector("#username")).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='user']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#okayBtn")));
		driver.findElement(By.cssSelector("#okayBtn")).click();
		WebElement staticDropdown=driver.findElement(By.cssSelector("select.form-control"));
		Select sel=new Select(staticDropdown);
		sel.selectByIndex(2);
		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.cssSelector("#signInBtn")).click();

		
		

		
		
	}
	public static void additem(WebDriver driver,String[] itemsNeed)
	{
		List<WebElement> itemOnPage=driver.findElements(By.cssSelector("h4.card-title"));
		List itemsneedList=Arrays.asList(itemsNeed);
		int j=0;

		for (int i=0;i<itemOnPage.size();i++)
		{
			if(itemOnPage.contains(itemsneedList))
			{
				j++;
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
				if(j==itemsNeed.length)
				{
					break;
				}
			}
		}
		
	}

}
