import java.util.Set;

class Quadriga extends TipusVehicle{
    
    public Quadriga(int id, String nom, double vMax, double adherencia,Set<TipusTerreny> tipus_terrenys){
        super(id, nom, vMax, adherencia);
        this._resistenciaAlXoc=1.2;
        this._factorVehicleAdaptacio=1.0;
        inicialitzarAdaptacions(tipus_terrenys);
    }

    @Override
    public double accelerar(Vector2 pos, double vel, Vector2 dir, TipusTerreny t, boolean endavant){
        System.out.println("Accelero com una Biga a sobre de " + t.tipus() + "\n");
        AdaptacioTerreny adaptacio=_adaptacions.get(t);
        double accelAdaptada=adaptacio.adapta(this._accel);
        if(endavant) vel+=accelAdaptada;
        else vel-=accelAdaptada;
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
