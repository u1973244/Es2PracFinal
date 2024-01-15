class Cavall extends TipusVehicle{
    
    Cavall(int id, String nom, double vMax, double adherencia, double resistenciaAlXoc){
        super(id, nom, vMax, adherencia);
        _resistenciaAlXoc = 0.8;
    }

    void accelerar(double pos, double vel){
        vel += 1; //1 cavall --> accelera normal
        if (vel > _vMax) vel=_vMax;
        pos += vel;
    }

    void frenar(double pos, double vel){
        vel -= 1; //poc pes --> frena ràpid
        if (vel <= 0) vel=0;
        pos -= vel;
    }

}
