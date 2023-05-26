package Print;

import PublicСatering.PublicСatering;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;



public class FilePrint implements iPrint{
    //Gson gson = new Gson();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    FileWriter writer = new FileWriter("output.json", false);
    public FilePrint() throws IOException {
    }

    @Override
    public void showPublicСatering(List<PublicСatering> catering) {

        String jsonInString = gson.toJson(catering);
        System.out.println(jsonInString);
        try {
            writer.write(jsonInString);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(int i=0;i<catering.size();i++){
            //System.out.println(catering.get(i).getClass());
            //System.out.println("FilePrint: "+catering.get(i));
        }
    }
    @Override
    public void show(PublicСatering catering) {
        System.out.println("FilePrint: "+catering);
    }
}