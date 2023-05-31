package Save;
import PublicСatering.PublicСatering;
import java.util.ArrayList;
import java.util.List;

public class RuntimeSaver implements iSave{
    private List<PublicСatering> caterings = new ArrayList<>();
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
