import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture> {
	int start;
	int end;

	public Lecture(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Lecture o) {
		if(this.start == o.start) {
			return this.end - o.end; // 시작시간이 같다면 끝나는 시간 기준 '오름차순' 정렬
		}
		return this.start - o.start; // 시작시간 기준 '오름차순' 정렬
	}
}

public class Main {

	private static List<Lecture> lectures;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		lectures = new ArrayList<>();

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			lectures.add(new Lecture(s, e));
		}

		Collections.sort(lectures);
		int answer = solution(n);
		System.out.println(answer);
	}

	private static int solution(int n) {
		Queue<Integer> pq = new PriorityQueue<>(); // pq에는 현재 강의 진행중인 강의의 '끝나는 시간'이 들어간다
		pq.add(lectures.get(0).end);

		for(int i=1; i<n; i++) {
			if(pq.peek() <= lectures.get(i).start) {
				pq.poll();
			}

			pq.add(lectures.get(i).end);
		}

		return pq.size();
	}
}
