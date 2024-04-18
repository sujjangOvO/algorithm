import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static List<List<Integer>> graph;
	private static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		check = new boolean[n+1]; // 1번 인덱스부터 사용
		for (int i = 0; i <= n; i++) { // 1번 인덱스부터 사용 (i<=n)
			graph.add(new ArrayList<>());
		}

		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			// 단방향이 아니라 양방향이다
			graph.get(s).add(e);
			graph.get(e).add(s);
		}

		int answer = solution(1);
		System.out.println(answer);
	}


	// 1. s와 연결되어 있는 노드들을 입아서 queue에 삽입, 참고로 s와 연결된 노드들은 check가 false여야 한다. (방문한적 없어야 함)
	// 2. 삽입할 때 answer++, queue에 들어있는 노드들을 또 꺼내서 반복.
	private static int solution(int s) {
		int answer = 0;
		check[s] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);

		while (!queue.isEmpty()) {
			int len = queue.size();

			for(int i=0; i<len; i++) {
				Integer cur = queue.poll();

				for(Integer n : graph.get(cur)) {
					if(!check[n]) {
						check[n] = true;
						answer++;
						queue.add(n);
					}
				}
			}
		}

		return answer;
	}
}
