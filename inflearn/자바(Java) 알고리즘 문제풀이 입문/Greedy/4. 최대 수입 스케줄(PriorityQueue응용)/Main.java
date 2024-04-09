import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Lecture implements Comparable<Lecture> {
	int money;
	int day;

	public Lecture(int money, int day) {
		this.money = money;
		this.day = day;
	}

	@Override
	public int compareTo(Lecture o) {
		if (o.day == this.day) {
			return o.money - this.money; 
		}
		return o.day - this.day; // day기준 내림차순
	}
}

public class Main {
	private static List<Lecture> lectures;
	private static int maxDay = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		lectures = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			lectures.add(new Lecture(m, d));

			if (d > maxDay) {
				maxDay = d;
			}
		}

		Collections.sort(lectures);
		int answer = solution(n);
		System.out.println(answer);
	}

	private static int solution(int n) {
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 강연료 내림차순
		int answer = 0;

		int j = 0; // 반복문을 돌 때 j값을 초기화시키지 않고 이전 값에서 증가하도록 한다
		for (int i = maxDay; i >= 1; i--) { // 날짜를 거꾸로 돌려서 선택하도록 한다. 3일째 넣은건 2일째에도 선택이 가능하기 때문이다
			for (; j < n; j++) {
				if (lectures.get(j).day < i) { // 3일짜리 강의가 있을 때 i가 4라면(=4일째) 넣을 수 있는게 없다
					break;
				}
				pq.offer(lectures.get(j).money);
			}

			if (!pq.isEmpty()) {
				answer += pq.poll(); // i 날짜의 가장 큰 값을 꺼내줌
			}
		}

		return answer;
	}
}
