import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] charArray = str.toCharArray();

        for(char c : charArray) {
            char ch = (char) (c-3);

            if(ch < 'A') {
                ch = (char) (ch+26);
            }

            System.out.print(ch);
        }

        sc.close();
    }
}
