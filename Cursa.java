import java.util.ArrayList;
import java.util.List;

public class Cursa {
    private int _id;
    private int _maxParticipants;
    private int _duradaVoltes;
    private boolean _comencada;
    private boolean _acabada;
    private TipusTerreny _terreny;
    public double _posInicial;
    public double _posFinal; //per a que vehicle en cursa pugui veure on Inicia i caba volta

    private List<VehicleEnCursa> vehiclesParticipants;
    private Terrenys terrenys;
    private Personatges personatgesDisponibles;


    //constructor amb parametres
    public Cursa(int durada, int maxParticipants, Terrenys terrenys){
        this._id=0;
        this._maxParticipants=maxParticipants;
        this._duradaVoltes=durada;
        this._comencada=false;
        this._acabada=false;
        this._posInicial=0;
        this._posFinal = 100;
        this.personatgesDisponibles=new Personatges("DadesPersonatge");
        this.terrenys=terrenys;
    }


    //omplir
    public VehicleEnCursa apuntarse(Jugador j, TipusVehicle vehicle, Personatge personatge){
        VehicleEnCursa v =new VehicleEnCursa(j,vehicle,personatge,this,freeId());
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
    public void mostraVehicles(){
        for(VehicleEnCursa v: vehiclesParticipants){
            v.nomTipusVehicle();
        }
    }

    public VehicleEnCursa findVehicle(int idVehicle){
        boolean trobat = false;
        int i = 0;
        for(VehicleEnCursa v : vehiclesParticipants){
            if(v.getId()==idVehicle){
                trobat = true;
                return v;
            }
        }
        return null;
    }


    private int freeId(){
        int max=0;
        for(VehicleEnCursa v : vehiclesParticipants){
            max=Math.max(max,v.getId());
        }
        return max;
    }
}