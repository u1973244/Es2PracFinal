public class VehicleEnCursa {
    private int _id;
    private Vector2 _dir;
    private int _voltes;
    private double _temps;
    private PerfilConduccio _perfil;
    private Personatge _personatge;
    private TipusVehicle _tipusVehicle;
    private Cursa _cursa;
    private Jugador _jugador;

    private Vector2 _posicio;
    private double _velocitat;

    public VehicleEnCursa(Jugador j,TipusVehicle tipus, Personatge p,Cursa c, int id){
        this._id = id;
        this._jugador=j;
        this._tipusVehicle=tipus;
        this._personatge=p;
        this._cursa=c;
        this._voltes = 0;
        this._temps = 0;

        this._posicio=c.posInicial(_id); //La cursa només importa el progrés a l'eix y, per tant es posen al mateix y de sortida i a un pos x diferent segons l'id
        this._velocitat=0;
        this._dir=new Vector2(0,1);
    }

    public int getId(){
        return _id;
    }

    
    public Vector2 pos(){
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

    public void avança(){ 
        TipusTerreny t=_cursa.tipusTerrenyA(_posicio.y());
        this._velocitat=this._tipusVehicle.accelerar(this._posicio,this._velocitat,this._dir,t,true);
        this.comprovaVoltaNova();
    }

    public void recula(){
        TipusTerreny t=_cursa.tipusTerrenyA(_posicio.y());
        this._velocitat=this._tipusVehicle.accelerar(this._posicio,this._velocitat,this._dir,t,false);
        this.comprovaVoltaNova();
        this.comprovarLimits();
    }

    public void atura(){
        TipusTerreny t=_cursa.tipusTerrenyA(_posicio.y());
        this._velocitat=this._tipusVehicle.frenar(this._posicio,this._velocitat,this._dir,t);
        this.comprovaVoltaNova();
        this.comprovarLimits();
    }


    public void gira(double valor){
        this._dir.rotate(valor);
        TipusTerreny t=_cursa.tipusTerrenyA(_posicio.y());
        this._velocitat=this._tipusVehicle.accelerar(this._posicio,this._velocitat,this._dir,t,true);
        this.comprovaVoltaNova();
        this.comprovarLimits();
    }

    public int voltes(){
        return _voltes;
    }

    public double temps(){
        return _temps;
    }


    public void mostraParticipant(){
        System.out.println(_jugador.nomJugador() + ": " + _personatge.nomPersonatge() + " [" + _tipusVehicle.nomVehicle() + "]");
    }

    public String nomTipusVehicle(){
        return _tipusVehicle.nomVehicle();
    }


    public void mostrarMoviment(){
        System.out.println("Vehicle de " + this._jugador.nomJugador() + " es troba a la posicio ["+ Math.round(this._posicio.x() * Math.pow(10,2))/Math.pow(10,2) + "," + Math.round(this._posicio.y() * Math.pow(10,2))/Math.pow(10,2) +"] km i es mou amb una velocitat de " + Math.round(this._velocitat * Math.pow(10,2))/Math.pow(10,2) + "km/h en direccio (" + Math.round(this._dir.x() * Math.pow(10,2))/Math.pow(10,2) +"," + Math.round(this._dir.y() * Math.pow(10,2))/Math.pow(10,2) +")");
        System.out.println("Ha completat "+ this._voltes +" voltes al circuit");
    }

    private void comprovaVoltaNova(){
        if(this._posicio.y()>this._cursa.posFinalVolta()){
            this._voltes++;
            this._posicio=new Vector2(this._posicio.x(),this._cursa.posInicial(this._id).y()+(this._posicio.y()-this._cursa.posFinalVolta()));
        }
    }

    private void comprovarLimits(){
        if(this._posicio.x()>this._cursa.maxX()) this._posicio.set(this._cursa.maxX(), this._posicio.y());
        if(this._posicio.x()<this._cursa.minX()) this._posicio.set(this._cursa.minX(), this._posicio.y());
    }

    public String nomConductor(){
        return this._jugador.nomJugador();
    }
}

