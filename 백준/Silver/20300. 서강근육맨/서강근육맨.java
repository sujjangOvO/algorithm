import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		long answer = Long.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}

		Arrays.sort(arr);

		if (n % 2 == 0) {
			for (int i = 0; i < n/2; i++) {
				long sum = arr[i] + arr[n - 1 - i];
				answer = Math.max(answer, sum);
			}
		} else {
			answer = arr[n - 1];

			for (int i = 0; i < n/2; i++) {
				long sum = arr[i] + arr[n - 2- i];
				answer = Math.max(answer, sum);
			}
		}

		System.out.println(answer);
	}
}
