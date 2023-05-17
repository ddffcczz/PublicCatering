package PublicСatering.Restaurant;
import PublicСatering.Cuisine.Cuisine;
import PublicСatering.PublicСatering;
import java.util.Objects;

public class Restaurant extends PublicСatering {
    protected Cuisine cuisine;
    protected boolean showProgram;

    public Restaurant(String name, String phoneNum, String address, Cuisine cuisine, boolean showProgram) {
        super(name, phoneNum, address);
        this.cuisine = cuisine;
        this.showProgram = showProgram;
    }
    public Restaurant(String name, String phoneNum, String address, Cuisine cuisine, boolean showProgram, Integer stars) {
        super(name, phoneNum, address, stars);
        this.cuisine = cuisine;
        this.showProgram = showProgram;
    }
    public Restaurant(Long id,String name, String phoneNum, String address, Cuisine cuisine, boolean showProgram, Integer stars) {
        super(id,name, phoneNum, address, stars);
        this.cuisine = cuisine;
        this.showProgram = showProgram;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "cuisine=" + cuisine +
                ", showProgram=" + showProgram +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", phoneNum=" + phoneNum +
                ", address='" + address + '\'' +
                ", stars=" + stars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Restaurant that = (Restaurant) o;
        return showProgram == that.showProgram && Objects.equals(cuisine, that.cuisine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuisine, showProgram);
    }
}
