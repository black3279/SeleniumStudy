import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
 
public class StartSelenium {
 
    public static void main(String[] args) {
 
        StartSelenium selTest = new StartSelenium();
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
    
    public StartSelenium() {
        super();
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        //Driver SetUp
        driver = new InternetExplorerDriver();
        base_url = "https://www.naver.com";
    }
 
    public void crawl() {
 
        try {
        	
            driver.get(base_url);

            System.out.println(driver.getPageSource());
            
            Thread.sleep(1000);
    
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            driver.close();
        }
 
    }
 
}
