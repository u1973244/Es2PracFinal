import java.util.ArrayList;

public class Curses {
    private ArrayList<Cursa> _curses;


    public void afegirCursa(TipusTerreny terreny, int durada, int maxParticipants){
        _curses.add(new Cursa(terreny,durada,maxParticipants,freeId()));
    }

    private int freeId(){ // manera cutre de trobat posar identificador unic
        int maxId=0;
        for (Cursa c : _curses) {
            maxId=Math.max(c.id(), maxId);
        }
        return maxId;
    }
}
