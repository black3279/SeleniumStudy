import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
 
public class HelloSelenium {
 
    public static void main(String[] args) {
 
        HelloSelenium selTest = new HelloSelenium();
        selTest.crawl();
        
    }
 
    
    //WebDriver
    private WebDriver driver;
    private WebElement webElement;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.ie.driver";
    public static final String WEB_DRIVER_PATH = "/D:/IEDriverServer.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public HelloSelenium() {
        super();
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        //Driver SetUp
        driver = new InternetExplorerDriver();
        base_url = "https://www.naver.com";
    }
 
    public void crawl() {
 
        try {
        	
            driver.get(base_url);

            webElement = driver.findElement(By.className("link_login"));
            

            webElement.sendKeys(Keys.ENTER);
            
            Thread.sleep(1000);
            
            webElement = driver.findElement(By.id("id"));
            webElement.sendKeys("30133279");
			
			//패스워드 입력
            webElement = driver.findElement(By.id("pw"));
            webElement.sendKeys("password");
            
            
            
            webElement = driver.findElement(By.className("btn_global"));
            webElement.submit();
            
            Thread.sleep(25000);
            
            driver.switchTo().frame("minime");
            
            webElement = driver.findElement(By.xpath("//a[@class='link_new']"));
            webElement.sendKeys(Keys.ENTER);
            
            Thread.sleep(5000);
            
            webElement = driver.findElement(By.xpath("//input[@class='search']"));
            webElement.sendKeys("JavaScript Weekly");
            webElement.sendKeys(Keys.ENTER);
            
            Thread.sleep(5000);
            
            //System.out.println(driver.getPageSource());
            
           List<WebElement> webElements = driver.findElements(By.xpath("//ol[@class='mailList   sender_context']/li"));
           //System.out.println(webElements);
           for(WebElement el : webElements) {
        	   //System.out.println(el);
        	   
           }
    
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            driver.close();
        }
 
    }
 
}
