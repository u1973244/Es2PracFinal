import java.util.Set;

class Cavall extends TipusVehicle{
    
    public double umbralVelocitat=7;

    public Cavall(int id, String nom, double vMax, double adherencia, Set<TipusTerreny> tipus_terrenys, double accel){
        super(id, nom, vMax, adherencia, accel);
        this._resistenciaAlXoc=0.8;
        this._factorVehicleAdaptacio=0.6;
        inicialitzarAdaptacions(tipus_terrenys);
    }

    @Override
    public double accelerar(Vector2 pos, double vel, Vector2 dir, TipusTerreny t, boolean endavant){
        System.out.println("Accelero com un cavall a sobre de " + t.tipus() + "\n");
        AdaptacioTerreny adaptacio=_adaptacions.get(t);
        double accelAdaptada=adaptacio.adapta(this._accel);
        if(endavant) vel+=accelAdaptada;
        else vel-=accelAdaptada;
        if (vel>umbralVelocitat) { // comportament especial de Cavall, si supera l'umbral, la velocitat es posa al maxim
            vel=_vMax;
        }
        else if(vel<-umbralVelocitat){
            vel=-_vMax;
        }
        pos.add(new Vector2(dir.x()*vel, dir.y()*vel));
        return vel;
    }

    @Override
    public double frenar(Vector2 pos, double vel, Vector2 dir, TipusTerreny t){ // Cavall no pot frenar el frena el terra
        System.out.println("Freno com un cavall a sobre de " + t.tipus() + "\n");
        AdaptacioTerreny adaptacio=_adaptacions.get(t);
        vel=adaptacio.adapta(vel);
        pos.add(new Vector2(dir.x()*vel, dir.y()*vel));
        return vel;
    }

}
