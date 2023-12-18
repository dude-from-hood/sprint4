// Первая реализация без использования параметризации

 package orderTests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pom.OrderPage;
import java.time.Duration;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class OrderPageTests {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Драйвер для браузера Хром
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");
//        System.setProperty("webdriver.http.factory", "jdk-http-client");
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

//      Драйвер для браузера Файерфокс
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

//Проделываем тестовый сценарий
    @Test
    public void checkOrderIsMade() {
// Создаем объект класса главной страницы
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage
                .open()
                .clickOnCookieButton()
                .clickOnButtonOrder()
                .fillDataInPersonsInfoForm()
                .fillDataInAboutRentForm();
        objOrderPage.clickAndConfirmOrder();

//Пишем проверку
        Assert.assertEquals("Тест не пройден! Сообщение о успешном заказе не отображается.",
                true, objOrderPage.checkMessageAboutSuccessOfOrder());
            System.out.println("Тест пройден. Сообщение о успешном заказе отображается.");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
