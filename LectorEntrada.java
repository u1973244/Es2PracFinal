import java.util.Scanner;

public class LectorEntrada {
    private static Scanner scanner = new Scanner(System.in);

    public static String llegir() {
        return scanner.nextLine();
    }
    public static void close() {
        scanner.close();
    }
}
