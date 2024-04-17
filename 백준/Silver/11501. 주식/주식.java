import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while(T>0) {
			int n = Integer.parseInt(br.readLine());
			int[] stocks = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for(int i=0; i<n; i++) {
				stocks[i] = Integer.parseInt(st.nextToken());
			}

			long answer = solution(n, stocks);
			System.out.println(answer);

			T--;
		}

		br.close();
	}

	private static long solution(int n, int[] stocks) {
		long answer = 0;
		int max = stocks[n-1];

		for(int i=n-2; i>=0; i--) {
			if(max >= stocks[i]) {
				answer += max - stocks[i];
			} else {
				max = stocks[i];
			}
		}

		return answer;
	}

}
