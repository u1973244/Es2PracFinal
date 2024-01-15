public class VehicleEnCursa {
    private int _id;
    private Posicio _pos; //primer valor de 0 a 99 per pos , segon valor de 0 a 359 per rotacio
    private double _vel;
    private int _acceleracio; //sapiguer si frena o accelera
    private int _voltes;
    private double _temps;
    private PerfilConduccio _perfil;
    private Personatge _personatge;
    private TipusVehicle _tipusVehicle;
    private Cursa _cursa;
    private Jugador _jugador;


    public VehicleEnCursa(Jugador j,TipusVehicle tipus, Personatge p,Cursa c, int id){
        this._id = id;
        this._jugador=j;
        this._tipusVehicle=tipus;
        this._personatge=p;
        this._cursa=c;
        this._pos=new Posicio(0,c._posFinal,c._posInicial);
        this._vel = 0;
        this._acceleracio = 0;
        this._voltes = 0;
        this._temps = 0;
    }

    public int getId(){
        return _id;
    }

    public Posicio getPos(){
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
        _acceleracio = 1;
        double nou = _pos.getPunt();
        _tipusVehicle.accelerar(nou, _vel); 
        if(_pos.ModificarPunt(nou))_voltes+=1;
    }

    public void recula(){ //frenar
        _acceleracio = -1;
        double avenç= _pos.getPunt();
        _tipusVehicle.frenar(avenç, _vel); 
        _pos.ModificarPunt(avenç);
    }

    public void manteVelocitat(){
        _acceleracio = 0;
    }

    public void gira(double valor){
        if (valor>0) _pos.ModificarRotacio(45);
        else if (valor < 0) _pos.ModificarRotacio(-45);
        else _pos.ModificarRotacio(0);
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

    public void mostrarMoviment(){
        String mov;
        if (_acceleracio==1){
            mov = "accelera fins assolir una velocitat de "+_vel+ " km/h";
        }
        else if(_acceleracio==-1){
            mov = "frena fins assolir una velocitat de "+_vel+ " km/h";
        }
        else{
            mov = "mante una velocitat de "+_vel+ " km/h";
        }
        System.out.print("Vehicle es mou direccio ");
        int rot  = _pos.getRotacio();
        if (rot <= -135 || rot >= 135 ) System.out.print("S");
        else if (rot >= -45 && rot <= 45) System.out.print("N");
        if (rot <= -45 && rot >= -135) System.out.print("O");
        else if (rot >= 45 && rot <= 135) System.out.print("E");
        System.out.print(" i "+mov+"\n");
        System.out.print("Punt actual del vehicle: "+_pos.getPunt()+"\n");
        System.out.print("Falten "+_pos.getRestant()+" km per arribar a la meta");
        
    }
}

