package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
       driver.get("https://leetcode.com/ ");
      String url = driver.getCurrentUrl();
      if(url.contains("leetcode")){
        System.out.println("Sucessfully navigated to leetcode ");
      }
        System.out.println("end Test case: testCase01");
    }
    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        WebElement questions = driver.findElement(By.xpath("//*[text()='View Questions ']"));
        questions.click();
        Thread.sleep(2000);
        String problemUrl =driver.getCurrentUrl();
        if(problemUrl.contains("problemset")){
            System.out.println("Navigated to problems");
        }

        List<WebElement> listOfQues = driver.findElements(By.xpath("//div[@class=\"truncate\"]/a"));
    //    for(WebElement list : listOfQues){
    //     System.out.println(list.getText());
    //    }
        for(int i=1;i<=5;i++){
         String ques =   listOfQues.get(i).getText();
         System.out.println(ques);
        }

        System.out.println("end Test case: testCase02");
    }
    public  void testCase03(){
        System.out.println("Start Test case: testCase03");
        List<WebElement> listOfQues = driver.findElements(By.xpath("//div[@class=\"truncate\"]/a"));
        
            for(int i=1;i<2;i++){
                String ques = listOfQues.get(i).getText();
                System.out.println(ques);
                listOfQues.get(i).click();
           
            }
            String url =driver.getCurrentUrl();
            if(url.contains("two-sum")){
                System.out.println("Sucessfully navigated to Two Sum Problem");
            }
            System.out.println("end Test case: testCase03");
    }

    public  void testCase04(){
        System.out.println("Start Test case: testCase04");
        driver.findElement(By.id("submissions_tab")).click();
       WebElement submissionsTab = driver.findElement(By.xpath("//a[contains(text(),'Register or Sign In')]"));
       if(submissionsTab.getText().contains("Register or Sign In")){
        System.out.println("SucessFully Validated Register Sign in Text");
       }
       System.out.println("end Test case: testCase04");
    }
}
