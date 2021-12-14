package ru.gb.lesson5;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;



public class SwagLabs {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = WebDriverManager.chromedriver().create();

        webDriver.get("https://www.saucedemo.com/");

        webDriver.manage().window().setSize(new Dimension(1600, 920));

        webDriver.findElement(By.name("user-name")).sendKeys("standard_user");
        webDriver.findElement(By.name("password")).sendKeys("secret_sauce");
        webDriver.findElement(By.name("login-button")).click();

        webDriver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//button[@id='back-to-products']")).click();

        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).click();
        Thread.sleep(3000);

        webDriver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        Thread.sleep(3000);
        webDriver.quit();
    }

}
