public class VehicleEnCursa {
    private int _id;
    private Posicio _pos; //primer valor de 0 a 99 per pos , segon valor de 0 a 359 per rotacio
    private double _vel;
    private int _acceleracio1; //sapiguer si frena o accelera
    private int _voltes;
    private double _temps;
    private PerfilConduccio _perfil;
    private Personatge _personatge;
    private TipusVehicle _tipusVehicle;
    private Cursa _cursa;
    private Jugador _jugador;

    private Vector2 _posicio;
    private Vector2 _velocitat;
    private Vector2 _acceleracio;

    public VehicleEnCursa(Jugador j,TipusVehicle tipus, Personatge p,Cursa c, int id){
        this._id = id;
        this._jugador=j;
        this._tipusVehicle=tipus;
        this._personatge=p;
        this._cursa=c;
        this._voltes = 0;
        this._temps = 0;

        this._posicio=c.posInicial(_id); //La cursa només importa el progrés a l'eix y, per tant es posen al mateix y de sortida i a un pos x diferent segons l'id
        this._velocitat=new Vector2(0, 0);
        this._acceleracio=new Vector2(0, 0);
    }

    public int getId(){
        return _id;
    }

    public Vector2 getPos(){
        return _posicio;
    }

    public boolean canviarPersonatge(Personatge personatge){
        if(personatge.elegible()){
            _personatge = personatge;
            return true;
        } 
        return false;
    }

    public void canviarPerfil(PerfilConduccio tipus){
        _perfil = tipus;
    }

    public Personatge personatge(){
        return _personatge;
    }

    public void avança(){ //
        _acceleracio1 = 1;
        double nou = _pos.getPunt();
        _tipusVehicle.accelerar(nou, _vel); 
        if(_pos.ModificarPunt(nou))_voltes+=1;
    }

    public void recula(){ //frenar
        _acceleracio1 = -1;
        double avenç= _pos.getPunt();
        _tipusVehicle.frenar(avenç, _vel); 
        _pos.ModificarPunt(avenç);
    }

    public void manteVelocitat(){
        _acceleracio1 = 0;
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

