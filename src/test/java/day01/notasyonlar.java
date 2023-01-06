package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class notasyonlar {


    WebDriver driver;


    @Before
    public void setUp(){

         WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }



    @After
    public void tearDown(){
        driver.quit();

    }


    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle()); // sayfanın baslıgını getirir
        System.out.println(driver.getCurrentUrl()); // sayfanın URL getiriyo
        driver.navigate().refresh(); // yenileme
        driver.navigate().forward(); // ileri gitmek
        driver.navigate().to("https://www.google.com"); //o testin içerisinde baska bir sayfaya gecis yapmak icin



    }

    @Test

    public void test02(){
        driver.get("https://www.google.com");
        String ilkSayfaWHD = driver.getWindowHandle();
      //  System.out.println(driver.getWindowHandle());  // driver her calistiginde farkli WHD getirir.
        // ne demek? biz bir driver actıgımızda o driveri kapatmadığımz müddetce onu kullanabilirz.
        // ne işe yarar? yeni sekme açmak istesek

        driver.switchTo().newWindow(WindowType.TAB); // yeni sekmede ne istersen onu açar
        driver.navigate().to("https://www.amazon.com");
        // bi onceki sayfaya geri dönmek istersek işte WHD kullanırız. ilk WHD 'ne geri donmem lazım.

        driver.switchTo().window(ilkSayfaWHD); // handle'ı stringe atadık ki burda o sekmeye gecmek icin rahatca kullandık.
        driver.switchTo().newWindow(WindowType.WINDOW); // bu da yeni sayfa açar boş sayfa aç diyoruz hepsinden alakasız.
        driver.get("https://www.wisequarter.com");

    }
}
