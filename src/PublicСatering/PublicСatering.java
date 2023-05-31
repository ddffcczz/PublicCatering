package PublicСatering;
import java.util.Objects;

public class PublicСatering {
    protected Long id;
    protected String name;
    protected Integer phoneNum;
    protected String address;
    protected Integer stars;

    public PublicСatering(String name,Integer phoneNum,String address){
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
    }
    public PublicСatering(String name,Integer phoneNum,String address,Integer stars){
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
        this.stars = stars;
    }
    public PublicСatering(Long id,String name,Integer phoneNum,String address,Integer stars){
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
        this.stars = stars;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Integer getStars(){
        return stars;
    }
    public Long getId(){
        return id;
    }
    public void setStars(Integer star){
        this.stars = star;
    }

    // заблокировал сеетер - вроде пока не нужен.
//    public void setPhoneNum (Integer phoneNum) {
//        this.phoneNum = phoneNum;
//    }
    public Integer getPhoneNum () {
        return phoneNum;
    }
    public String getAddress(){
        return address;
    }

    @Override
    public String toString() {
        return "PublicСatering{" +
                "id=" + id +
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
        PublicСatering that = (PublicСatering) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(phoneNum, that.phoneNum) && Objects.equals(address, that.address) && Objects.equals(stars, that.stars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNum, address, stars);
    }
}
