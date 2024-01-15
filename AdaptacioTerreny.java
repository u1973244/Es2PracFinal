public class AdaptacioTerreny {
    private double _grau;
    
    public AdaptacioTerreny(double grau){
        this._grau=grau;
    }

    public double adapta(double accel){
        return accel*this._grau;
    }
}
