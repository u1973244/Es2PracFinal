import java.util.ArrayList;
import java.util.List;

public class Cursa {
    private int _id;
    private int _maxParticipants;
    private int _duradaVoltes;
    private boolean _comencada;
    private boolean _acabada;
    private TipusTerreny _terreny;

    private List<VehicleEnCursa> vehiclesParticipants;
    private Personatges personatgesDisponibles;


    //constructor amb parametres
    public Cursa(int durada, int maxParticipants){
        this._id=0;
        this._maxParticipants=maxParticipants;
        this._duradaVoltes=durada;
        this._comencada=false;
        this._acabada=false;
        this.personatgesDisponibles=new Personatges("DadesPersonatge");
    }


    //omplir
    public VehicleEnCursa apuntarse(Jugador j, TipusVehicle vehicle, Personatge personatge){
        VehicleEnCursa v =new VehicleEnCursa(j,vehicle,personatge,this);
        vehiclesParticipants.add(v);
        return v;
    }

    public int id(){
        return this._id;
    }

    public void mostraParticipants(){
        for(VehicleEnCursa v: vehiclesParticipants){
            v.mostraParticipant();
        }
    }

    public VehicleEnCursa obtenirVehicle(String nomVehicle){

    }
}