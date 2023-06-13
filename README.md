# ![PublicСatering](https://user-images.githubusercontent.com/31171568/238048826-650ff8b5-f3d5-4070-8f0e-d88c0b48fb4b.jpg)
# README

PublicСatering - букинг для общепита с возможностью бронирования столиков \(без предоплаты\).

### Структура

```
src/
├── Main.java
├── Print
│   ├── ConsolePrint.java
│   ├── FilePrint.java
│   └── iPrint.java
├── PublicСatering
│   ├── Bar
│   │   ├── BarAlcoholic
│   │   │   └── BarAlcoholic.java
│   │   └── Bar.java
│   ├── Cafe
│   │   └── Cafe.java
│   ├── Cuisine
│   │   └── Cuisine.java
│   ├── DiningRoom
│   │   └── DiningRoom.java
│   ├── PublicСatering.java
│   └── Restaurant
│       └── Restaurant.java
└── Save
    ├── DbSaver.java
    ├── FileSaver.java
    ├── iSave.java
    └── RuntimeSaver.java
```

### Основные классы

* PublicСatering - основной класс
* Bar - дочерний 2 уровня

    * BarAlcoholic - дочерний 3 уровня
    
* Cafe - дочерний 2 уровня
* DiningRoom -дочерний 2 уровня
* Restaurant -дочерний 2 уровня

    * Cuisine - композиция для Restaurant
    

### Внешние библиотеки

* mysql.connector.java \(8.0.30\) - для взаимодействия с бд
* google.code.gson \(2.8.0\) - для реализации сохранения\\импорта из json-файлов
* ch.qos.logback.classic \(1.2.3\) - просил websocket установить
* java.websocket.Java.WebSocket \(1.5.1\) - websocket server, для общения с android app.

### Структура БД

* Структура:

    ```sql
    CREATE TABLE Bar (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20), phoneNum VARCHAR(11), address VARCHAR(255), nonAlcoholic int DEFAULT 1, stars INT);
    CREATE TABLE DiningRoom(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20), phoneNum VARCHAR(11), address VARCHAR(255), bound VARCHAR(100), stars INT);
    CREATE TABLE Cafe(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20), phoneNum VARCHAR(11), address VARCHAR(255), fullCycle INT, stars INT);
    CREATE TABLE Cuisine(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20), signatureDishes INT);
    CREATE TABLE Restaurant(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20), phoneNum VARCHAR(11), address VARCHAR(255), Cuisine INT, showProgram int, stars INT,FOREIGN KEY (Cuisine)  REFERENCES Cuisine (id));
    CREATE TABLE BarAlcoholic(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20), phoneNum VARCHAR(11), address VARCHAR(255), stars INT);
    CREATE TABLE Price(id INT AUTO_INCREMENT PRIMARY KEY, bar_id int, item VARCHAR(20), value INT, FOREIGN KEY (bar_id) REFERENCES BarAlcoholic (id));
    ```
	
* Минимальное наполнение:

    ```sql
    INSERT INTO Bar values(null, "Золотой Ключик", "2063033", "Парковый, 1", null, null);
    INSERT INTO DiningRoom values(null, "У Галины", "2987660", "ул. Дениса Давыдова, 13", "School", null);
    INSERT INTO Cafe values(null, "Хуторок", "2576061", "ул. Ленина, 60", 1, null);
    INSERT INTO Cuisine values(null, "Unknown", 1);
    INSERT INTO Restaurant values(null, "Партизан", "2594499", "Комсомольский пр, 1", 1, 1, null);
    INSERT INTO BarAlcoholic values(null, "Кельш", "2939404", "ул. Ленина, 7а", null);
    INSERT INTO Price value(null, 1, "Efes", 250);
    INSERT INTO Price value(null, 1, "Tuborg", 350);
    INSERT INTO Price value(null, 1, "Budweiser", 450);

    ```
