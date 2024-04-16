import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int[] dy; // i원을 만드는데 드는 최소 동전 갯수
	private static int[] coin; // 동전 종류

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		coin = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		dy = new int[m + 1]; // 인덱스 번호가 m까지 생겨야 함

		int answer = solution();
		System.out.println(answer);
	}

	private static int solution() {
		Arrays.fill(dy, Integer.MAX_VALUE);
		dy[0] = 0; // 0원은 0개로 생성

		for (int i = 0; i < coin.length; i++) {
			for (int j = coin[i]; j < dy.length; j++) {
				int count = dy[j - coin[i]] + 1; // dy[j-coin[i]]+1: +1은 해당 coin 1개를 더하는 것을 의미, dy[j-coin[i]은 해당 coin을 빼고 남은 금액을 이미 구한 dy 배열에서 갯수를 가져오는 것

				if (dy[j] > count) {
					dy[j] = count;
				}
			}
		}

		return dy[dy.length - 1];
	}
}
