import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class JavaScriptWeeklySelenium {
 
    public static void main(String[] args) {
 
        JavaScriptWeeklySelenium selTest = new JavaScriptWeeklySelenium();
        selTest.crawl();
        
    }
 
    
    //WebDriver
    private WebDriver driver;
    private WebElement webElement;
    private List<WebElement> Elements;
    private String contentEng;
    private String contentKor;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.ie.driver";
    public static final String WEB_DRIVER_PATH = "/D:/IEDriverServer.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public JavaScriptWeeklySelenium() {
        super();
        contentEng=contentKor="";
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
            
            WebDriverWait wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("id")));
            
            webElement = driver.findElement(By.id("id"));
            webElement.sendKeys("30133279");
			
			//패스워드 입력
            webElement = driver.findElement(By.id("pw"));
            webElement.sendKeys("password");
            
            
            
            webElement = driver.findElement(By.className("btn_global"));
            webElement.submit();
            
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@id='minime']")));
            
            driver.switchTo().frame("minime");
            
            webElement = driver.findElement(By.xpath("//a[@class='link_new']"));
            webElement.sendKeys(Keys.ENTER);
            
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='search']")));
            
            webElement = driver.findElement(By.xpath("//input[@class='search']"));
            webElement.sendKeys("JavaScript Weekly");
            webElement.sendKeys(Keys.ENTER);
            
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ol[@class='mailList   sender_context']/li")));
            
            //System.out.println(driver.getPageSource());
            
           List<WebElement> webElements = driver.findElements(By.xpath("//ol[@class='mailList   sender_context']/li"));
          
           for(WebElement el : webElements) {
        	  
        	   String clsStrPattern = el.getAttribute("class");
        	   
        	   if(clsStrPattern.indexOf("notRead") == -1) continue;
        	   contentEng += "Title : ["+el.findElement(By.xpath("//a[@class='_d2(mcDragndrop|html5DragStart)']")).getText()+"]\n";
        	   el.findElement(By.xpath("//a[@class='_d2(mcDragndrop|html5DragStart)']")).sendKeys(Keys.ENTER);
        	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@style='color: rgb(68, 68, 68); margin-top: 0.8em; margin-bottom: 0px;']")));
			   
			   Elements = driver.findElements(By.xpath("//p[@style='color: rgb(68, 68, 68); margin-top: 0.8em; margin-bottom: 0px;']"));
			   for(WebElement ele : Elements) {
				   contentEng += ele.getText().concat("\n");
				   if(contentEng.length()>4500) break;
			   }
			   
			   driver.navigate().back();
			   break;
			   
           }
           
           driver.navigate().to("https://papago.naver.com/");
           wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='txtSource']")));
           driver.findElement(By.xpath("//textarea[@id='txtSource']")).sendKeys(contentEng);
           /*webElement = driver.findElement(By.xpath("//textarea[@id='txtSource']"));
           JavascriptExecutor jse = (JavascriptExecutor)driver;
           jse.executeScript("arguments[0].value='"+contentEng+"';", webElement);*/
           Thread.sleep(7000);
           Elements = driver.findElements(By.xpath("//div[@id='txtTarget']/span"));
           for(WebElement ele : Elements) {
        	   contentKor += ele.getText().concat("\n");
           }
           
           //System.out.println(contentKor);
           FileOutputStream fos = null;
           try {
	           fos = new FileOutputStream(new File("test.txt"));
	           byte[] content = contentKor.getBytes();
	           
	           fos.write(content);
	           fos.flush();
	           fos.close();
	           
	           System.out.println("DONE");
           } catch(IOException e) {
        	   e.printStackTrace();
           } finally {
               try {
                   if(fos != null) fos.close();
               } catch(IOException e) {
                   e.printStackTrace();
               }
           }

    
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            driver.close();
        }
 
    }
 
}
