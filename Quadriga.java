class Quadriga extends TipusVehicle{
    
    Quadriga(int id, String nom, double vMax, double adherencia, double resistenciaAlXoc){
        super(id, nom, vMax, adherencia, resistenciaAlXoc);
    }

    void accelerar(double pos, double vel, double acc){
        vel = acc;
        pos += vel;
    }

    void frenar(double pos, double vel, double acc){
        vel = acc;
        pos += vel;
    }

}
