#Тестовое задание

Приложение Partslist, для отображения списка деталей для сборки компьютеров на складе. Записи хранить в базе данных. Схему таблички для хранения нужно придумать самому (достаточно одной таблицы).
Нужно показывать список уже имеющихся деталей (с пейджингом по 10 штук на странице). В списке должно быть наименование детали (String), обязательна ли она для сборки (boolean) и их количество на складе (int). На склад можно добавлять новые детали, редактировать существующие детали (любое из полей), удалять.

• Сортировка по принципу:

    а) все детали

    б) детали, которые необходимы для сборки, опциональные детали.

• Поиск по наименованию детали.

Создания базы данных, таблицы и заполнения ее тестовыми данными осуществляется с помощью файла:
create_parts_database.sql

Приложение доступно по урл:
http://localhost:8080/index.jsp
или http://localhost:8080/items

===========================
Используемые технологии:
- Maven 
- Spring 5.1.3.RELEASE
- Hibernate 5.3.7.FINAL
- Tomcat 
- Mysql
- Log4j

