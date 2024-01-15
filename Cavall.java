import java.util.Set;

class Cavall extends TipusVehicle{
    
    public double umbralVelocitat=7;

    public Cavall(int id, String nom, double vMax, double adherencia, Set<TipusTerreny> tipus_terrenys){
        super(id, nom, vMax, adherencia);
        this._resistenciaAlXoc=0.8;
        this._factorVehicleAdaptacio=0.6;
        inicialitzarAdaptacions(tipus_terrenys);
    }

    @Override
    public void accelerar(Vector2 pos, Vector2 vel,double accel, TipusTerreny t){
        System.out.println("Accelero com un cavall a sobre de " + t.tipus() + "\n");
        AdaptacioTerreny adaptacio=_adaptacions.get(t);
        double accelAdaptada=adaptacio.adapta(accel);
        double novaVelocitat=vel.magnitude()+accelAdaptada;
        vel.normalize();
        vel.scale(novaVelocitat);
        if (vel.magnitude()>umbralVelocitat) { // comportament especial de Cavall, si supera l'umbral, la velocitat es posa al maxim
            vel.normalize();
            vel.scale(_vMax);
        }
        pos.add(vel);
    }

    @Override
    public void frenar(Vector2 pos, Vector2 vel,double accel, TipusTerreny t){ // Cavall no pot frenar, només pot deixar d'accelerar i que el freni el terra si és que ho fa
        System.out.println("Freno com un cavall a sobre de " + t.tipus() + "\n");
        AdaptacioTerreny adaptacio=_adaptacions.get(t);
        accel=adaptacio.adapta(accel);
        double velMagnitud=adaptacio.adapta(vel.magnitude());
        vel.normalize();
        vel.scale(velMagnitud);
        pos.add(vel);
    }

}
