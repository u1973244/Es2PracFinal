import java.util.ArrayList;

public class Kairomart {
    public static void main(String[] args) {
        TipusTerreny asfalt=new TipusTerreny("asfalt",1);
        TipusTerreny sorra=new TipusTerreny("sorra",2);
        TipusTerreny gespa=new TipusTerreny("gespa",3);

        Curses curses=new Curses();
        curses.afegirCursa(asfalt, 3, 10);
        curses.afegirCursa(asfalt, 5, 4);
        curses.afegirCursa(gespa, 3, 10);
        curses.afegirCursa(sorra, 3, 10);
    }
}