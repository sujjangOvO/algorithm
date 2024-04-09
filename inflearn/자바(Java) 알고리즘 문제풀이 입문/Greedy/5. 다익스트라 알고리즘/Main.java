import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
	int vex;
	int cost;

	public Edge(int vex, int cost) {
		this.vex = vex;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost; // 오름차순, 가장 작은 cost를 우선으로 한다
	}
}

public class Main {
	private static int n, m;
	private static int[] dis; // 1번 vertex부터 n번 vertex까지 가는 최소거리
	private static ArrayList<ArrayList<Edge>> graph; // 인접 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dis = new int[n + 1]; // 1번 인덱스부터 사용
		for (int i = 0; i <= n; i++) {
			dis[i] = Integer.MAX_VALUE; // 거리값은 전부 MAX값으로 초기화해준다, 해당 값보다 작다면 dis배열에 삽입하도록
		}

		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Edge(goal, cost));
		}

		solution(1); // 1번 정점에서 출발

		for(int i=2; i<=n; i++) {
			if(dis[i] == Integer.MAX_VALUE) {
				System.out.println(i +" : Impossible"); // 1번 정점에서 도달하지 못해서 MAX값이 그대로 들어있다
			} else {
				System.out.println(i + " : " + dis[i]);
			}
		}
	}

	private static void solution(int v) {
		Queue<Edge> pq = new PriorityQueue<>(); // PriorityQueue를 사용함으로써 삽입과 삭제가 O(LogN)밖에 걸리지 않는다!!!!
		pq.offer(new Edge(v, 0)); // 시작지점 비용 0으로 초기화
		dis[v] = 0;

		while (!pq.isEmpty()) {
			Edge curEdge = pq.poll(); // cost가 가장 작은 Edge를 꺼낸다 (PQ이기 때문에 시간복잡도가 logN밖에 걸리지 않는다)!!!!
			int now = curEdge.vex;
			int nowCost = curEdge.cost;

			if(nowCost > dis[now]) continue; // nowCost가 12고 dis[2]가 11이라면 굳이 계산 할 필요가 없다.

			for (Edge edge : graph.get(now)) {
				if (dis[edge.vex] > edge.cost + nowCost) {
					dis[edge.vex] = edge.cost + nowCost;
					pq.offer(new Edge(edge.vex, dis[edge.vex]));
				}
			}
		}
	}
}
