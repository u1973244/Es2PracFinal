import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {

    private int _id;
    private String _nom;
    private Vehicles _vehiclesDisponibles;
    private VehicleEnCursa _vehicle=null;
    private Cursa _cursa;


    public Jugador(int id, String nom, Vehicles vehicles){
        this._id = id;
        this._nom = nom;
        this._vehiclesDisponibles=vehicles;
    }

    public String nomJugador(){
        return _nom;
    }

    public void participar(Cursa c){
        if(_vehicle!=null){
            System.out.println("    AQUEST JUGADOR JA ESTÀ PARTICIPANT A LA CURSA");
            return;
        }

        
        TipusVehicle v=null;
        v=seleccionarVehicle();
        while (v==null){
            System.out.println("    VEHICLE NO DISPONIBLE");
            v=seleccionarVehicle();
        }
        Personatge p=null;
        p=seleccionarPersonatge(c);
        while (v==null){
            System.out.println("    PERSONATGE NO DISPONIBLE");
            v=seleccionarVehicle();
        }

        this._vehicle=c.apuntarse(this,v,p);
        this._cursa=c;

        System.out.println("    PARTICIPANTS A LA CURSA:");
        c.mostraParticipants();
    }

    //mostra tipus vehicle existents i demana seleccionarne un
    //retorna vehicle seleccionat o null en cas que no existeixi
    private TipusVehicle seleccionarVehicle(){

        //MOSTRAR VEHICLES
        System.out.println("    VEHICLES");
        this._vehiclesDisponibles.mostrar();

        Scanner scanner = new Scanner(System.in);
        //TRIAR UN VEHICLE
        System.out.print("Entra nom del Vehicle: ");
        String nomVehicle = scanner.nextLine();
        scanner.close();
        return this._vehiclesDisponibles.find(nomVehicle);

    }

    private Personatge seleccionarPersonatge(Cursa c){
        
        //MOSTRAR PERSONATGES DISPONIBLES
        System.out.println("    PERSONATGES DISPONIBLES");
        ArrayList<Personatge> personatges= c.personatgesDisponibles();
        for(Personatge personatge:personatges){
            System.out.println("    -" + personatge.nomPersonatge());
        }
        
        Scanner scanner = new Scanner(System.in);
        //TRIAR UN PERSONATGE
        System.out.print("Entra nom del Personatge: ");
        String nomPersonatge = scanner.nextLine();
        scanner.close();
        for(Personatge p : personatges){
            if(p.nomPersonatge().equalsIgnoreCase(nomPersonatge)){
                p.escollir();
                return p;
            }
        }
        return null;
    }
}