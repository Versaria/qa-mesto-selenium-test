package ru.mesto.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

/**
 * Тест прокрутки страницы к карточке контента.
 * Демонстрирует работу с JavaScriptExecutor для выполнения скриптов в браузере.
 */
public class ScrollToCardTest extends BaseTest {

    @Test
    public void scrollToCard() {
        // Ожидание загрузки карточки контента
        WebElement card = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".places__item")));

        // Прокрутка страницы к карточке с помощью JavaScript
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", card);

        // Проверка видимости карточки после прокрутки
        Boolean isVisibleAfterScroll = (Boolean) ((JavascriptExecutor) driver).executeScript(
                "var rect = arguments[0].getBoundingClientRect();" +
                        "return (rect.top >= 0 && rect.bottom <= (window.innerHeight || document.documentElement.clientHeight));",
                card);

        assertTrue("Карточка должна быть видимой после скролла", isVisibleAfterScroll);
    }
}