public class VehicleEnCursa {
    private Vector2 _pos; //primer valor de 0 a 99 per pos , segon valor de 0 a 359 per rotacio
    private double _vel;
    private double _acceleracio;
    private int _voltes;
    private double _temps;
    private PerfilConduccio _perfil;
    private Personatge _personatge;
    private TipusVehicle _tipusVehicle;
    private Cursa _cursa;
    private Jugador _jugador;


    public VehicleEnCursa(Jugador j,TipusVehicle tipus, Personatge p,Cursa c){
        this._jugador=j;
        this._tipusVehicle=tipus;
        this._personatge=p;
        this._cursa=c;
    }

    public Vector2 getPos(){
        return _pos;
    }
    public boolean canviarPersonatge(Personatge personatge){
        //s'ha de verificar que ningú estigui fent servir aquell personatge a la cursa, si s'està fent servir, no es canvia i es retorna false, si s'ha pogut canviar es retorna true.
        //_personatge = personatge;
        return true;
    }
    public void canviarPerfil(PerfilConduccio tipus){
        _perfil = tipus;
    }
    public Personatge personatge(){
        return _personatge;
    }

    public void avança(int valor){
        if(valor<0){
            _tipusVehicle.frenar(_pos[0],_vel,_acceleracio);
        }
        else if(valor>0){
            _tipusVehicle.accelerar(_pos[0],_vel,_acceleracio);
        }
    }
    public void recula(){

    }
    public void gira(double valor){
        _pos[1]+=valor;
        if(_pos[1]<0){
            _pos[1]+=360;
        }
        else if(_pos[1]>359){
            _pos[1]-=360;
        }
    }
    
    public int voltes(){
        return _voltes;
    }
    public double temps(){
        return _temps;
    }
    public void actualitza(EventCursa ev){

    }

    public void mostraParticipant(){
        System.out.print(_jugador.nomJugador() + "   " + _personatge.nomPersonatge() + "   " + _tipusVehicle.nomVehicle());
    }
}
