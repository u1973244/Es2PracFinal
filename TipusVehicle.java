import java.util.Map;
import java.util.Set;
import java.util.HashMap;

abstract class TipusVehicle {
    protected int _id;
    protected String _nom;
    protected double _vMax;
    protected double _accel=7;
    protected double _accelMax;
    protected double _adherencia;
    protected double _resistenciaAlXoc;
    protected double _factorVehicleAdaptacio;
    protected Map<TipusTerreny,AdaptacioTerreny> _adaptacions= new HashMap<TipusTerreny,AdaptacioTerreny>();

    public abstract double accelerar(Vector2 pos, double vel, Vector2 dir, TipusTerreny t, boolean endavant);
    public abstract double frenar(Vector2 pos, double vel,Vector2 dir, TipusTerreny t);

    public String nomVehicle(){
        return this._nom;
    }

    public TipusVehicle(int id, String nom, double vMax, double adherencia){
        this._id = id;
        this._nom = nom;
        this._vMax = vMax;
        this._adherencia = adherencia;
        this._accelMax=6;
    }

    protected void inicialitzarAdaptacions(Set<TipusTerreny> tipus_terrenys){
        for (TipusTerreny tipus : tipus_terrenys){
            _adaptacions.put(tipus,new AdaptacioTerreny(this._factorVehicleAdaptacio*tipus.roughness()));
        }
    }
}
