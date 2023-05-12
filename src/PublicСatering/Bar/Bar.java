package PublicСatering.Bar;
import PublicСatering.PublicСatering;
import java.util.Objects;

public class Bar extends PublicСatering {
    boolean nonAlcoholic;
    public Bar(String name, Integer phoneNum, String address, boolean nonAlcoholic) {
        super(name, phoneNum, address);
        this.nonAlcoholic = nonAlcoholic;
    }
    public Bar(Long id,String name, Integer phoneNum, String address, boolean nonAlcoholic, int stars) {
        super(id,name,phoneNum,address,stars);
        //super(id, name, phoneNum, address);
        this.nonAlcoholic = nonAlcoholic;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "nonAlcoholic=" + nonAlcoholic +
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
        Bar bar = (Bar) o;
        return nonAlcoholic == bar.nonAlcoholic;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nonAlcoholic);
    }
}
