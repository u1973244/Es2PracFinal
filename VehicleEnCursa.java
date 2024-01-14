public class VehicleEnCursa {
    private Vector2 _pos;
    private Vector2 _vel;
    private Vector2 _acceleracio;
    private int _voltes;
    private double _temps;
    private PerfilConduccio _perfil;
    private Personatge _personatge;

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
    public void accelera(){

    }
    public void avança(){

    }
    public void recula(){

    }
    public void gira(){

    }
    public int voltes(){
        return _voltes;
    }
    public double temps(){
        return _temps;
    }
    public void actualitza(EventCursa ev){

    }
}
