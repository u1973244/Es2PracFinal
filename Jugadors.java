import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jugadors {
    private ArrayList<Jugador> _jugadors = new ArrayList<>();

    public Jugadors(String document, Vehicles vehicles){

        try (BufferedReader lector = new BufferedReader(new FileReader(document))) {
            String linia;

            while ((linia = lector.readLine()) != null) {
                String[] parts = linia.split(",");

                this._jugadors.add(new Jugador(Integer.parseInt(parts[1].trim()),parts[2].trim(),vehicles));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Jugador find(String nomJugador){
        for(Jugador j : _jugadors){
            if(j.nomJugador()==nomJugador) return j;
        }
        return null;
    }

    public void mostra(){
        for(Jugador j : _jugadors){
            System.out.println(j.nomJugador());
        }
    }
}
