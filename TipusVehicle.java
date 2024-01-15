abstract class TipusVehicle {
    protected int _id;
    protected String _nom;
    protected double _vMax;
    protected double _adherencia;
    protected double _resistenciaAlXoc;

    abstract void accelerar(double pos, double vel);
    abstract void frenar(double pos, double vel);

    public String nomVehicle(){
        return this._nom;
    }

    public TipusVehicle(int id, String nom, double vMax, double adherencia, double resistenciaAlXoc){
        this._id = id;
        this._nom = nom;
        this._vMax = vMax;
        this._adherencia = adherencia;
        this._resistenciaAlXoc=resistenciaAlXoc;
    }
}
