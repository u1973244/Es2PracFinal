abstract class TipusVehicle {
    protected String _id;
    protected String _nom;
    protected double _vMax;
    protected double _adherencia;
    protected double _resistenciaAlXoc;

    abstract void accelerar(Vector2 pos, Vector2 vel, Vector2 acc);
    abstract void frenar(Vector2 pos, Vector2 vel, Vector2 acc);

    public String nomVehicle(){
        return this._nom;
    }

    public TipusVehicle(String id, String nom, double vMax, double adherencia, double resistenciaAlXoc){
        this._id = id;
        this._nom = nom;
        this._vMax = vMax;
        this._adherencia = adherencia;
        this._resistenciaAlXoc = resistenciaAlXoc;
    }
}
