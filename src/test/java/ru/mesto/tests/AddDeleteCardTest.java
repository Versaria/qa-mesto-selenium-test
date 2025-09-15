package ru.mesto.tests;

import org.junit.Test;
import ru.mesto.pages.CardPage;

/**
 * Тест добавления и удаления карточки контента.
 * Проверяет полный цикл жизни карточки: создание → удаление.
 */
public class AddDeleteCardTest extends BaseTest {

    @Test
    public void addDeleteCard() {
        CardPage cardPage = new CardPage(wait);

        // Добавление новой карточки с изображением Праги
        cardPage.addCard("Прага", "https://code.s3.yandex.net/qa-automation-engineer/java/files/new_photo_selenium.jpg");

        // Удаление созданной карточки
        cardPage.deleteCard();
    }
}