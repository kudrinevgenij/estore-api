**EStore-microservice**

Сервис запускается в среде выполнения **JVM 11**

Собран для версии spring-boot **2.7.18**, добавлен springdoc-ui для автогенерации документации по разработанным rest-методам

**Доступ к swagger-ui:** http://localhost:8081/estore-api.html



добавлена главная страница http://localhost:8081/

Реализация на данный момент:

+ минимальный функционал па заданию
+ отсутствуют тесты
+ отсутствует валидация
+ при необходимости загрузки данных из архива нужно грузить в читсую базу, иначе не исключены конфликты записи.
+ front реализован с помощью шаблонов непостредственно внутри приложения (пакет client), так как имеет очень малый размер и его доработка на данный момент отложена. В будущем возможно выделение его в отдельный модуль или удаление для использования приложения только в качестве rest-api.
+ отсутствует обработка ошибок.
