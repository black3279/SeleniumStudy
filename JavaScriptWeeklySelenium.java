import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
 
public class JavaScriptWeeklySelenium {
 
    public static void main(String[] args) {
 
        JavaScriptWeeklySelenium selTest = new JavaScriptWeeklySelenium();
        selTest.crawl();
        
    }
 
    
    //WebDriver
    private WebDriver driver;
    private WebElement webElement;
    private String contentEng;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.ie.driver";
    public static final String WEB_DRIVER_PATH = "/D:/IEDriverServer.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public JavaScriptWeeklySelenium() {
        super();
        contentEng="";
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
          
           for(WebElement el : webElements) {
        	   //System.out.println(el.getTagName().concat(el.getText()));
        	   String clsStrPattern = el.getAttribute("class");
        	   //System.out.println(clsStrPattern);
        	   if(clsStrPattern.indexOf("notRead") == -1) continue;
        	   contentEng += "Title : ["+el.findElement(By.xpath("//a[@class='_d2(mcDragndrop|html5DragStart)']")).getText()+"]\n";
        	   el.findElement(By.xpath("//a[@class='_d2(mcDragndrop|html5DragStart)']")).sendKeys(Keys.ENTER);
			   Thread.sleep(5000);
			   
			   List<WebElement> Elements = driver.findElements(By.xpath("//p[@style='color: rgb(68, 68, 68); margin-top: 0.8em; margin-bottom: 0px;']"));
			   for(WebElement ele : Elements) {
				   contentEng += ele.getText().concat("\n");
			   }
			   
			   driver.navigate().back();
			   Thread.sleep(5000);
			   break;
			   
           }
           
           System.out.println(contentEng);
    
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            driver.close();
        }
 
    }
 
}
