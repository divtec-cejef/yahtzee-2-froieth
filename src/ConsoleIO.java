import java.util.Scanner;

public class ConsoleIO {

    Scanner scanner = new Scanner(System.in);

    public int readNextInt() {
        return scanner.nextInt();
    }

    public String readNextLine() {
        return scanner.nextLine();
    }
    
    public void afficher(Object obj) {
        System.out.println(obj);
    }

    public void afficherSansEsp(Object obj) {
        System.out.print(obj);
    }

    public void afficherRetourLigne() {
        System.out.println();
    }

}
