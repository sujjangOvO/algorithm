import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Brick implements Comparable<Brick> {
	int s;
	int h;
	int w;

	public Brick(int s, int h, int w) {
		this.s = s;
		this.h = h;
		this.w = w;
	}

	@Override
	public int compareTo(Brick o) {
		return o.s - this.s; // s(넓이)로 내림차순 정렬
	}
}

public class Main {

	private static int[] dy; // i번째 벽돌이 "꼭대기"에 있을 때 높이를 담는 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dy = new int[n];

		List<Brick> bricks = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			bricks.add(new Brick(s, h, w));
		}
		Collections.sort(bricks); // 넓이 기준으로 '내림차순' 정렬

		int answer = solution(bricks);
		System.out.println(answer);
	}

	private static int solution(List<Brick> bricks) {
		dy[0] = bricks.get(0).h; // 첫번째 블럭이 가장 넓은 넓이를 가졌기 때문에 꼭대기로 간다면 아래에 올 수 있는 블럭이 없다
		int answer = dy[0]; // 첫번째 블럭이 가장 넓은 넓이면서 가장 높은 높이를 가질 수도 있기 때문에 answer의 초기값은 dy[0]이다.

		for (int i = 1; i < bricks.size(); i++) {
			int max_height = 0;
			int weight = bricks.get(i).w;

			for (int j = 0; j < i; j++) {
				if (bricks.get(j).w > weight && dy[j] > max_height) {
					max_height = dy[j]; // 이때까지 쌓인 블럭의 높이 = dy[j]
				}
			}

			dy[i] = max_height + bricks.get(i).h; // 이떄까지 쌓인 블럭의 높이 + 현재 블럭의 높이
			answer = Math.max(answer, dy[i]);
		}

		return answer;
	}
}
