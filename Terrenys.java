import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Terrenys {
    private ArrayList<Terreny> _terrenys = new ArrayList<Terreny>();
    private Set<TipusTerreny> _tipusTerrenys = new HashSet<>();

    public Terrenys(String document){

        try (BufferedReader lector = new BufferedReader(new FileReader(document))) {
            String linia;

            while ((linia = lector.readLine()) != null) {
                String[] parts = linia.split(",");
                TipusTerreny tipus=new TipusTerreny(parts[0].trim(),Double.parseDouble(parts[1].trim()));
                if(!_tipusTerrenys.contains(tipus)) _tipusTerrenys.add(tipus);

                this._terrenys.add(new Terreny(tipus,Double.parseDouble(parts[2].trim())));
              
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
