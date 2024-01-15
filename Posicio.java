public class Posicio {
    private double _Punt; //valor de 0 a 99 
    private int _Rotacio; //valor de 0 a 359

    // Constructor
    public Posicio(double punt, int rot) {
        this._Punt = punt;
        this._Rotacio = rot;
    }

    public void ModificarRotacio(double valor){
        this._Rotacio+=valor;
        if(this._Rotacio<0){
            this._Rotacio+=360;
        }
        else if(this._Rotacio>359){
            this._Rotacio-=360;
        }
    }

    public void ModificarPunt(double valor){
        this._Punt += valor;
        if(valor<0){
            this._Punt+=100;
        }
        else if(valor>99){
            this._Punt-=100;
        }
        else this._Punt = valor;
    }
 
}