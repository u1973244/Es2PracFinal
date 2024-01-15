import java.util.Set;

class Quadriga extends TipusVehicle{
    
    public Quadriga(int id, String nom, double vMax, double adherencia,Set<TipusTerreny> tipus_terrenys){
        super(id, nom, vMax, adherencia);
        this._resistenciaAlXoc=1.2;
        this._factorVehicleAdaptacio=1.0;
        inicialitzarAdaptacions(tipus_terrenys);
    }

    @Override
    public void accelerar(double pos, double vel){
        vel += 1.2; //4 cavalls --> accelera més ràpid
        if (vel > _vMax) vel=_vMax;
        pos += vel;
    }

    @Override
    public void frenar(double pos, double vel){
        vel -= 0.8; //molt més pesat frenara menys 
        if (vel <= 0) vel=0;
        pos -= vel;
    }
}
