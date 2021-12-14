package ru.lesson3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class SwagLabs extends BasicTest{
    private final  String username = "standard_user";
    private final  String password = "secret_sauce";

    @Test
    void changeNameTest() {

        webDriver.get("https://www.saucedemo.com/");
        webDriver.findElement(By.name("user-name")).sendKeys("standard_user");
        webDriver.findElement(By.name("password")).sendKeys("secret_sauce");
        webDriver.findElement(By.name("login-button")).click();

        webDriver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();

        webDriver.findElement(By.xpath("//button[@id='back-to-products']")).click();

        webDriver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).click();

        webDriver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();


    }
}
