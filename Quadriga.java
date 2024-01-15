import java.util.Set;

class Quadriga extends TipusVehicle{
    
    public Quadriga(int id, String nom, double vMax, double adherencia,Set<TipusTerreny> tipus_terrenys){
        super(id, nom, vMax, adherencia);
        this._resistenciaAlXoc=1.2;
        this._factorVehicleAdaptacio=1.0;
        inicialitzarAdaptacions(tipus_terrenys);
    }

    @Override
    public double accelerar(Vector2 pos, Vector2 vel,double accel, TipusTerreny t){
        System.out.println("Accelero com una Quadriga\n");
        AdaptacioTerreny adaptacio=_adaptacions.get(t);
        double accelAdaptada=adaptacio.adapta(accel);
        double novaVelocitat=vel.magnitude()+accelAdaptada;
        vel.normalize();
        vel.scale(novaVelocitat);
        if (vel.magnitude()>this._vMax) {
            vel.normalize();
            vel.scale(_vMax);
        }
        pos.add(vel);
        if(vel.magnitude()<0.01) vel.set(0, 0.1); // perque mai sigui 0 que sino dona problemes per com esta fet 
        if(accel>0) return Math.min(this._accelMax, accel);
        else return Math.max(-this._accelMax, accel);
    }

    @Override
    public double frenar(Vector2 pos, Vector2 vel,double accel, TipusTerreny t){
        System.out.println("Freno com una Quadriga\n");
        double frenada=0.9;
        AdaptacioTerreny adaptacio=_adaptacions.get(t);
        double frenadaAdaptada=frenada-adaptacio.adapta(frenada);
        vel.scale(frenadaAdaptada);
        pos.add(vel);
        if(vel.magnitude()<0.01) vel.set(0, 0.1); // perque mai sigui 0 que sino dona problemes per com esta fet 
        return accel*frenadaAdaptada;
    }
}
