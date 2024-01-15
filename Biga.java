import java.util.Set;

class Biga extends TipusVehicle{

    private double umbralVelocitat=8;

    public Biga(int id, String nom, double vMax, double adherencia, Set<TipusTerreny> tipus_terrenys){
        super(id, nom, vMax, adherencia);
        this._resistenciaAlXoc=1.1;
        this._factorVehicleAdaptacio=0.8;
        inicialitzarAdaptacions(tipus_terrenys);
    }

    @Override
    public double accelerar(Vector2 pos, double vel, Vector2 dir, TipusTerreny t, boolean endavant){
        System.out.println("Accelero com una Biga a sobre de " + t.tipus() + "\n");
        AdaptacioTerreny adaptacio=_adaptacions.get(t);
        double accelAdaptada=adaptacio.adapta(this._accel);
        if(endavant) vel+=accelAdaptada;
        else vel-=accelAdaptada;
        if (vel>umbralVelocitat) { // comportament especial de Biga, si supera l'umbral, la velocitat es disminueix un 50%
            vel=vel*0.5;
        }
        pos.add(new Vector2(dir.x()*vel, dir.y()*vel));
        return vel;
    }

    @Override
    public double frenar(Vector2 pos, double vel, Vector2 dir, TipusTerreny t){
        System.out.println("Freno com una Biga a sobre de " + t.tipus() + "\n");
        double frenada=0.9;
        AdaptacioTerreny adaptacio=_adaptacions.get(t);
        double frenadaAdaptada=frenada-adaptacio.adapta(frenada);
        vel=vel*frenadaAdaptada;
        pos.add(new Vector2(dir.x()*vel, dir.y()*vel));
        return vel;
    }
}
