package ru.mesto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object для главной страницы приложения.
 * Содержит методы для взаимодействия с элементами главной страницы.
 * - Клик по изображению профиля для открытия формы редактирования
 */
public class MainPage {
    private final WebDriverWait wait;

    public MainPage(WebDriverWait wait) {
        this.wait = wait;
    }

    public void clickProfileImage() {
        // Ожидание кликабельности и клик по изображению профиля
        wait.until(ExpectedConditions.elementToBeClickable(By.className("profile__image"))).click();
    }
}