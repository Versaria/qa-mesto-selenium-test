package ru.mesto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object для страницы редактирования профиля.
 * Инкапсулирует логику работы с формой изменения аватара.
 * - Ввод URL нового аватара
 * - Сохранение изменений
 */
public class ProfilePage {
    private final WebDriverWait wait;

    public ProfilePage(WebDriverWait wait) {
        this.wait = wait;
    }

    public void changeAvatar(String avatarUrl) {
        // Ввод URL нового аватара
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("owner-avatar"))).sendKeys(avatarUrl);

        // Нажатие кнопки сохранения
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(".//form[@name='edit-avatar']/button[text()='Сохранить']"))).click();
    }
}