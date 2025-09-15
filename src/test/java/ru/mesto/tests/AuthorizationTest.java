package ru.mesto.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

/**
 * Тест авторизации пользователя.
 * Проверяет успешность входа в систему путем проверки наличия ключевых элементов
 * на главной странице после авторизации.
 */
public class AuthorizationTest extends BaseTest {

    @Test
    public void successfulAuthorization() {
        // Проверка отображения изображения профиля
        assertTrue("После авторизации должен отображаться элемент профиля",
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.className("profile__image"))).isDisplayed());

        // Проверка отображения кнопки добавления контента
        assertTrue("После авторизации должна отображаться кнопка добавления",
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.className("profile__add-button"))).isDisplayed());

        // Проверка отображения имени пользователя
        assertTrue("После авторизации должно отображаться имя пользователя",
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.className("profile__title"))).isDisplayed());

        // Проверка отображения описания профиля
        assertTrue("После авторизации должно отображаться описание профиля",
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.className("profile__description"))).isDisplayed());
    }
}