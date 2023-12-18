package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Шаг 1. Создали page object — класс для Главной страницы
public class MainPage {
// Шаг 2. Добавили поле driver
    private WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";

//Шаг 3. Добавляем локаторы и геттеры
    public WebElement getAccordionElement(String elementText) {
    return driver.findElement(By.xpath("//*[text() = '" + elementText + "']"));
}
    public WebElement getAccordionDropDown(String dropDownText) {
        return driver.findElement(By.xpath("//*[text() = '" + dropDownText + "']"));
    }
    private final By cookieButton = By.id("rcc-confirm-button");


// Шаг 4. Добавили конструктор класса page object
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

// Шаг 5. Добавляем методы для глав страницы
    public MainPage open() {
        driver.get(url);
        return this;
    }
    public MainPage clickOnCookieButton() {
        driver.findElement(cookieButton).click();
        return this;
    }
    public MainPage scrollToDropdownList(){
        WebElement element = driver.findElement(By.className("accordion"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
        return this;
    }
    // метод для клика по Вопросу из вып. списка
    public MainPage clickAccordionElement(String elementText) {
        getAccordionElement(elementText).click();
        return this;
    }

    //метод для получения текста после клика по Вопросу
//    public MainPage showTextAfterClick(String dropDownElement){
//        getAccordionDropDown(dropDownElement).getText();
//        return this;
//    }

    public MainPage showTextAfterClick(String dropDownElement) {
        WebElement accordionElement = getAccordionDropDown(dropDownElement);
        String textAfterClick = accordionElement.getText();
        // Что-то делаем с полученным текстом, например, выводим его в консоль
        System.out.println("Text after click: " + textAfterClick);
        return this;
    }

//    public MainPage clickOnElementInDropList() {
//        driver.findElement(dropListQuestion).click();
//        return this;
//    }
//    public boolean checkTextAfterClick() {
//        return driver.findElement(textInElemetAfterClick).isDisplayed();
//    }
//
//    public void clickOnQuestionByText(String text) {
//        driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]")).click();
//    }


//    //Сашина реализация
//    public By getDropList(int number) {
//        return By.id("accordion__heading-" + number);
//    }
//
//    public By getDropListQuestion(int number) {
//        return By.id("accordion__panel-" + number);
//    }
}
