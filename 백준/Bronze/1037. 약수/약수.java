import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            int value = sc.nextInt();
            
            if(value > maxValue) {
                maxValue = value;
            }

            if(value < minValue) {
                minValue = value;
            }
        }

        System.out.println(maxValue * minValue);
        sc.close();
    }
}
