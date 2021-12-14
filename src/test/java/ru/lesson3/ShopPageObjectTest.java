package ru.lesson3;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.reflections.util.ConfigurationBuilder.build;

public class ShopPageObjectTest extends BasicTest{
    private final  String username = "bayivog868@kingsready.com";
    private final  String password = "ZIP12345";
    private final Faker faker = new Faker();

    @Test
    void changeNameTest() {

        String name = faker.name().firstName();

        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        webDriver.findElement(By.id("email")).sendKeys("bayivog868@kingsready.com");
        webDriver.findElement(By.id("passwd")).sendKeys("ZIP12345");
        webDriver.findElement(By.id("SubmitLogin")).click();
        webDriver.findElement(By.xpath("//li[contains(., 'My personal information')]")).click();

        webDriver.findElement(By.id("firstname")).clear();
        webDriver.findElement(By.id("firstname")).sendKeys(name);

        webDriver.findElement(By.id("old_passwd")).sendKeys("ZIP12345");
        webDriver.findElement(By.xpath("//button[contains(., 'Save')]")).click();

        webDriver.findElement(By.xpath("//li[contains(., 'Back to your account')]")).click();

        webDriver.findElement(By.xpath("//li[contains(., 'My personal information')]")).click();


        String value;
        assertThat(webDriver.findElement(By.id("firstname")).getAttribute("value"))
                .isEqualTo(name);
    }

    @Test
    void changeLastNameTest() {

        String name = faker.name().lastName();

        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        webDriver.findElement(By.id("email")).sendKeys("bayivog868@kingsready.com");
        webDriver.findElement(By.id("passwd")).sendKeys("ZIP12345");
        webDriver.findElement(By.id("SubmitLogin")).click();
        webDriver.findElement(By.xpath("//li[contains(., 'My personal information')]")).click();

        webDriver.findElement(By.id("lastname")).clear();
        webDriver.findElement(By.id("lastname")).sendKeys(name);

        webDriver.findElement(By.id("old_passwd")).sendKeys("ZIP12345");
        webDriver.findElement(By.xpath("//button[contains(., 'Save')]")).click();

        webDriver.findElement(By.xpath("//li[contains(., 'Back to your account')]")).click();

        webDriver.findElement(By.xpath("//li[contains(., 'My personal information')]")).click();


        String value;
        assertThat(webDriver.findElement(By.id("lastname")).getAttribute("value"))
                .isEqualTo(name);
    }

    @Test

    void selectCasualDressesTest() {
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        webDriver.findElement(By.id("email")).sendKeys("bayivog868@kingsready.com");
        webDriver.findElement(By.id("passwd")).sendKeys("ZIP12345");
        webDriver.findElement(By.id("SubmitLogin")).click();

        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//a[text()='Women']")))
                .build()
                .perform();

        webDriver.findElement(By.xpath("//a[text()= 'Casual Dresses']")).click();

        List<WebElement> products = webDriver.findElements(By.xpath("//div[@class='product-name']"));

       webDriver.findElement(By.xpath("//a[@class='button ajax_add_to_cart_button btn btn-default']")).click();

       webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class= 'icon-ok']")));

    }
    @Test

    void selectBlousesTest() {
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        webDriver.findElement(By.id("email")).sendKeys("bayivog868@kingsready.com");
        webDriver.findElement(By.id("passwd")).sendKeys("ZIP12345");
        webDriver.findElement(By.id("SubmitLogin")).click();

        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//a[text()='Women']")))
                .build()
                .perform();

        webDriver.findElement(By.xpath("//a[text()= 'Blouses']")).click();

        List<WebElement> products = webDriver.findElements(By.xpath("//div[@class='product-name']"));

        webDriver.findElement(By.xpath("//a[@class='button ajax_add_to_cart_button btn btn-default']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class= 'icon-ok']")));
    }

    }
