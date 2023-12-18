package mainPageTests;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pom.MainPage;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MainPageParametrizedTest {
    private WebDriver driver;
    private final String elementText;
    private final String dropDownText;
    private final boolean result;

    //Создаем конструктор, который принимает 2 параметра: текст Вопроса и текст секции, которая откроется после клика
    public MainPageParametrizedTest(String elementText, String dropDownText, boolean result) {
        this.elementText = elementText;
        this.dropDownText = dropDownText;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        // Перечислить локаторы и ожидаемые тексты
        return Arrays.asList(new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", true},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", true},
                {"Как рассчитывается время аренды?","Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", true},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", true},
                {"Можно ли продлить заказ или вернуть самокат раньше?","Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", true},
                {"Вы привозите зарядку вместе с самокатом?","Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",true},
                {"Можно ли отменить заказ?","Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",true},
                {"Я жизу за МКАДом, привезёте?","Да, обязательно. Всем самокатов! И Москве, и Московской области.",true},
        });
    }

    @Before
    public void setUp() {
        // Драйвер для браузера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    //Проделываем тестовый сценарий
    @Test
    public void checkTextInDropdownListForEachQuestion() {
        // Создаем объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        // Выполняем проверку, будет 8 запусков теста
        objMainPage
                .open()
                .clickOnCookieButton()
                .scrollToDropdownList()
                .clickAccordionElement(elementText)
                .showTextAfterClick(dropDownText);
        Assert.assertEquals(result, objMainPage.getAccordionDropDown(dropDownText).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
