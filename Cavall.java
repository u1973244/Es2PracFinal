class Cavall extends TipusVehicle{
    
    Cavall(int id, String nom, double vMax, double adherencia, double resistenciaAlXoc){
        super(int id, String nom, double vMax, double adherencia, double resistenciaAlXoc);
    }

    void accelerar(Vector2 pos, int vel, int acc){
        vel.add(acc);
        pos.add(vel);
    }

    void frenar(Vector2 pos, int vel, int acc){
        vel.add(acc);
        pos.add(vel);
    }

}
