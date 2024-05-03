import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dy = new int[11];

		dy[1] = 1;
		dy[2] = 2;
		dy[3] = 4;

		for (int i = 4; i <= 10; i++) {
			dy[i] = dy[i-1] + dy[i-2] + dy[i-3];
		}

		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dy[n]);
		}
	}
}
