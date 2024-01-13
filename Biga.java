class Biga extends TipusVehicle{
    

    void accelerar(Vector2 pos, Vector2 vel, Vector2 acc){
       vel.add(acc);
       pos.add(vel);
    }
    void frenar(Vector2 pos, Vector2 vel, Vector2 acc){
        vel.add(acc);
        pos.add(vel);
    }

}
