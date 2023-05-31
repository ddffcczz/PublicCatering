package Save;
import PublicСatering.Bar.Bar;
import PublicСatering.Bar.BarAlcoholic.BarAlcoholic;
import PublicСatering.Cafe.Cafe;
import PublicСatering.DiningRoom.DiningRoom;
import PublicСatering.PublicСatering;
import PublicСatering.Restaurant.Restaurant;
import com.google.gson.*;
import java.io.Reader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSaver implements iSave {
    private List<PublicСatering> caterings = new ArrayList<>();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private void addArr(PublicСatering[] arr){
        for(int i=0;i<arr.length;i++){
            caterings.add(arr[i]);
        }
    }

    public FileSaver() throws IOException {
        //Restaurant
        Reader readRestaurant = new FileReader("import/Restaurant.json");
        Restaurant[] restauranttJson = gson.fromJson(readRestaurant, Restaurant[].class);
        addArr(restauranttJson);
        //Bar
        Reader readBar = new FileReader("import/Bar.json");
        Bar[] barJson = gson.fromJson(readBar, Bar[].class);
        addArr(barJson);
        //BarAlcoholic
        Reader readBarAlcoholic = new FileReader("import/BarAlcoholic.json");
        BarAlcoholic[] barAlcoholicJson = gson.fromJson(readBarAlcoholic, BarAlcoholic[].class);
        addArr(barAlcoholicJson);
        //Cafe
        Reader readCafe = new FileReader("import/Cafe.json");
        Cafe[] cafeJson = gson.fromJson(readCafe, Cafe[].class);
        addArr(cafeJson);
        //DiningRoom
        Reader readDiningRoom = new FileReader("import/DiningRoom.json");
        DiningRoom[] diningRoomJson = gson.fromJson(readDiningRoom, DiningRoom[].class);
        addArr(diningRoomJson);
    }

    @Override
    public void save(PublicСatering catering) {
        caterings.add(catering);
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

    @Override
    public void saveRestaurant(PublicСatering catering) {

    }
}
