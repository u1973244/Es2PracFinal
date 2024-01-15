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
    private Terrenys terrenys;
    private Personatges _personatges;


    //constructor amb parametres
    public Cursa(int durada, int maxParticipants, Terrenys terrenys){
        this._id=0;
        this._maxParticipants=maxParticipants;
        this._duradaVoltes=durada;
        this._comencada=false;
        this._acabada=false;
        this._personatges=new Personatges("DadesPersonatge");
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
        for(VehicleEnCursa v : vehiclesParticipants){
            if(v.getId()==idVehicle){
                return v;
            }
        }
        return null;
    }


    public ArrayList<Personatge> personatgesDisponibles(){
        return this._personatges.disponibles();
    }
    public Vector2 posInicial(int id){
        return new Vector2(id,0);
    }


    private int freeId(){
        int max=0;
        for(VehicleEnCursa v : vehiclesParticipants){
            max=Math.max(max,v.getId());
        }
        return max;
    }
}