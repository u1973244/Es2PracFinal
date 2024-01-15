public class Posicio {
    private double _Punt; //valor de 0 a 99 
    private int _Rotacio; //valor de 0 a 359
    private double _PosMax;
    private double _PosMin;

    // Constructor
    public Posicio(int rot, double max, double min) {
        this._Punt = min;
        this._Rotacio = rot;
        this._PosMax = max;
        this._PosMin = min;
    }

    public void ModificarRotacio(double valor){
        _Rotacio+=valor;
        if(_Rotacio<-180){
           _Rotacio+=360; 
        }
        else if(_Rotacio>180){
            _Rotacio-=360;
        }       
    }

    public boolean ModificarPunt(double valor){
        _Punt += (valor*Math.cos(valor)); //depenent del grau de gir no avançara en linia recta
        if(valor<_PosMin){
            _Punt+=_PosMax;
            return false;
        }
        else if(valor>_PosMax){
            _Punt-=_PosMax;
            return true;
        }
        else _Punt = valor;
        return false;
    }

    public double getPunt(){ return _Punt;}

    public int getRotacio(){ return _Rotacio;}

    public double getRestant(){
        return _PosMax-_Punt;
    }
}