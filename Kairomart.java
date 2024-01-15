import java.util.Scanner;

public class Kairomart {

    private static void prepararParticipacio(Jugadors jugadors, Cursa c){

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-PREPARAR PARTICIPACIÓ-");
        System.out.println("-JUGADOR AMB ELS QUE ET POTS IDENTIFICAR-");
        jugadors.mostra();
        System.out.print("Entra l'ID del Jugador: ");
        String nomJugador = scanner.nextLine();
        Jugador j=jugadors.find(nomJugador);
        while(j==null){
            System.out.println("-JUGADOR NO EXISTEIX-");
            System.out.println("-JUGADOR AMB ELS QUE ET POTS IDENTIFICAR-");
            jugadors.mostra();
            System.out.print("Entra l'ID del Jugador: ");
            nomJugador = scanner.nextLine();
            j=jugadors.find(nomJugador);
        }

        j.participar(c);
        scanner.close();

    }

    private static void moureVehicle(Cursa c){

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-MOURE VEHICLE-");
        System.out.println("-VEHICLES EN CURSA-");
        c.mostraVehicles();
        System.out.print("Entra Vehicle: ");
        String idVehicle = scanner.nextLine();
        VehicleEnCursa v = c.findVehicle(idVehicle);
        //COMPROVAR SI VEHICLE EXISTEIX
        while(v==null){
            System.out.println("-VEHICLE NO EXISTEIX-");
            System.out.println("-VEHICLES EN CURSA-");
            c.mostraVehicles();
            System.out.print("Entra Vehicle: ");
            idVehicle = scanner.nextLine();
            v = c.findVehicle(idVehicle);
        }
        
        //ENTRAR DADES MOVIMENT
        System.out.print("-ENTRA DADES MOVIMENT-");
        System.out.print("Accelerar o Frenar:\n");
        System.out.print("- W - Accelerar\n- S - Frenar\n- X - Mantenir Velocitat\n");
        String accel = scanner.nextLine();
        while((accel != "W") && (accel != "S") && (accel != "X")){
            System.out.println("-ERROR D'ENTRADA DADES-");
            System.out.print("Accelerar o Frenar:\n");
            accel = scanner.nextLine();
        }  
        System.out.print("Girar Esquerra o Dreta:");
        System.out.print("- A - Esquerra\n- D - Dreta\n- X - Recte\n");
        String gir = scanner.nextLine();
        while(gir != "A" && gir != "D" && gir != "X"){
            System.out.println("-ERROR D'ENTRADA DADES-");
            System.out.print("Girar Esquerra o Dreta:");
            gir = scanner.nextLine();
        }

        //APLICAR MOVIMENT AL VEHICLE
        if(gir =="A"){
           v.gira(-1);
        }
        else if (gir=="D"){
            v.gira(1);
        }
        if (accel == "W"){
            v.avança();
        }
        else if (accel == "S"){
            v.recula();
        }
        
        //MOSTRAR EL MOVIMENT QUE S'HA FET
        v.mostrarMoviment();
        
        scanner.close();
    }

    private static void mostrarClassificacioFinal(Cursa c){

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
                    moureVehicle(cursa);
                    break;
                case 3:
                    mostrarClassificacioFinal(cursa);
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