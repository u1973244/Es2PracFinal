import java.util.ArrayList;

public class Jugador {

    private int _id;
    private String _nom;
    private ArrayList<TipusVehicle> _vehiclesDisponibles;
    private VehicleEnCursa _vehicle;


    public Jugador(int id, String nom){
        this._id = id;
        this._nom = nom;
    }

    public void vincularVehicles(ArrayList<TipusVehicle> vehicles){
        this._vehiclesDisponibles=vehicles;
    }

    public String nomJugador(){
        return _nom;
    }

    public void participar(Cursa c){
        //MOSTRAR VEHICLES
        System.out.println("    VEHICLES");
        for(TipusVehicle vehicle : this._vehiclesDisponibles){
            System.out.println("    -" + vehicle.nomVehicle());
        }
        //TRIAR UN VEHICLE (vincular)
        System.out.print("Entra nom del Vehicle: ");
        String nomVehicle = scanner.nextLine();
        trobat = false;
        i = 0;
        while(!trobat && i < vehicles.size()){
            Personatge v = vehicles.get(i);
            if(v.nomVehicle().equalsIgnoreCase(nomVehicle)){
                trobat = true;
            }

        }
        //MOSTRAR PERSONATGES DISPONIBLES
        System.out.println("    PERSONATGES DISPONIBLES");
        for(Personatge personatge:personatges){
            if(personatge.elegible()){
                System.out.println("    -" + personatge.nomPersonatge());
            }
        }
        //TRIAR UN PERSONATGE (vincular + deseleccionar)
        System.out.print("Entra nom del Personatge: ");
        String nomPersonatge = scanner.nextLine();
        boolean trobat = false;
        int i = 0;
        while(!trobat && i < personatges.size()){
            Personatge p = personatges.get(i);
            if(p.nomPersonatge().equalsIgnoreCase(nomPersonatge)){
                trobat = true;
                p.escollir();
            }
        }
        //VINCULAR INSCRIURE jugador, p, v
        this._vehicle=c.apuntarse(this,v,p);
    }
}