import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Terrenys {
    private ArrayList<TipusTerreny> _terrenys = new ArrayList<>();

    public Terrenys(String document){

        try (BufferedReader lector = new BufferedReader(new FileReader(document))) {
            String linia;

            while ((linia = lector.readLine()) != null) {
                String[] parts = linia.split(",");
 
                this._terrenys.add(new TipusTerreny(parts[0].trim(),Integer.parseInt(parts[1].trim())));
              
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
