import java.util.ArrayList;

public class Vehicles {
    private ArrayList<TipusVehicle> _vehicles = new ArrayList<>();

    public Vehicles(ArrayList<TipusVehicle> vehicles){
        _vehicles=vehicles;
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
                trobat = true;
            }
        }
        return v;
    }

    public void mostrar(){
        for(TipusVehicle vehicle : this._vehicles){
            System.out.println("    -" + vehicle.nomVehicle());
        }
    }
}
