import java.util.Set;

class Biga extends TipusVehicle{

    public Biga(int id, String nom, double vMax, double adherencia, Set<TipusTerreny> tipus_terrenys){
        super(id, nom, vMax, adherencia);
        this._resistenciaAlXoc=1.1;
        this._factorVehicleAdaptacio=0.8;
        inicialitzarAdaptacions(tipus_terrenys);
    }

    @Override
    public void accelerar(double pos, double vel){
        vel += 1.1; //mutiplicar per parametre terreny de 1 a 0.5?
        if (vel > _vMax) vel=_vMax;
        pos += vel;
    }

    @Override
    public void frenar(double pos, double vel){
        vel -= 0.9;
        if (vel <= 0) vel=0;
        pos -= vel;
    }
}
