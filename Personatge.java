public class Personatge {
    private TipusPersonatge _tipus;
    private boolean _escollit;

    public Personatge(TipusPersonatge tipus){
        this._tipus=tipus;
        this._escollit = false;
    }

    public String nomPersonatge(){
        return _tipus.nom();
    }

    public boolean elegible(){
        return !_escollit;
    }
    public void escollir(){
        _escollit = true;
    }
    public void desbloquejar(){
        _escollit = false;
    }

}
