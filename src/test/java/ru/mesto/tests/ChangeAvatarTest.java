package ru.mesto.tests;

import org.junit.Test;
import ru.mesto.pages.MainPage;
import ru.mesto.pages.ProfilePage;

/**
 * Тест изменения аватара профиля.
 * Проверяет функциональность смены изображения профиля пользователя.
 */
public class ChangeAvatarTest extends BaseTest {

    @Test
    public void changeAvatar() {
        MainPage mainPage = new MainPage(wait);
        ProfilePage profilePage = new ProfilePage(wait);

        // Открытие формы редактирования аватара
        mainPage.clickProfileImage();

        // Изменение аватара на новое изображение
        profilePage.changeAvatar("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenium.png");
    }
}