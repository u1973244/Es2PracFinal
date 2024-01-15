

public class Kairomart {

    private static void prepararParticipacio(Jugadors jugadors, Cursa c){

        System.out.println("\n-PREPARAR PARTICIPACIÓ-");
        System.out.println("-JUGADOR AMB ELS QUE ET POTS IDENTIFICAR-");
        jugadors.mostra();
        System.out.print("Entra el nom del Jugador: ");
        String nomJugador = LectorEntrada.llegir();
        Jugador j=jugadors.find(nomJugador);
        while(j==null){
            System.out.println("-JUGADOR NO EXISTEIX-");
            System.out.println("-JUGADORS AMB ELS QUE ET POTS IDENTIFICAR-");
            jugadors.mostra();
            System.out.print("Entra el nom del Jugador: ");
            nomJugador = LectorEntrada.llegir();
            j=jugadors.find(nomJugador);
        }

        j.participar(c);

    }

    private static void moureVehicle(Cursa c){

        System.out.println("\n-MOURE VEHICLE-");
        System.out.println("-VEHICLES EN CURSA-");
        c.mostraVehicles();
        System.out.print("Entra Vehicle: ");
        String idVehicle = LectorEntrada.llegir();
        VehicleEnCursa v;
        try {
            int idEnter = Integer.parseInt(idVehicle);
            v = c.findVehicle(idEnter);
        } catch (NumberFormatException e) {
            v=null;
        }  
        
        //COMPROVAR SI VEHICLE EXISTEIX
        while(v==null){
            System.out.println("-VEHICLE NO EXISTEIX-");
            System.out.println("-VEHICLES EN CURSA-");
            c.mostraVehicles();
            System.out.print("Entra Vehicle: ");
            idVehicle = LectorEntrada.llegir();
            try {
                int idEnter = Integer.parseInt(idVehicle);
                v = c.findVehicle(idEnter);
            } catch (NumberFormatException e) {
                v=null;
            }  
        }
        
        //ENTRAR DADES MOVIMENT
        System.out.print("-ENTRA DADES MOVIMENT-");
        System.out.print("Accelerar o Frenar:\n");
        System.out.print("- W - Accelerar\n- S - Frenar\n- X - Mantenir Velocitat\n");
        String accel = LectorEntrada.llegir();
        while((accel != "W") && (accel != "S") && (accel != "X")){
            System.out.println("-ERROR D'ENTRADA DADES-");
            System.out.print("Accelerar o Frenar:\n");
            accel = LectorEntrada.llegir();
        }  
        System.out.print("Girar Esquerra o Dreta:");
        System.out.print("- A - Esquerra\n- D - Dreta\n- X - Recte\n");
        String gir = LectorEntrada.llegir();
        while(gir != "A" && gir != "D" && gir != "X"){
            System.out.println("-ERROR D'ENTRADA DADES-");
            System.out.print("Girar Esquerra o Dreta:");
            gir = LectorEntrada.llegir();
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
        
    }

    private static void mostrarClassificacioFinal(Cursa c){

        System.out.println("\n-MOSTRAR CLASSIFICACIÓ FINAL-");
        //MOSTRAR SITUACIÓ CARRERA (vehicle, top, voltes)

    }


    public static void main(String[] args) {
        Terrenys terrenys=new Terrenys("DadesTerreny");
        Vehicles vehiclesDisponibles = new Vehicles("DadesVehicles",terrenys.tipus());
        Jugadors jugadors = new Jugadors("DadesJugadors",vehiclesDisponibles);

        Cursa cursa=new Cursa(3,10,terrenys);

        String opcio;
        
        do{
            System.out.println("\nOpcions:");
            System.out.println("    1. Preparar Participació");
            System.out.println("    2. Moure Vehicle");
            System.out.println("    3. Mostrar Classificació Final");
            System.out.println("    0. Sortir");
            System.out.print("Entra l'opció: ");
            
            opcio = LectorEntrada.llegir();

            switch (opcio) {
                case "1":
                    prepararParticipacio(jugadors,cursa);
                    break;
                case "2":
                    moureVehicle(cursa);
                    break;
                case "3":
                    mostrarClassificacioFinal(cursa);
                    break;
                case "0":
                    System.out.println("-FINAL-");
                    break;
            
                default:
                    System.out.println("-Opció no vàlida, tria una opció vàlida-");
            }
        } while(opcio != "0");
        
        
    }

}