import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kairomart {


    private static void lecturaDades(vehiclesDisponibles){

        ArrayList<TipusTerreny> tipusTerrenys = new ArrayList<>();
        ArrayList<Personatge> personatges = new ArrayList<>();
        ArrayList<TipusVehicle> vehicles = new ArrayList<>();
        ArrayList<Jugador> jugadors = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader("./Dades"))) {
            String linia;

            while ((linia = lector.readLine()) != null) {
                String[] parts = linia.split(",");
                if(parts[0].trim()=="tipusTerreny"){
                    String nom = parts[1].trim();
                    int id = Integer.parseInt(parts[2].trim());
                    tipusTerrenys.add(new TipusTerreny(nom, id));
                }
                else if(parts[0].trim()=="personatge"){
                    String nom = parts[1].trim();
                    personatges.add(new Personatge(nom));
                }
                else if(parts[0].trim()=="vehicle"){
                    int id = parts[1].trim();
                    String nom = parts[2].trim();
                    double adherencia = parts[3].trim();
                    double resistenciaAlXoc = parts[4].trim();
                    if(parts[4].trim()=="biga"){
                        vehicles.add(new Biga(id,nom,adherencia,resistenciaAlXoc));
                    }
                    else if(parts[4].trim()=="quadriga"){
                        vehicles.add(new Quadriga(id,nom,adherencia,resistenciaAlXoc));
                    }
                    else{
                        vehicles.add(new Cavall(id,nom,adherencia,resistenciaAlXoc));
                    }
                }
                else if(parts[0].trim()=="jugador"){
                    int id = parts[1].trim();
                    String nom = parts[2].trim();
                    jugadors.add(new Jugador(id,nom));
                }


                System.out.println(linia);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        vehiclesDisponibles= new Vehicles(vehicles);

        // vincular llista de vehicles a jugadors
        for(Jugador j : jugadors){
            j.vincularVehicles(vehiclesDisponibles);
        }

    }

    private static void prepararParticipacio(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-PREPARAR PARTICIPACIÓ-");
        while(true){
            System.out.print("Entra l'ID del Jugador: ");
            String nomJugador = scanner.nextLine();
            boolean trobat = false;
            int i = 0;
            //COMPROVAR SI JUGADDOR EXISTEIX
            while(!trobat && i < jugadors.size()){
                Jugador j = jugadors.get(i);
                if(j.nomJugador().equalsIgnoreCase(nomJugador)){
                    trobat = true;
                    break;
                }
            }
            if(!trobat){
                System.out.println("\nJugador no trobat");
            }
        }
        j.participar(c);

        
        //MOSTRAR LLISTA JUGADORS INSCRITS (nom, vehicle, personatge)
            //mostrar VehicleEnCursa


    }

    private static void moureVehicle(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-MOURE VEHICLE-");
        System.out.print("Entra Vehicle: ");
        String idVehicle = scanner.nextLine();
        
        //COMPROVAR SI VEHICLE EXISTEIX
            //ENTRAR DADES MOVIMENT
            //APLICAR MOVIMENT AL VEHICLE
            //MOSTRAR EL MOVIMENT QUE S'HA FET
        //SI NO EXISTEIX, TORNAR A PREGUNTAR
        
        //scanner.close();

    }

    private static void mostrarClassificacioFinal(){

        System.out.println("\n-MOSTRAR CLASSIFICACIÓ FINAL-");
        //MOSTRAR SITUACIÓ CARRERA (vehicle, top, voltes)

    }


    public static void main(String[] args) {
        Cursa c= new Cursa(3,10,0);
        Vehicles vehiclesDisponibles;

        Scanner scanner = new Scanner(System.in);
        int opcio;
        
        do{
            System.out.println("\nOpcions:");
            System.out.println("    1. Preparar Participació");
            System.out.println("    2. Moure Vehicle");
            System.out.println("    3. Mostrar Classificació Final");
            System.out.println("    0. Sortir");
            System.out.print("Entra l'opció: ");
            
            opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    prepararParticipacio();
                    break;
                case 2:
                    moureVehicle();
                    break;
                case 3:
                    mostrarClassificacioFinal();
                    break;
                case 0:
                    System.out.println("-FINAL-");
                    break;
            
                default:
                    System.out.println("-Opció no vàlida, tria una opció vàlida-");
            }
        } while(opcio != 0);
        
        scanner.close();
        
    }

}