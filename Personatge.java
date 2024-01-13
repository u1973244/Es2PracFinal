public class Personatge {
    
    private boolean _escollit;

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
