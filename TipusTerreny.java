public class TipusTerreny {
    private String _tipus;

    public TipusTerreny(String tipus){
        this._tipus=tipus;
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
}
