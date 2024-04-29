import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dy = new int[n + 1]; // index 1번부터 사용
		dy[1] = 0;

		for (int i = 2; i <= n; i++) {
			dy[i] = dy[i - 1] + 1;

			if (i % 2 == 0) { // 2로 나뉘어진다면 dy[i/2]+1와 dy[i-1]+1 값 중 최소값 선택
				dy[i] = Math.min(dy[i], dy[i / 2] + 1);
			}

			if (i % 3 == 0) { // 3로 나뉘어진다면 dy[i/3]+1와 dy[i-1]+1 값 중 최소값 선택
				dy[i] = Math.min(dy[i], dy[i / 3] + 1);
			}
		}

		System.out.println(dy[n]);
	}
}
