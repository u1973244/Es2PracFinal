public class TipusTerreny {
    private String _tipus;
    private double _roughness;

    public TipusTerreny(String tipus, double roughness){
        this._tipus=tipus;
        this._roughness=roughness;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TipusTerreny other = (TipusTerreny) obj;
        return this._tipus.equals(other._tipus);
    }

    @Override
    public int hashCode() {
        return this._tipus.hashCode();
    }

    public double roughness(){
        return this.roughness();
    }
}
