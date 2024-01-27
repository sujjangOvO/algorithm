import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scores = new double[n];
        double maxValue = Integer.MIN_VALUE;
        double avg = 0;

        for(int i=0; i<n; i++) {
            scores[i] = sc.nextDouble();

            if(scores[i] > maxValue) {
                maxValue = scores[i];
            }
        }

        for(int i=0; i<n; i++) {
            scores[i] = (scores[i] / maxValue) * 100;
        }

        avg = Arrays.stream(scores).average().getAsDouble();
        System.out.println(avg);

        sc.close();
    }
}
