import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int v;
	int cost;

	public Edge(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

public class Main {

	private static boolean[] ch;
	private static ArrayList<ArrayList<Edge>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		ch = new boolean[v + 1];
		graph = new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Edge(b, c)); // 무방향 그래프라 a에서 b로, b에서 a로 가는 걸 2번 넣어줘야 한다
			graph.get(b).add(new Edge(a, c));
		}

		int answer = solution(1, 0);
		System.out.println(answer);
	}

	private static int solution(int v, int cost) {
		int answer = 0;
		Queue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(v, cost));

		while (!pq.isEmpty()) {
			if (successTree()) {
				break;
			}

			Edge cur = pq.poll();

			if (ch[cur.v]) { // 이미 트리에 속한 원소라면 pass
				continue;
			}

			ch[cur.v] = true;
			answer += cur.cost;

			for (Edge edge : graph.get(cur.v)) {
				if (!ch[edge.v]) { // 연결된 원소가 트리에 속하지 않았을 때만 pq에 넣어준다!!
					pq.offer(edge);
				}
			}
		}

		return answer;
	}

	private static boolean successTree() {
		for (boolean check : ch) {
			if (!check) {
				return false; // 아직 연결 안 된 노드가 있다면 false를 return
			}
		}
		return true; // 이미 트리가 다 완성되었다면 true를 return
	}
}
