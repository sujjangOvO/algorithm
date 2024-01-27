import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            int value = sc.nextInt();

            if(value > max) {
                max = value;
            }

            if(value < min) {
                min = value;
            }
        }

        System.out.println(min + " " + max);
        sc.close();
    }
}
