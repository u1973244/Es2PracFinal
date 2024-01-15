public class Vector2 {
    private double _x;
    private double _y;


    public Vector2(double x, double y){
        this._x=x;
        this._y=y;
    }

    public void set(double x, double y){
        this._x=x;
        this._y=y;
    }

    public double y(){
        return _y;
    }

    public double x(){
        return _x;
    }

    public double magnitude(){
        return Math.sqrt(Math.pow(this._x,2)+Math.pow(this._y,2));
    }

    public void normalize(){
        if(this.magnitude()!=0){
            this._x=this._x/this.magnitude();
            this._y=this._y/this.magnitude();
        }
    }

    public void scale(double s){
        this._x=this._x*s;
        this._y=this._y*s;
    }

    public void add(Vector2 a){
        this._x+=a.x();
        this._y+=a.y();
    }

    
    public void rotate(double alpha) {
        double xRotat = this._x * Math.cos(alpha) - this._y * Math.sin(alpha);
        double yRotat = this._x * Math.sin(alpha) + this._y * Math.cos(alpha);

        this._x = xRotat;
        this._y = yRotat;
    }
}
