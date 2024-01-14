import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kairomart {

    private static void prepararParticipacio(Jugadors jugadors, Cursa c){

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-PREPARAR PARTICIPACIÓ-");
        Jugador j;
        while(true){
            System.out.print("Entra l'ID del Jugador: ");
            String nomJugador = scanner.nextLine();
            boolean trobat = false;
            int i = 0;
            //COMPROVAR SI JUGADDOR EXISTEIX
            while(!trobat && i < jugadors.size()){
                j = jugadors.get(i);
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

        Vehicles vehiclesDisponibles = new Vehicles("DadesVehicles");
        Jugadors jugadors = new Jugadors("DadesJugadors",vehiclesDisponibles);

        Cursa cursa=new Cursa(3,10);

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
                    prepararParticipacio(jugadors,cursa);
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