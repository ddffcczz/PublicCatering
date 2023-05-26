import PublicСatering.Cuisine.Cuisine;
import PublicСatering.PublicСatering;
import PublicСatering.Restaurant.Restaurant;
import Save.DbSaver;

import java.sql.SQLException;
import java.util.Scanner;

public class ServiceAction extends PublicСatering{


    public static PublicСatering createRestaurant() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean SignatureDishes = false;
        String nameCuisine = "Non";
        boolean showProgram = false;
        System.out.print("Введите наименование ресторана: ");
        String name = scanner.next();

        System.out.print("Введите номер телефона ресторана: ");
        int phoneNumber = scanner.nextInt();

        System.out.print("Введите адрес ресторана: ");
            System.out.print("Введите город: ");
            String city = scanner.next();
            System.out.print("Введите улицу: ");
            String street = scanner.next();
            System.out.print("Введите номер дома: ");
            Integer house = scanner.nextInt();
        String address = city + ", " + street + ", " + house;

        System.out.print("Есть ли фирменное блюдо в меню? 1 - да, 0 - нет: ");
        int modeSignatureDishes = scanner.nextInt();
        if (modeSignatureDishes == 1){
            SignatureDishes = true;
            System.out.print("Введите название фирменного блюда: ");
            nameCuisine = scanner.next();
        } else if (modeSignatureDishes == 0){
            SignatureDishes = false;
        } else {
            SignatureDishes = false;
            System.out.println("введено неверное число. Фирменного блюда нет.");
        }

        Cuisine cuisine = new Cuisine(nameCuisine,SignatureDishes);

        System.out.print("Есть ли шоу-программа? 1 - да, 0 - нет: ");
        int modeShowProgram = scanner.nextInt();
        if (modeShowProgram == 1){
            showProgram = true;
        } else if (modeShowProgram == 0){
            showProgram = false;
        } else {
            showProgram = false;
            System.out.println("введено неверное число. шоу-программы нет.");
        }

        PublicСatering publicСatering = new Restaurant(name, phoneNumber, address, cuisine, showProgram);

        return publicСatering;
    }
    public static PublicСatering createBar() throws SQLException {

        return null;
    }

    public static PublicСatering createBarAlcoholic() throws SQLException {

        return null;
    }

    public static PublicСatering createCafe() throws SQLException {

        return null;
    }

    public static PublicСatering createDiningRoom() throws SQLException {

        return null;
    }


    public ServiceAction(String name, Integer phoneNum, String address) {
        super(name, phoneNum, address);
    }

    public ServiceAction(String name, Integer phoneNum, String address, Integer stars) {
        super(name, phoneNum, address, stars);
    }

    public ServiceAction(Long id, String name, Integer phoneNum, String address, Integer stars) {
        super(id, name, phoneNum, address, stars);
    }

}
