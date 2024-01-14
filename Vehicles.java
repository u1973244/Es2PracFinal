import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Vehicles {
    private ArrayList<TipusVehicle> _vehicles = new ArrayList<>();

    public Vehicles(String document){

        try (BufferedReader lector = new BufferedReader(new FileReader(document))) {
            String linia;

            while ((linia = lector.readLine()) != null) {
                String[] parts = linia.split(",");

                if(parts[3].trim()=="biga"){
                    this._vehicles.add(new Biga(Integer.parseInt(parts[2].trim()),parts[1].trim(),Double.parseDouble(parts[2].trim()),Double.parseDouble(parts[2].trim())));
                }
                else if(parts[3].trim()=="quadriga"){
                    this._vehicles.add(new Quadriga(Integer.parseInt(parts[2].trim()),parts[1].trim(),Double.parseDouble(parts[2].trim()),Double.parseDouble(parts[2].trim())));
                }
                else{
                    this._vehicles.add(new Cavall(Integer.parseInt(parts[2].trim()),parts[1].trim(),Double.parseDouble(parts[2].trim()),Double.parseDouble(parts[2].trim())));
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
        boolean trobat = false;
        int i = 0;
        TipusVehicle v=null;
        while(!trobat && i < this._vehicles.size()){
            v = this._vehicles.get(i);
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
