package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;

public class BaseTest {
   protected WebDriver driver;
   protected org.apache.logging.log4j.Logger logger = LogManager.getLogger(BaseTest.class);

   @BeforeAll
   public static void init() {
      WebDriverManager.chromedriver().setup();
   }


   @AfterEach
   public void close(){
      if (driver!=null)
         driver.quit();
   }

   public void checkClickVisible(By element){
      WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
      wait.until(ExpectedConditions.elementToBeClickable(element));
      wait.until(ExpectedConditions.visibilityOfElementLocated(element));
      driver.findElement(element).click();
   }

   public void startDefaultMode() {
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
      logger.info("Драйвер поднят");
   }

   public void startHeadlessMode() {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("headless");
      driver = new ChromeDriver(options);
      driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
      logger.info("Драйвер поднят в режиме headless");
   }

   public void startKioskMode() {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("kiosk");
      driver = new ChromeDriver(options);
      driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
      logger.info("Драйвер поднят  в режиме kiosk");
   }
}
