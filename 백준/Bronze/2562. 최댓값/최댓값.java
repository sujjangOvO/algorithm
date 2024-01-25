import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;

        for(int i=0; i<9; i++) {
            int value = sc.nextInt();

            if(value > maxValue) {
                maxValue = value;
                maxIndex = i+1;
            }
        }

        System.out.println(maxValue);
        System.out.println(maxIndex);

        sc.close();
    }
}
