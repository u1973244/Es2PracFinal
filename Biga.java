class Biga extends TipusVehicle{
    
    Biga(int id, String nom, double vMax, double adherencia, double resistenciaAlXoc){
        super(int id, String nom, double vMax, double adherencia, double resistenciaAlXoc);
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
