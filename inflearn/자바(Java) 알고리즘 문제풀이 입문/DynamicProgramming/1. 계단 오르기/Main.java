import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int[] dy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		dy = new int[n + 1]; // 1번 인덱스부터 사용
		answer = solution(n);
		System.out.println(answer);
	}

	private static int solution(int n) {
		dy[1] = 1;
		dy[2] = 2;

		for (int i = 3; i <= n; i++) {
			dy[i] = dy[i - 1] + dy[i - 2];
		}

		return dy[n];
	}
}
