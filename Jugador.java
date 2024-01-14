import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {

    private int _id;
    private String _nom;
    private Vehicles _vehiclesDisponibles;
    private VehicleEnCursa _vehicle;


    public Jugador(int id, String nom){
        this._id = id;
        this._nom = nom;
    }

    public void vincularVehicles(Vehicles vehicles){
        this._vehiclesDisponibles=vehicles;
    }

    public String nomJugador(){
        return _nom;
    }

    public void participar(Cursa c){
        TipusVehicle v=null;
        v=seleccionarVehicle();
        while (v==null){
            System.out.println("    VEHICLE NO DISPONIBLE");
            v=seleccionarVehicle();
        }

        this._vehicle=c.apuntarse(this,v,p);
    }

    //mostra tipus vehicle existents i demana seleccionarne un
    //retorna vehicle seleccionat o null en cas que no existeixi
    private TipusVehicle seleccionarVehicle(){

        //MOSTRAR VEHICLES
        System.out.println("    VEHICLES");
        this._vehiclesDisponibles.mostrar();

        Scanner scanner = new Scanner(System.in);
        //TRIAR UN VEHICLE (vincular)
        System.out.print("Entra nom del Vehicle: ");
        String nomVehicle = scanner.nextLine();
        scanner.close();
        return this._vehiclesDisponibles.find(nomVehicle);

    }

    private Personatge seleccionarPersonatge(Cursa c){
        
        //MOSTRAR PERSONATGES DISPONIBLES
        System.out.println("    PERSONATGES DISPONIBLES");
        ArrayList<Personatge> personatges= new ArrayList<Personatge>();
        for(Personatge personatge:personatges){
            System.out.println("    -" + personatge.nomPersonatge());
        }
        
        Scanner scanner = new Scanner(System.in);
        //TRIAR UN PERSONATGE (vincular + deseleccionar)
        System.out.print("Entra nom del Personatge: ");
        String nomPersonatge = scanner.nextLine();
        Personatge p=null;
        boolean trobat = false;
        int i = 0;
        while(!trobat && i < personatges.size()){
            p = personatges.get(i);
            if(p.nomPersonatge().equalsIgnoreCase(nomPersonatge)){
                trobat = true;
                p.escollir();
                return p;
            }
        }
        return null;
    }
}