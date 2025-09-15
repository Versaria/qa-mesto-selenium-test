package ru.mesto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object для страницы авторизации.
 * Инкапсулирует логику работы с формой входа.
 * - Заполнение поля email
 * - Заполнение поля пароля
 * - Нажатие кнопки входа
 * - Использование явных ожиданий для стабильности тестов
 */
public class LoginPage {
    private final WebDriverWait wait;

    public LoginPage(WebDriverWait wait) {
        this.wait = wait;
    }

    public void login(String email, String password) {
        // Ожидание и заполнение поля email
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailField.sendKeys(email);

        // Заполнение поля пароля
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.sendKeys(password);

        // Нажатие кнопки авторизации
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("auth-form__button")));
        loginButton.click();
    }
}