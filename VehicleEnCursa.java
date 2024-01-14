public class VehicleEnCursa {
    private int _Id;
    private Posicio _pos; //primer valor de 0 a 99 per pos , segon valor de 0 a 359 per rotacio
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
        this._Posicio=c.PosInicial;
        this._vel = 0;
        this._acceleracio = 0;
        this._voltes = 0;
        this._pos = Posicio(0,0);
        this._temps = 0;
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

    public void avança(){ //
        _tipusVehicle.accelerar(_pos[0],_vel,_acceleracio);
    }

    public void recula(){ //frenar pot 
        _tipusVehicle.frenar(_pos[0],_vel,_acceleracio);
    }

    public void gira(double valor){
        _pos.ModificarRotacio(valor);
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

    public String nomTipusVehicle(){
        return _tipusVehicle.nomVehicle();
    }
}
