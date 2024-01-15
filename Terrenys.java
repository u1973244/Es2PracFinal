import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Terrenys {
    private TipusTerreny _defaultTipus=new TipusTerreny("default",1);
    private ArrayList<Terreny> _terrenys = new ArrayList<Terreny>();
    private Set<TipusTerreny> _tipusTerrenys = new HashSet<>();

    public Terrenys(String document){

        try (BufferedReader lector = new BufferedReader(new FileReader(document))) {
            String linia;
            TipusTerreny tipus=null;
            while ((linia = lector.readLine()) != null) {
                if(linia.contains(":")){
                    String[] parts = linia.split(":");
                    tipus=new TipusTerreny(parts[0].trim(),Double.parseDouble(parts[1].trim()));
                    _tipusTerrenys.add(tipus);
                }
                else{
                    this._terrenys.add(new Terreny(tipus,Double.parseDouble(linia.trim())));
                }
              
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        _tipusTerrenys.add(this._defaultTipus);
    }

    public Set<TipusTerreny> tipus(){
        return _tipusTerrenys;
    }

    public TipusTerreny TipusA(double posY){
        for(Terreny t: _terrenys){
            if (t.contains(posY)) return t.tipus();
        }
        return _defaultTipus;
    }
}
