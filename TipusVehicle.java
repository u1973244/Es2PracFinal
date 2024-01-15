import java.util.Map;
import java.util.Set;
import java.util.HashMap;

abstract class TipusVehicle {
    protected int _id;
    protected String _nom;
    protected double _vMax;
    protected double _adherencia;
    protected double _resistenciaAlXoc;
    protected double _factorVehicleAdaptacio;
    protected Map<TipusTerreny,AdaptacioTerreny> _adaptacions= new HashMap<TipusTerreny,AdaptacioTerreny>();

    public abstract void accelerar(double pos, double vel);
    public abstract void frenar(double pos, double vel);

    public String nomVehicle(){
        return this._nom;
    }

    public TipusVehicle(int id, String nom, double vMax, double adherencia){
        this._id = id;
        this._nom = nom;
        this._vMax = vMax;
        this._adherencia = adherencia;
    }

    protected void inicialitzarAdaptacions(Set<TipusTerreny> tipus_terrenys){
        for (TipusTerreny tipus : tipus_terrenys){
            _adaptacions.put(tipus,new AdaptacioTerreny(this._factorVehicleAdaptacio*tipus.roughness()));
        }
    }
}
