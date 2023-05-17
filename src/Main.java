import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import Print.ConsolePrint;
import Print.FilePrint;
import Print.iPrint;
import PublicСatering.Bar.Bar;
import PublicСatering.Bar.BarAlcoholic.BarAlcoholic;
import PublicСatering.Cafe.Cafe;
import PublicСatering.DiningRoom.DiningRoom;
import PublicСatering.Cuisine.Cuisine;
import PublicСatering.Restaurant.Restaurant;
import Save.FileSaver;
import Save.DbSaver;
import Save.RuntimeSaver;
import Save.iSave;

public class Main {
    private static iSave saver = null;
    private static iPrint print = null;

    private static void initSaver() throws IOException, SQLException {
        System.out.println("Select method save");
        System.out.println("1 - local");
        System.out.println("2 - file");
        System.out.println("3 - db");
        Scanner scanner = new Scanner(System.in);
        int saveNumber = scanner.nextInt();
        switch (saveNumber){
            case 2:
                saver = (iSave) new FileSaver();
                break;
            case 3:
                saver = (iSave) new DbSaver();
                break;
            default:
                Map<String, Integer> beerPrice = new HashMap<>();
                beerPrice.put("Bud", 250);
                beerPrice.put("Heineken", 350);
                saver = new RuntimeSaver();
                saver.save(new Restaurant("ExampleRest1","2594499","Street, 1", new Cuisine("Unknown",true),false));
                saver.getLastElement().setStars(4);
                saver.save(new Bar("Gold Key","2063033","Street, 2", true));
                saver.getLastElement().setStars(3);
                saver.save(new BarAlcoholic("Kelsh","2939404","Street, 7", beerPrice));
                saver.getLastElement().setStars(5);
                saver.save(new Cafe("Khutorok","2576061","Street, 60", true));
                saver.getLastElement().setStars(4);
                saver.save(new DiningRoom("U Gali", "2987660" ,"Street,13", "School"));
                saver.getLastElement().setStars(2);
        }
    }
    private static void initPrint() throws IOException {
        System.out.println("Select method print");
        System.out.println("1 - console");
        System.out.println("2 - file");
        Scanner scanner = new Scanner(System.in);
        int printNumber = scanner.nextInt();
        switch (printNumber){
            case 2:
                print = new FilePrint();
                break;
            default:
                print = new ConsolePrint();
        }
    }
    public static void main(String[] args) throws IOException, SQLException {
        initSaver();
        initPrint();
        print.showPublicСatering(saver.getAll());
    }
}