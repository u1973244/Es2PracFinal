abstract class TipusVehicle {
    String _id;
    String _nom;
    double _vMax;
    double _adherencia;
    double _resistenciaAlXoc;

    abstract void accelerar(Vector2 pos, Vector2 vel, Vector2 acc);
    abstract void frenar(Vector2 pos, Vector2 vel, Vector2 acc);

}
