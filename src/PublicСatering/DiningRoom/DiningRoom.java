package PublicСatering.DiningRoom;
import PublicСatering.PublicСatering;

import java.util.Objects;
public class DiningRoom extends PublicСatering {
    protected String bound;
    public DiningRoom(String name, String phoneNum, String address, String bound) {
        super(name, phoneNum, address);
        this.bound = bound;
    }
    public DiningRoom(Long id, String name, String phoneNum, String address, String bound, Integer stars) {
        super(id,name,phoneNum,address,stars);
        this.bound = bound;
    }

    @Override
    public String toString() {
        return "DiningRoom{" +
                "bound='" + bound + '\'' +
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
        DiningRoom that = (DiningRoom) o;
        return Objects.equals(bound, that.bound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bound);
    }
}
