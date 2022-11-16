import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utils.BaseTest;

public class FirstTest extends BaseTest {
   @Test
   public void cookieTest(){
      driver.get("https://ya.ru");
//        Добавить Cookie#1 с параметром Otus1 и значением Value1
      driver.manage().addCookie(new Cookie("Otus1", "Value1"));
//        Добавить Cookie#2 с параметром Otus2 и значением Value2
      driver.manage().addCookie(new Cookie("Otus2", "Value2"));
//        Добавить Cookie#3 с параметром Otus3 и значением Value3 (добавлять через переменную, переменная должна быть сохранена)
      Cookie cookie = new Cookie("Otus3", "Value3");
      driver.manage().addCookie(cookie);
//        Добавить Cookie#4 с параметром Otus4 и значением Value4
      driver.manage().addCookie(new Cookie("Otus4", "Value4"));
//        Вывести на экран все Cookie
      System.out.println(driver.manage().getCookies());
//        Вывести на экран Cookie1
      System.out.println(driver.manage().getCookieNamed("Otus1"));
//        Удалить Cookie#2 по имени куки
      driver.manage().deleteCookieNamed("Otus2");
//        Удалить Cookie#3 по переменной Cookie
      driver.manage().deleteCookieNamed("Otus3");
//        Удалить все куки, убедиться что их нет
      driver.manage().deleteAllCookies();
//        *Для тех, кому легко: добавить куки авторизации на Otus.ru (без использования getCookies)

   }
}
