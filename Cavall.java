import java.util.Set;

class Cavall extends TipusVehicle{
    
    public Cavall(int id, String nom, double vMax, double adherencia, Set<TipusTerreny> tipus_terrenys){
        super(id, nom, vMax, adherencia);
        this._resistenciaAlXoc=0.8;
        this._factorVehicleAdaptacio=0.6;
        inicialitzarAdaptacions(tipus_terrenys);
    }

    @Override
    public double accelerar(Vector2 pos, Vector2 vel,double accel, TipusTerreny t){

    }

    @Override
    public double frenar(Vector2 pos, Vector2 vel,double accel, TipusTerreny t){ // Cavall no pot frenar, només pot deixar d'accelerar i que el freni el terra si és que ho fa
        AdaptacioTerreny adaptacio=_adaptacions.get(t);
        accel=adaptacio.adapta(accel);
        double velMagnitud=adaptacio.adapta(vel.magnitude());
        vel.normalize();
        vel.scale(velMagnitud);
        pos.add(vel);
        if(vel.magnitude()<0.01) vel.set(0, 0.1); // perque mai sigui 0 que sino dona problemes per com esta fet 
        return accel;
    }

}
