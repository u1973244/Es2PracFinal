class Cavall extends TipusVehicle{
    
    Cavall(int id, String nom, double vMax, double adherencia, double resistenciaAlXoc){
        super(id, nom, vMax, adherencia, resistenciaAlXoc);
    }

    void accelerar(double pos, double vel, double acc){
        vel = acc;
        if (vel > vMax) vel=vMax;
        else if (vel < -vMax) vel=-vMax;
        pos += vel;
    }

    void frenar(double pos, double vel, double acc){
        vel = acc;
         if (vel > vMax) vel=vMax;
        pos -= vel;
    }

}
