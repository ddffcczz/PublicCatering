package Print;
import PublicСatering.PublicСatering;
import java.util.List;

public class ConsolePrint implements iPrint{
    @Override
    public void showPublicСatering(List<PublicСatering> catering) {
        for(int i=0;i<catering.size();i++){
            System.out.println("console: "+catering.get(i));
        }
    }
    @Override
    public void show(PublicСatering catering) {
        System.out.println("console: "+catering);
    }
}
