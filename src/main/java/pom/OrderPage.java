package pom;
import org.openqa.selenium.*;

public class OrderPage {
    private final WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By cookieButton = By.id("rcc-confirm-button");

    //локатор кнопки "Заказать" в хедере
    private final By buttonOrderInHeader = By.xpath("//*[contains(text(), 'Заказать')]");

    //локаторы Для кого самокат
    private final By firstname = By.xpath("//input[contains(@placeholder, 'Имя')]");
    private final By lastname = By.xpath("//input[contains(@placeholder, 'Фамилия')]");
    private final By address = By.xpath("//input[contains(@placeholder, 'Адрес')]");
    private final By station = By.xpath("//input[contains(@placeholder, 'Станция')]");
    private final By chosenStation = By.xpath("//*[contains(text(), 'Парк культуры')]");

    private final By telephone = By.xpath("//input[contains(@placeholder, 'Телефон')]");
    private final By buttonNext = By.xpath("//button[contains(text(), 'Далее')]");

    //локаторы Про аренду
    private final By deliveryDay = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentalDayLength = By.xpath("//div[@class='Dropdown-control']");
    private final By chooseDayLength = By.xpath("//*[contains(text(), 'двое суток')]");
    private final By colorScooter = By.xpath("//*[contains(text(), 'серая безысходность')]");
    private final By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By makeAnOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Локатор модалки о фин подтверждении заказа

    private final By modalSureToOrder = By.xpath("//div[contains(text(), 'Хотите')]");
    private final By confirmButton = By.xpath("//button[text()='Да']");

    //Локатор модалки об успешном оформлении заказа
    private final By infoTextOrderSuccess = By.xpath("//*[contains(text(), 'Заказ оформлен')]");


    //Добавляем конструктор
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage open() {
        driver.get(url);
        return this;
    }

    public OrderPage clickOnCookieButton() {
        driver.findElement(cookieButton).click();
        return this;
    }

    //    Из чего состоит позитивный сценарий:
//    Нажать кнопку «Заказать». На странице две кнопки заказа.
    public OrderPage clickOnButtonOrder() {
        driver.findElement(buttonOrderInHeader).click();
        return this;
    }

    //    Заполнить форму заказа Для кого самокат
    public OrderPage fillDataInPersonsInfoForm() {
        driver.findElement(firstname).sendKeys("Иван");
        driver.findElement(lastname).sendKeys("Петров");
        driver.findElement(address).sendKeys("ул.Льва Толстого, д.16");
        driver.findElement(telephone).sendKeys("89991112233");
        driver.findElement(station).click();
        driver.findElement(chosenStation).click();
        driver.findElement(buttonNext).click();
        return this;
    }

    //    Заполнить форму заказа Про Аренду
    public OrderPage fillDataInAboutRentForm() {
        driver.findElement(rentalDayLength).click();
        driver.findElement(chooseDayLength).click();
        driver.findElement(colorScooter).click();
        driver.findElement(commentField).sendKeys("привет - это тест!");
        driver.findElement(deliveryDay).sendKeys("02.04.2023");
        driver.findElement(makeAnOrderButton).click();
        return this;
    }
    public OrderPage clickAndConfirmOrder(){
        driver.findElement(confirmButton).click();
        return this;
    }

    public boolean checkMessageAboutSuccessOfOrder() {
        return driver.findElement(infoTextOrderSuccess).isDisplayed();
    }

}

