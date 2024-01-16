

public class Kairomart {


    private static void prepararParticipacio(Jugadors jugadors, Cursa c){

        System.out.println("\n-PREPARAR PARTICIPACIÓ-");
        System.out.println("-JUGADOR AMB ELS QUE ET POTS IDENTIFICAR-");
        jugadors.mostra();
        System.out.print("Entra el nom del Jugador: ");
        String nomJugador = LectorEntrada.llegir();
        Jugador j=jugadors.find(nomJugador);
        while(j==null){
            System.out.println("\n**JUGADOR NO EXISTEIX**");
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
        c.mostraParticipants();
        System.out.print("Entra nom participant: ");
        String nomJugador = LectorEntrada.llegir();
        VehicleEnCursa v;
        try {
            v = c.findJugador(nomJugador);
        } catch (NumberFormatException e) {
            v=null;
        }  
        
        //COMPROVAR SI VEHICLE EXISTEIX
        while(v==null){
            System.out.println("\n**JUGADOR NO EXISTEIX**");
            c.mostraParticipants();
            System.out.print("Entra nom participant: ");
            nomJugador = LectorEntrada.llegir();
            try {
                v = c.findJugador(nomJugador);
            } catch (NumberFormatException e) {
                v=null;
            }  
        }
        
        //ENTRAR DADES MOVIMENT
        System.out.println("\n-ENTRA DADES MOVIMENT-");
        System.out.println("  - [W] Accelerar\n  - [S] Recular\n  - [X] Frenar\n  - [Z] Girar");
        String option = LectorEntrada.llegir();
        while((!option.equals("W")) && (!option.equals("S")) && (!option.equals("X")) && (!option.equals("Z"))){
            System.out.println("\n**ERROR D'ENTRADA DADES**");
            System.out.println("  - [W] Accelerar\n   - [S] Recular\n   - [X] Frenar\n    - [Z] Girar");
            option = LectorEntrada.llegir();
        }  
        switch (option) {
            case "W":
                v.avança();
                break;
            case "S":
                v.recula();
                break;
            case "X":
                v.atura();
                break;
            case "Z":
                v.gira(3.1416/4);
                break;
        }
        v.mostrarMoviment();
        
    }

    private static void mostrarClassificacioFinal(Cursa c){

        System.out.println("\n-MOSTRAR CLASSIFICACIÓ FINAL-");
        c.mostraClassificacio();

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
                    System.out.println("---FINAL---");
                    break;
            
                default:
                    System.out.println("**Opció no vàlida, tria una opció vàlida**");
            }
        } while(!opcio.equals("0"));
        LectorEntrada.close();
        
    }

}