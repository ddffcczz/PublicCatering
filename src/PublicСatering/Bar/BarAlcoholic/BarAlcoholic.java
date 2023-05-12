package PublicСatering.Bar.BarAlcoholic;
import PublicСatering.Bar.Bar;
import java.util.Map;
import java.util.Objects;

public class BarAlcoholic extends Bar {
    private Map<String, Integer> beer;
    public BarAlcoholic(String name, Integer phoneNum, String address, Map<String, Integer>beer) {
        super(name, phoneNum, address, false);
        this.beer = beer;
    }
    public BarAlcoholic(Long id,String name, Integer phoneNum, String address, int stars) {
        super(id, name, phoneNum, address, false, stars);
    }
    public void connectPrice(Map<String, Integer>beer){
        this.beer = beer;
    }

    @Override
    public String toString() {
        return "BarAlcoholic{" +
                "beer=" + beer +
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
        BarAlcoholic that = (BarAlcoholic) o;
        return Objects.equals(beer, that.beer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), beer);
    }
}
