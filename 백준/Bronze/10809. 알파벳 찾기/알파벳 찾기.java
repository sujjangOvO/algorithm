import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        for(int i=97; i<123; i++) {
            char c = (char) i;
            System.out.print(str.indexOf(c)+" ");
        }

        sc.close();
    }
}
