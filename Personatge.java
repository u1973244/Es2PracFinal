public class Personatge {
    
    private String _nom;
    private boolean _escollit;

    public Personatge(String nom){
        this._nom = nom;
        this._escollit = false;
    }

    public boolean elegible(){
        return _escollit;
    }
    public void escollir(){
        _escollit = true;
    }
    public void desbloquejar(){
        _escollit = false;
    }

}
