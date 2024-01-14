public class Posicio {
    private double _Punt; //valor de 0 a 99 
    private double _Rotacio; //valor de 0 a 359

    // Constructor
    public Posicio(double punt, double rot) {
        this._Punt = punt;
        this._Rotacio = rot;
    }

    public ModificarRotacio(double valor){
        this._Rotacio+=valor;
        if(this._Rotacio<0){
            this._Rotacio+=360;
        }
        else if(this._Rotacio>359){
            this._Rotacio-=360;
        }
    }

    public ModificarPunt(double valor){
        this._Punt += valor;
        if(this._Punt<0){
            this._Punt+=100;
        }
        else if(this._Punt>99){
            this._Punt-=100;
        }
    }
 
}