// Первая реализация теста без исп параматеризации

// package mainPageTests;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import pom.MainPage;
//
//import java.time.Duration;
//
//public class MainPageTests {
//    private WebDriver driver;
//
//    @Before
//    public void setUp() {
//        // Драйвер для браузера
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");
//        System.setProperty("webdriver.http.factory", "jdk-http-client");
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//    }
//
//    //Проделываем тестовый сценарий
//    @Test
//    public void checkTextInDropListAfterClick() {
//        // Создаем объект класса главной страницы
//        MainPage objMainPage = new MainPage(driver);
//        // Выполняем проверки
//        objMainPage
//                .open()
//                .clickOnCookieButton()
//                .scrollToDropdownList()
//                .clickOnElementInDropList();
//
//        Assert.assertTrue(objMainPage.checkTextAfterClick());
//    }
//
//    @After
//    public void tearDown() {
//        // Закрыть браузер
//        driver.quit();
//    }
//}
