import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kairomart {

    private static void lecturaDades(){

        try (BufferedReader lector = new BufferedReader(new FileReader("./Dades"))) {
            String linia;
            List<TipusTerreny> tipusTerrenys = new ArrayList<>();
            List<Personatge> personatges = new ArrayList<>();
            List<Vehicle> vehicles = new ArrayList<>();

            while ((linia = lector.readLine()) != null) {
                String[] parts = linia.split(",");
                if(parts[0].trim()=="tipusTerreny"){
                    String nom = parts[1].trim();
                    int id = Integer.parseInt(parts[2].trim());
                    tipusTerrenys.add(new TipusTerreny(nom, id));
                }
                else if(parts[0].trim()=="personatge"){
                    String nom = parts[1].trim();
                    Personatge.add(new Personatge(nom));
                }
                else if(parts[0].trim()=="vehicle"){
                    int id = parts[1].trim();
                    String nom = parts[2].trim();
                    double adherencia = parts[3].trim();
                    double resistenciaAlXoc = parts[4].trim();
                    vehicles.add(new Vehicle(id,nom,adherencia,resistenciaAlXoc));
                }


                System.out.println(linia);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void prepararParticipacio(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-PREPARAR PARTICIPACIÓ-");
        System.out.print("Entra l'ID del Jugador: ");
        String idJugador = scanner.nextLine();
        //entenc que els jugadors estan entrats, si no fos així es crea el jugador i no es comprova
        //COMPROVAR SI JUGADDOR EXISTEIX
            //MOSTRAR PERSONATGES DISPONIBLES
            //TRIAR UN PERSONATGE (vincular + deseleccionar)
            //MOSTRAR VEHICLES
            //TRIAR UN VEHICLE (vincular)
        //SI NO EXISTEIX, TORNAR A PREGUNTAR
        
        //MOSTRAR LLISTA JUGADORS INSCRITS (nom, vehicle, personatge)

        //scanner.close();

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

        lecturaDades();

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