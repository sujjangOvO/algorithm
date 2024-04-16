import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.sound.sampled.Port;

class Problem {
	int score;
	int time;

	public Problem(int score, int time) {
		this.score = score;
		this.time = time;
	}
}

public class Main {

	private static int[] dy; // i원을 만드는데 드는 최소 동전 갯수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dy = new int[m + 1]; // m번째 인덱스까지 사용하기 위함
		Problem[] problems = new Problem[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int score = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			problems[i] = new Problem(score, time);
		}

		int answer = solution(problems, m);
		System.out.println(answer);
	}

	private static int solution(Problem[] problems, int m) {
		for (int i = 0; i < problems.length; i++) {
			int pt = problems[i].time;
			int ps = problems[i].score;

			for (int j = m; j >= pt; j--) { // 문제는 유형당 한개만 풀 수 있으므로 중복이 없도록 반복문은 뒤에서부터 돈다.
				int score = dy[j - pt] + ps; // 현재 problem[i]의 문제를 푼다고 가정

				if (dy[j] < score) {
					dy[j] = score;
				}
			}
		}

		return dy[dy.length - 1];
	}
}
