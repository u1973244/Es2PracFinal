class Quadriga extends TipusVehicle{
    
    Quadriga(int id, String nom, double vMax, double adherencia, double resistenciaAlXoc){
        super(id, nom, vMax, adherencia, resistenciaAlXoc);
    }

    void accelerar(double pos, double vel){
        vel += 1.2; //4 cavalls --> accelera més ràpid
        if (vel > _vMax) vel=_vMax;
        pos += vel;
    }

    void frenar(double pos, double vel){
        vel -= 0.8; //molt més pesat frenara menys 
        if (vel <= 0) vel=0;
        pos -= vel;
    }

}
