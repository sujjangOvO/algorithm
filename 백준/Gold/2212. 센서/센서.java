import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] sensor = new int[n];
		int[] diff = new int[n - 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sensor);

		for (int i = 0; i < n - 1; i++) {
			diff[i] = sensor[i + 1] - sensor[i];
		}
		Arrays.sort(diff);

		int answer = 0;
		// k개의 집합을 위한 k-1개의 구분선 필요, n개의 센서들 중 거리의 차이는 n-1개. 
		// diff 배열의 길이는 n-1이고 그 중 k-1개를 골라야 한다.
		// 따라서, (n-1) - (k-1)으로 n-k 식이 나온다.
		for (int i = 0; i < n - k; i++) {
			answer += diff[i];
		}

		System.out.println(answer);
	}
}
