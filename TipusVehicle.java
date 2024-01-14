abstract class TipusVehicle {
    protected String _id;
    protected String _nom;
    protected double _vMax;
    protected double _adherencia;
    protected double _resistenciaAlXoc;

    abstract void accelerar(int pos, double vel, double acc);
    abstract void frenar(int pos, double vel, double acc);

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
