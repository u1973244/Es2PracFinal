import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class Vehicles {
    private ArrayList<TipusVehicle> _vehicles = new ArrayList<>();

    public Vehicles(String document, Set<TipusTerreny> tipus_terrenys){

        try (BufferedReader lector = new BufferedReader(new FileReader(document))) {
            String linia;

            while ((linia = lector.readLine()) != null) {
                String[] parts = linia.split(",");

                if(parts[0].trim()=="biga"){
                    this._vehicles.add(new Biga(Integer.parseInt(parts[1].trim()),parts[2].trim(),Double.parseDouble(parts[3].trim()),Double.parseDouble(parts[4].trim()),tipus_terrenys,Double.parseDouble(parts[5].trim())));
                }
                else if(parts[0].trim()=="quadriga"){
                    this._vehicles.add(new Quadriga(Integer.parseInt(parts[1].trim()),parts[2].trim(),Double.parseDouble(parts[3].trim()),Double.parseDouble(parts[4].trim()),tipus_terrenys,Double.parseDouble(parts[5].trim())));
                }
                else{
                    this._vehicles.add(new Cavall(Integer.parseInt(parts[1].trim()),parts[2].trim(),Double.parseDouble(parts[3].trim()),Double.parseDouble(parts[4].trim()),tipus_terrenys,Double.parseDouble(parts[5].trim())));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TipusVehicle get(int i){
        return _vehicles.get(i);
    }

    //retorna vehicle de nomVehicle o null si no trobat
    public TipusVehicle find(String nomVehicle){
        for(TipusVehicle v : this._vehicles){
            if(v.nomVehicle().equalsIgnoreCase(nomVehicle)){
                return v;
            }
        }
        return null;
    }

    public void mostrar(){
        for(TipusVehicle vehicle : this._vehicles){
            System.out.println("    -" + vehicle.nomVehicle());
        }
    }
}
