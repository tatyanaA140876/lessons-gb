package ru;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.openqa.selenium.WebDriver;
import ru.lesson3.BasicTest;
import ru.lesson6.pages.LoginPage;

import static io.qameta.allure.Allure.parameter;

@DisplayName("Тесты магазина одежды")
public class ShopWithoutPageObjectTest extends BasicTest {
    private final String username = "bayivog868@kingsready.com";
    private final String password = "ZIP12345";
    private final Faker faker = new Faker();

    @Test
    @DisplayName("Изменение имени")
    @Description("В этом тесте мы меняем имя и проверяем, чтио оно корректно изменилось")
    @Severity(SeverityLevel.BLOCKER)
    void changeFirstNameTest() {
        String name = faker.name().firstName();



        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        new LoginPage(webDriver).login(username, password)
                .clickMyPersonalInformationButton()
                .changeFirstName(name)
                .inputPassword(password)
                .clickSaveButton()
                .clickBackToYourAccountButton()
                .clickMyPersonalInformationButton()
                .checkFirstName(name);
    }


    @Test
    @DisplayName("Изменение фамилии")
    @Description("В этом тесте мы меняем фамилию и проверяем, чтио оно корректно изменилось")
    @Severity(SeverityLevel.BLOCKER)
    void changeLastNameTest() {
        String name = faker.name().lastName();


        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=identity");
        new LoginPage(webDriver).login(username, password)
                .clickMyPersonalInformationButton()
                .changeLastName(name)
                .inputPassword(password)
                .clickSaveButton()
                .clickBackToYourAccountButton()
                .clickMyPersonalInformationButton()
                .checkLastName(name);
    }

    @DisplayName("Положить в корзину одежду с разных страниц")
    @ParameterizedTest(name = "Со страницы {0}")
    @ValueSource(strings = {"Summer Dresses", "T-shirts"})
    @Severity(SeverityLevel.CRITICAL)
    void selectSummerDressTest(String secondTab) {
        parameter("Название старницы", secondTab);
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=identity");
        new LoginPage(webDriver).login(username, password)
                .getHeaderBlock()
                .goToPage("Women", secondTab)
                .selectProduct(0)
                .checkProductAdded();
    }
}