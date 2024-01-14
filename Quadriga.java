class Quadriga extends TipusVehicle{
    
    Quadriga(int id, String nom, double vMax, double adherencia, double resistenciaAlXoc){
        super(int id, String nom, double vMax, double adherencia, double resistenciaAlXoc);
    }

    void accelerar(double pos, double vel, double acc){
        vel.add(acc);
        pos.add(vel);
    }

    void frenar(double pos, double vel, double acc){
        vel.add(acc);
        pos.add(vel);
    }

}
