import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int minValue = Integer.MAX_VALUE;

        for(int i=0; i<7; i++) {
            int value = sc.nextInt();

            if(value%2!=0) {
                sum += value;

                if(value < minValue) {
                    minValue = value;
                }
            }
        }

        if(sum != 0) {
            System.out.println(sum);
            System.out.println(minValue);
        } else {
            System.out.println(-1);
        }

        sc.close();
    }
}
