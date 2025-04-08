# Юнит-тесты для приложения Stellar Burgers
Данный проект написан на языке Java 11 для покрытия кода приложения [Stellar Burgers](https://stellarburgers.nomoreparties.site/) юнит-тестами.

## Задача 
Покрыть тестами классы `Bun`, `Burger`, `Ingredient`, `IngredientType`. Процент покрытия данных классов должен быть не ниже 70%.

## Используемые библиотеки:
- [Junit4](https://junit.org/junit4/)
- [Mockito](https://site.mockito.org/)
- [Jacoco](https://www.jacoco.org/jacoco/)

## Запуск тестов
Этот проект использует `Maven` для запуска тестов. Запуск тестов выполняется командой:
```bash
$ mvn clean test
```
## Отчёт покрытия
Путь к отчёту покрытия классов тестами: 
`target/site/jacoco/index.html`
