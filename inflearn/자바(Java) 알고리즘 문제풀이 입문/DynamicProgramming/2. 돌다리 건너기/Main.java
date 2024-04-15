import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int[] dy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		dy = new int[n + 1]; 
		answer = solution(n);
		System.out.println(answer);
	}

	private static int solution(int n) {
		dy[1] = 2; // 돌이 1개일 때 개울을 "건너는" 방법은 한 번에 뛰어넘거나 1개씩 밟고 넘어가는 방법으로 2가지가 있다.
		dy[2] = 3; // 돌이 2개일 때 개울을 "건너는" 방법은 2+1, 1+2, 1+1+1으로 총 3가지 방법이 있다.

		for (int i = 3; i <= n; i++) {
			dy[i] = dy[i - 1] + dy[i - 2];
		}

		return dy[n];
	}
}
