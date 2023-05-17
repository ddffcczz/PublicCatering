package Save;
import PublicСatering.Bar.Bar;
import PublicСatering.Bar.BarAlcoholic.BarAlcoholic;
import PublicСatering.Cafe.Cafe;
import PublicСatering.Cuisine.Cuisine;
import PublicСatering.DiningRoom.DiningRoom;
import PublicСatering.PublicСatering;
import PublicСatering.Restaurant.Restaurant;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class DbSaver implements iSave{
    private List<Cuisine> cuisines = new ArrayList<>();
    private List<PublicСatering> caterings = new ArrayList<>();
    /*
        create database PublicСatering;
        CREATE USER 'javaLess'@'%' IDENTIFIED  BY 'fm7KCnHWz!8m5';
        GRANT ALL PRIVILEGES ON PublicСatering.* TO 'javaLess'@'%' WITH GRANT OPTION;
        flush privileges;
     */
    Connection connection  = DriverManager.getConnection("jdbc:mysql://5.188.168.117:65306/PublicСatering", "javaLess", "fm7KCnHWz!8m5");
    Statement statement = connection.createStatement();
    private ResultSet mysqlClient(String query) throws SQLException{
        return statement.executeQuery(query);
    }
    public DbSaver() throws SQLException {
        /*Bar
        CREATE TABLE Bar (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20), phoneNum VARCHAR(11), address VARCHAR(255), nonAlcoholic int DEFAULT 1, stars INT);
        insert into Bar values(null, "Золотой Ключик", "2063033", "Парковый, 1", null, null);
         */
        ResultSet barMysql = mysqlClient("select id,name,phoneNum,address,stars from Bar");
        while (barMysql.next()) {
            Long id = (long) barMysql.getInt("id");
            String name = barMysql.getString("name");
            String phoneNum = barMysql.getString("phoneNum");
            String address = barMysql.getString("address");
            Integer stars = barMysql.getInt("stars");
            caterings.add(new Bar(id,name,phoneNum,address,true,stars));
        }
        barMysql.close();
        /*DiningRoomMysql
            CREATE TABLE DiningRoom(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20), phoneNum VARCHAR(11), address VARCHAR(255), bound VARCHAR(100), stars INT);
            insert into DiningRoom values(null, "У Галины", "2987660", "ул. Дениса Давыдова, 13", "School", null);
         */
        ResultSet diningRoomMysql = mysqlClient("select id,name,phoneNum,address,bound,stars from DiningRoom");
        while (diningRoomMysql.next()) {
            Long id = (long) diningRoomMysql.getInt("id");
            String name = diningRoomMysql.getString("name");
            String phoneNum = diningRoomMysql.getString("phoneNum");
            String address = diningRoomMysql.getString("address");
            String bound = diningRoomMysql.getString("bound");
            Integer stars = diningRoomMysql.getInt("stars");
            caterings.add(new DiningRoom(id,name,phoneNum,address,bound,stars));
        }
        diningRoomMysql.close();
        /*Cafe
            CREATE TABLE Cafe(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20), phoneNum VARCHAR(11), address VARCHAR(255), fullCycle INT, stars INT);
            insert into Cafe values(null, "Хуторок", "2576061", "ул. Ленина, 60", 1, null);
         */
        ResultSet cafeMysql = mysqlClient("select id,name,phoneNum,address,fullCycle,stars from Cafe");
        while (cafeMysql.next()) {
            Long id = (long) cafeMysql.getInt("id");
            String name = cafeMysql.getString("name");
            String phoneNum = cafeMysql.getString("phoneNum");
            String address = cafeMysql.getString("address");
            Boolean fullCycle = cafeMysql.getBoolean("fullCycle");
            Integer stars = cafeMysql.getInt("stars");
            caterings.add(new Cafe(id,name,phoneNum,address,fullCycle,stars));
        }
        /*first dependence Cuisine
            CREATE TABLE Cuisine(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20), signatureDishes INT);
            insert into Cuisine values(null, "Unknown", 1);
         */
        ResultSet cuisineMysql = mysqlClient("select id,name,signatureDishes from Cuisine");
        while (cuisineMysql.next()) {
            Long id = (long) cuisineMysql.getInt("id");
            String name = cuisineMysql.getString("name");
            Boolean signatureDishes = cuisineMysql.getBoolean("signatureDishes");
            cuisines.add(new Cuisine(id,name,signatureDishes));
        }
        /*Restaurant
            CREATE TABLE Restaurant(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20), phoneNum VARCHAR(11), address VARCHAR(255), Cuisine INT, showProgram int, stars INT,FOREIGN KEY (Cuisine)  REFERENCES Cuisine (id));
            insert into Restaurant values(null, "Партизан", "2594499", "Комсомольский пр, 1", 1, 1, null);
         */
        ResultSet restaurantMysql = mysqlClient("select id,name,phoneNum,address,Cuisine,showProgram,stars from Restaurant");
        while (restaurantMysql.next()) {
            Long id = (long) restaurantMysql.getInt("id");
            String name = restaurantMysql.getString("name");
            String phoneNum = restaurantMysql.getString("phoneNum");
            String address = restaurantMysql.getString("address");
            Integer cuisineId = restaurantMysql.getInt("Cuisine");
            boolean showProgram = restaurantMysql.getBoolean("showProgram");
            Integer stars = restaurantMysql.getInt("stars");
            if(cuisineId!=0){
                for(int i=0;i<cuisines.size();i++){
                    if(cuisines.get(i).getId()==id){
                        caterings.add(new Restaurant(id,name,phoneNum,address,cuisines.get(i),showProgram,stars));
                    }
                }
            }
        }
        /*BarAlcoholic
            CREATE TABLE BarAlcoholic(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20), phoneNum VARCHAR(11), address VARCHAR(255), stars INT);;
            INSERT INTO BarAlcoholic values(null, "Кельш", "2939404", "ул. Ленина, 7а", null);
         */
        ResultSet barAlcoholicMysql = mysqlClient("select id,name,phoneNum,address,stars from BarAlcoholic");
        while (barAlcoholicMysql.next()) {
            Long id = (long) barAlcoholicMysql.getInt("id");
            String name = barAlcoholicMysql.getString("name");
            String phoneNum = barAlcoholicMysql.getString("phoneNum");
            String address = barAlcoholicMysql.getString("address");
            Integer stars = barAlcoholicMysql.getInt("stars");
            caterings.add(new BarAlcoholic(id,name,phoneNum,address,stars));
        }
        /*Price
            CREATE TABLE Price(id INT AUTO_INCREMENT PRIMARY KEY, bar_id int, item VARCHAR(20), value INT, FOREIGN KEY (bar_id) REFERENCES BarAlcoholic (id));
            INSERT INTO Price value(null, 1, "Efes", 250);
            INSERT INTO Price value(null, 1, "Tuborg", 350);
            INSERT INTO Price value(null, 1, "Budweiser", 450);
         */
        ResultSet priceMysql = mysqlClient("select id,bar_id,item,value from Price");
        Map<Long, ArrayList> priceL2 = new HashMap<>();
        while (priceMysql.next()) {
            Map<String, Integer> beerPrice = new HashMap<>();
            Long id = (long) priceMysql.getInt("id");
            Long bar_id = (long) priceMysql.getInt("bar_id");
            String item = priceMysql.getString("item");
            Integer value = priceMysql.getInt("value");
            beerPrice.put(item, value);
            if(priceL2.get(bar_id)==null){
                priceL2.put(bar_id, new ArrayList<>());
                priceL2.get(bar_id).add(beerPrice);
            }else{
                priceL2.get(bar_id).add(beerPrice);
            }
        }
        //Connect BarAlcoholic to Price
        for(int i=0;i< caterings.size();i++){
            if(caterings.get(i).getClass()== BarAlcoholic.class){
                Long key = caterings.get(i).getId();
                if(priceL2.get(key)!=null){
                    BarAlcoholic arr = (BarAlcoholic)caterings.get(i);
                    Map<String, Integer> beerPrice = new HashMap<>();
                    for(int y=0;y<priceL2.get(key).size();y++){
                        Map<String, Integer> beerTmpPrice = new HashMap<>();
                        beerTmpPrice = (Map<String, Integer>) priceL2.get(key).get(y); //я тут чуть не свихнулся с приведениями к нужным типам %)
                        beerTmpPrice.forEach((k,v)->{
                            beerPrice.put(k,v);
                        });
                    }
                        arr.connectPrice(beerPrice);
                }
            }
        }
    }

    @Override
    public void save(PublicСatering catering) {
        //to do /// insert into...
    }

    @Override
    public void drop(PublicСatering catering) {
        caterings.remove(catering);
    }

    @Override
    public void dropPosition(Integer pos) {
        if(pos!=null){
            caterings.remove(pos);
        }
    }

    @Override
    public List<PublicСatering> getAll() {
        return caterings;
    }

    @Override
    public PublicСatering getLastElement(){
        return caterings.get(caterings.size()-1);
    }

    @Override
    public List<PublicСatering> getAllByName(String name) {
        List<PublicСatering>cateringsByName = new ArrayList<>();
        for(int i=0;i< caterings.size();i++){
            PublicСatering currentCatering = caterings.get(i);
            if(currentCatering.getName().equals(name)){
                cateringsByName.add(currentCatering);
            }
        }
        return cateringsByName;
    }
    @Override
    public List<PublicСatering> getAllByStars(Integer star) {
        List<PublicСatering>cateringByStar = new ArrayList<>();
        for(int i=0;i< caterings.size();i++){
            PublicСatering currentСatering = caterings.get(i);
            if(currentСatering.getStars().equals(star)){
                cateringByStar.add(currentСatering);
            }
        }
        return cateringByStar;
    }
    @Override
    public List<PublicСatering> getAllByStarsRange(Integer startAge, Integer lastAge) {
        List<PublicСatering>cateringByStar = new ArrayList<>();
        for(int i=0;i< caterings.size();i++){
            PublicСatering currentСatering = caterings.get(i);
            if(currentСatering.getStars()>startAge && currentСatering.getStars()<lastAge){
                cateringByStar.add(currentСatering);
            }
        }
        return cateringByStar;
    }
    @Override
    public void dropALl() {
        caterings.clear();
    }
}
