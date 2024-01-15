import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Personatges {
    private ArrayList<Personatge> _personatges = new ArrayList<>();

    public Personatges(String document){

        try (BufferedReader lector = new BufferedReader(new FileReader(document))) {
            String linia;

            while ((linia = lector.readLine()) != null) {
                String[] parts = linia.split(",");
 
                TipusPersonatge tipus = new TipusPersonatge(parts[0].trim());
                this._personatges.add(new Personatge(tipus));
              
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Personatge> disponibles(){
        ArrayList<Personatge> res=new ArrayList<Personatge>();
        for(Personatge p: this._personatges){
            if(p.elegible()) res.add(p);
        }
        return res;
    }
}