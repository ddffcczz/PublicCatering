package PublicСatering.Cuisine;

import java.util.Objects;

public class Cuisine {
   protected Long id;
   protected String name;
   protected boolean signatureDishes;
    public Cuisine(String name, boolean signatureDishes){
        this.name = name;
        this.signatureDishes = signatureDishes;
    }
    public Cuisine(Long id,String name, boolean signatureDishes){
        this.id = id;
        this.name = name;
        this.signatureDishes = signatureDishes;
    }

    public Long getId(){
        return id;
    }
    @Override
    public String toString() {
        return "Cuisine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", signatureDishes=" + signatureDishes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuisine cuisine = (Cuisine) o;
        return signatureDishes == cuisine.signatureDishes && Objects.equals(name, cuisine.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, signatureDishes);
    }
}
