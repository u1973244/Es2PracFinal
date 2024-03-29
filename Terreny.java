public class Terreny {
    private TipusTerreny _tipus;
    private double _pos;
    private int _mida;

    public Terreny(TipusTerreny tipus, double pos){
        this._tipus=tipus;
        this._pos=pos;
        this._mida=10; // suposem que tots tenen la mateixa mida
    }

    public boolean contains(double pos){
        if(pos<this._pos+this._mida/2 && pos>this._pos-this._mida/2) return true;
        else return false;
    }

    public TipusTerreny tipus(){
        return this._tipus;
    }
}
