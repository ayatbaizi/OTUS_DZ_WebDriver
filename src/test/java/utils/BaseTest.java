package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {
   protected WebDriver driver;
   protected org.apache.logging.log4j.Logger logger = LogManager.getLogger(BaseTest.class);

   @BeforeEach
   public void StartUp() {
      WebDriverManager.chromedriver().setup();

   }


   @AfterEach
   public void End() {
      if (driver != null)
         driver.quit();
   }

   public void startDefaultMode() {
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      logger.info("Драйвер поднят");
   }

   public void startHeadlessMode() {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("headless");
      driver = new ChromeDriver(options);
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      logger.info("Драйвер поднят в режиме headless");
   }

   public void startKioskMode() {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("kiosk");
      driver = new ChromeDriver(options);
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      logger.info("Драйвер поднят  в режиме kiosk");
   }
}
