# QA Mesto Selenium Test Project 👤

![License](https://img.shields.io/badge/License-MIT-yellow.svg)
![Java](https://img.shields.io/badge/Java-11-blue)
![Maven](https://img.shields.io/badge/Maven-3.9+-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.20-green)
![JUnit](https://img.shields.io/badge/JUnit-4-red)

Проект автоматизированного тестирования для [Mesto](https://qa-mesto.praktikum-services.ru/) с использованием Selenium WebDriver и Java. Проект включает комплексные тесты для проверки функциональности профиля пользователя и управления контентом.

## 🚀 Быстрый старт
### Требования
- **Java JDK 11+** (рекомендуется Zulu 11.0.27+)
- **Apache Maven 3.9+**
- **Google Chrome** (версия 139+)
- **ChromeDriver** (версия 139.0.7258.68+)

### Установка и запуск
```bash
git clone https://github.com/Versaria/qa-mesto-selenium-test.git
cd qa-mesto-selenium-test
mvn clean test
```

## 📂 Структура проекта
```
qa-mesto-selenium-test/
├── src/main/java/ru/mesto/pages/
│   ├── LoginPage.java              # Страница авторизации
│   ├── MainPage.java               # Главная страница
│   ├── ProfilePage.java            # Страница профиля
│   └── CardPage.java               # Страница управления карточками
├── src/test/java/ru/mesto/tests/
│   ├── AuthorizationTest.java      # Тесты авторизации
│   ├── ChangeAvatarTest.java       # Тесты изменения аватара
│   ├── AddDeleteCardTest.java      # Тесты добавления/удаления карточек
│   └── ScrollToCardTest.java       # Тесты скролла к карточкам
├── target/site/jacoco/             # Отчет о покрытии тестами
├── pom.xml                         # Конфигурация Maven
└── README.md
```

## 📋 Функционал
1. **Авторизация в системе**
    - Ввод email и пароля
    - Нажатие кнопки входа
    - Проверка успешной авторизации

2. **Управление профилем**
    - Изменение аватара пользователя
    - Загрузка нового изображения профиля
    - Сохранение изменений

3. **Управление контентом**
    - Добавление новых карточек с изображениями
    - Удаление существующих карточек
    - Проверка видимости добавленного контента

4. **Навигация по странице**
    - Скролл к элементам страницы
    - Ожидание загрузки элементов
    - Взаимодействие с динамическими элементами

## 📊 Покрытие тестами
Проект включает комплексные модульные тесты с 100% покрытием кода:

**Результаты тестирования:**
- ✅ Tests run: 4
- ✅ Failures: 0
- ✅ Errors: 0
- ✅ Skipped: 0
- ✅ Code Coverage: 100%

**Запуск тестов с проверкой покрытия:**
```bash
mvn clean test
```

Отчет о покрытии генерируется в директории `target/site/jacoco/index.html`

## 💻 Пример работы
```java
// Авторизация в системе
LoginPage loginPage = new LoginPage(wait);
loginPage.login("email@example.com", "password");

// Изменение аватара профиля
MainPage mainPage = new MainPage(wait);
ProfilePage profilePage = new ProfilePage(wait);

mainPage.clickProfileImage();
profilePage.changeAvatar("https://example.com/avatar.png");

// Добавление и удаление карточки
CardPage cardPage = new CardPage(wait);
cardPage.addCard("Прага", "https://example.com/prague.jpg");
cardPage.deleteCard();

// Скролл к карточке
WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(
    By.cssSelector(".places__item")));
((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", card);
```

## 📜 Лицензия
MIT License

## 🤝 Как внести вклад
1. Форкните репозиторий
2. Создайте ветку (`git checkout -b feature/new-test`)
3. Сделайте коммит (`git commit -am 'Add new test case'`)
4. Запушьте ветку (`git push origin feature/new-test`)
5. Откройте Pull Request

---

<details>
<summary>🔧 Дополнительные команды</summary>

```bash
# Генерация отчета о тестировании
mvn test surefire-report:report

# Запуск конкретного тестового класса
mvn test -Dtest=AuthorizationTest

# Запуск с детальным логированием
mvn test -Dselenium.log.level=ALL
```
</details>