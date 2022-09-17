# Курсовой проект по модулю «Автоматизация тестирования» для профессии «Инженер по тестированию»

## Инструкция по запуску

1. Установить [Docker](https://www.docker.com/).
2. Установить [IntelliJ IDEA](https://www.jetbrains.com/toolbox-app/) (подробное описание установки [тут](https://github.com/netology-code/javaqa-homeworks/blob/master/intro/idea.md)).
3. Создать проект в IDEA на базе Gradle.
4. Клонировать [репозиторий](https://github.com/Kitsune785/Coursework.git).
5. Запустить MySQL:
    - запустить Docker
    - в окне терминала IntelliJ IDEA выполнить команду `docker-compose up`
6. Запустить приложение:
    - открыть новую вкладку терминала
    - выполнить команду `java -jar aqa-shop.jar`
7. Запустить автотесты:
    - открыть новую вкладку в терминале
    - выполнить команду`./gradlew test`
    - остановить работу приложения сочетанием клавиш `Ctrl + C`

- отчет по тестированию Allure Report 
    - в командной строке выполнить команду `./gradlew allureServe`

### Документация к проекту
- [План тестирования](https://github.com/Kitsune785/Coursework/blob/main/documents/Plan.md)
- [Отчет о проведении тестирования](https://github.com/Kitsune785/Coursework/blob/main/documents/Report.md)
- [Отчет о проведении автоматизации](https://github.com/Kitsune785/Coursework/blob/main/documents/Summary.md)
