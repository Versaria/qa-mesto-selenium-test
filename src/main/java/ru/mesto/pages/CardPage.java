package ru.mesto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object для управления карточками контента.
 * Содержит методы для добавления и удаления карточек.
 * - Открытие формы добавления карточки
 * - Заполнение названия и ссылки на изображение
 * - Сохранение карточки
 * - Удаление карточки
 */
public class CardPage {
    private final WebDriverWait wait;

    public CardPage(WebDriverWait wait) {
        this.wait = wait;
    }

    public void addCard(String title, String imageUrl) {
        // Открытие формы добавления новой карточки
        wait.until(ExpectedConditions.elementToBeClickable(By.className("profile__add-button"))).click();

        // Заполнение названия карточки
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']"))).sendKeys(title);

        // Заполнение ссылки на изображение
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='link']"))).sendKeys(imageUrl);

        // Сохранение карточки
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(".//form[@name='new-card']/button[text()='Сохранить']"))).click();

        // Ожидание появления кнопки удаления (подтверждение создания карточки)
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(".//button[contains(@class, 'card__delete-button')]")));
    }

    public void deleteCard() {
        // Нахождение и нажатие кнопки удаления карточки
        WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(".//button[contains(@class, 'card__delete-button')]")));
        deleteButton.click();

        // Ожидание исчезновения кнопки удаления (подтверждение удаления карточки)
        wait.until(ExpectedConditions.invisibilityOf(deleteButton));
    }
}