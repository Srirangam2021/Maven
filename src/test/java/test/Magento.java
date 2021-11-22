package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Magento {
	
	@Test(priority=10,enabled=false)
	public void register() {
	
				WebDriverManager.chromedriver().setup();
				// TODO Auto-generated method stub
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get("http://magento.com");
				
				driver.findElement(By.partialLinkText("Sign in")).click();
				driver.findElement(By.linkText("Create an account")).click();
				
				driver.findElement(By.id("firstname")).sendKeys("Shanti");
				driver.findElement(By.id("lastname")).sendKeys("Iruku");
				driver.findElement(By.id("email_address")).sendKeys("shanti.iruku@gmail.com");
				
				
				driver.findElement(By.id("self_defined_company")).sendKeys("YesMSystems");
				Select cp=new Select(driver.findElement(By.id("company_type")));
				cp.selectByIndex(3);
				//cp.selectByValue("tech_partner");
				
				
				Select cp1=new Select(driver.findElement(By.id("individual_role")));
				cp1.selectByIndex(1);
				
				Select country=new Select(driver.findElement(By.id("country")));
				country.selectByIndex(10);	
					
								
				driver.findElement(By.id("html-body")).sendKeys("YesMSystems123");
				driver.findElement(By.id("password-confirmation")).sendKeys("YesMSystems123");
				
				//driver.findElement(By.id("agree_terms")).click();
				
				driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"recaptcha-f979c2ff515d921c34af9bd2aee8ef076b719d03\"]/div/div/iframe")));
				driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
				driver.switchTo().defaultContent();
				
				if(!driver.findElement(By.id("agree_terms")).isSelected());
				{
					driver.findElement(By.id("agree_terms")).click();
				}
				driver.quit();
			
	}

@Test(priority=20)
public void login() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
/*driver.manage().timeouts().implicitlywait(Duration.ofSeconds(30));
driver.manage().timeouts().implicitlyWait(duration.ofseconds(30));*/
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
 driver.get("http://magento.com");
 
 String url=driver.getCurrentUrl();
 System.out.println(url);
 
 String title=driver.getTitle();
 System.out.println(title);
 
 
 if(title.contains("eCommerce"))
 {
	 System.out.println("Expected page Loaded");
 }
 
 driver.navigate().refresh();
 
 driver.findElement(By.xpath("//*[@id=\"gnav_565\"]/span/span/span/span")).click();
 
 driver.findElement(By.id("email")).sendKeys("shanti.iruku@gmail.com");
 
 
 driver.findElement(By.id("pass")).sendKeys("shanti123");
 driver.findElement(By.id("send2")).click();
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")));
 String error=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
 System.out.println(error);
 if (error.equals("Invalid Login or Password"))
 {
	 System.out.println("Test Pass");
	 
 }
 else 
 {
	 System.out.println("Test Fail");
 }
 
 
 //driver.close();
 
 
 driver.quit();
 
 

	}

}
