package Save;
import java.sql.SQLException;
import java.util.List;
import PublicСatering.PublicСatering;
public interface iSave {
    void save(PublicСatering catering);
    void drop(PublicСatering catering);
    void dropPosition(Integer pos);
    List<PublicСatering>getAll() throws SQLException;
    PublicСatering getLastElement();
    List<PublicСatering>getAllByName(String name);
    List<PublicСatering>getAllByStars(Integer age);
    List<PublicСatering>getAllByStarsRange(Integer startAge, Integer lastAge);
    void dropALl();

}
