abstract class TipusVehicle {
    protected int _id;
    protected String _nom;
    protected double _vMax;
    protected double _adherencia;
    protected double _resistenciaAlXoc;

    abstract double accelerar(double pos, double vel, double acc);
    abstract double frenar(double pos, double vel, double acc);

    public String nomVehicle(){
        return this._nom;
    }

    public TipusVehicle(int id, String nom, double vMax, double adherencia, double resistenciaAlXoc){
        this._id = id;
        this._nom = nom;
        this._vMax = vMax;
        this._adherencia = adherencia;
        this._resistenciaAlXoc = resistenciaAlXoc;
    }
}
