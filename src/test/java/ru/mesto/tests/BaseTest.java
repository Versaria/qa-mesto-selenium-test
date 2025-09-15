package ru.mesto.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.mesto.pages.LoginPage;

import java.time.Duration;

/**
 * Базовый класс для всех тестовых классов.
 * Содержит общую логику настройки и завершения тестов.
 * - Инициализация WebDriver с настройками Chrome
 * - Установка неявных ожиданий и времени ожидания
 * - Выполнение авторизации перед каждым тестом
 * - Закрытие браузера после каждого теста
 */
public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;

    @Before
    public void setUp() {
        // Настройка WebDriverManager для автоматической загрузки chromedriver
        WebDriverManager.chromedriver().setup();

        // Конфигурация опций Chrome для стабильной работы в CI/CD окружении
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        // Установка явных ожиданий с таймаутом 20 секунд
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Открытие тестовой страницы
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Инициализация страницы логина и выполнение авторизации
        loginPage = new LoginPage(wait);
        loginPage.login("versaria.o@yandex.ru", "qaswef-ketped-3motKo");

        // Ожидание загрузки ключевых элементов после авторизации
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("profile__image")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("profile__add-button")));
    }

    @After
    public void teardown() {
        // Корректное закрытие браузера после завершения теста
        if (driver != null) {
            driver.quit();
        }
    }
}