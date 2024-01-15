import java.util.Set;

class Cavall extends TipusVehicle{
    
    public Cavall(int id, String nom, double vMax, double adherencia, Set<TipusTerreny> tipus_terrenys){
        super(id, nom, vMax, adherencia);
        this._resistenciaAlXoc=0.8;
        this._factorVehicleAdaptacio=0.6;
        inicialitzarAdaptacions(tipus_terrenys);
    }

    @Override
    public void accelerar(double pos, double vel){
        vel += 1; //1 cavall --> accelera normal
        if (vel > _vMax) vel=_vMax;
        pos += vel;
    }

    @Override
    public void frenar(double pos, double vel){
        vel -= 1; //poc pes --> frena ràpid
        if (vel <= 0) vel=0;
        pos -= vel;
    }

}
