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
            webElement.sendKeys("아이디 입력");
			
			//패스워드 입력
            webElement = driver.findElement(By.id("pw"));
            webElement.sendKeys("비밀번호 입력");
            
            webElement = driver.findElement(By.className("btn_global"));
            webElement.submit();
            
            Thread.sleep(1000);
    
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            driver.close();
        }
 
    }
 
}
