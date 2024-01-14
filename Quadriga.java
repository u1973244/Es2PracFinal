class Quadriga extends TipusVehicle{
    
    Quadriga(String id, String nom, double vMax, double adherencia, double resistenciaAlXoc){
        super(String id, String nom, double vMax, double adherencia, double resistenciaAlXoc);
    }

    void accelerar(Vector2 pos, Vector2 vel, Vector2 acc){
        vel.add(acc);
        pos.add(vel);
    }

    void frenar(Vector2 pos, Vector2 vel, Vector2 acc){
        vel.add(acc);
        pos.add(vel);
    }

}
