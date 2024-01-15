class Biga extends TipusVehicle{
    
    Biga(int id, String nom, double vMax, double adherencia, double resistenciaAlXoc){
        super(id, nom, vMax, adherencia, resistenciaAlXoc);
    }

    void accelerar(double pos, double vel){
        vel += 1.1;
        if (vel > _vMax) vel=_vMax;
        pos += vel;
    }
    void frenar(double pos, double vel){
        vel -= 0.9;
        if (vel <= 0) vel=0;
        pos -= vel;
    }
}
