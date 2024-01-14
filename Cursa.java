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


    //constructor amb parametres
    public Cursa(TipusTerreny terreny, int durada, int maxParticipants, int id){
        this._id=id;
        this._maxParticipants=maxParticipants;
        this._duradaVoltes=durada;
        this._comencada=false;
        this._acabada=false;
        this._terreny=terreny;
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
}