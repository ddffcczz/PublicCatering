package PublicСatering.Cafe;
import PublicСatering.PublicСatering;
import java.util.Objects;

public class Cafe extends PublicСatering {
    boolean fullCycle;
    public Cafe(String name, String phoneNum, String address, boolean fullCycle) {
        super(name, phoneNum, address);
        this.fullCycle = fullCycle;
    }
    public Cafe(Long id,String name, String phoneNum, String address, boolean fullCycle, Integer stars) {
        super(id,name,phoneNum,address,stars);
        //super(name, phoneNum, address);
        this.fullCycle = fullCycle;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "fullCycle=" + fullCycle +
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
        Cafe cafe = (Cafe) o;
        return fullCycle == cafe.fullCycle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fullCycle);
    }
}
