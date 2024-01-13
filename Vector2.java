public class Vector2 {
    private double x;
    private double y;

    // Constructor
    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Mètode per sumar un altre vector a aquest vector
    public void add(Vector2 other) {
        this.x += other.x;
        this.y += other.y;
    }

}