import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int v1;
	int v2;
	int cost;

	public Edge(int v1, int v2, int cost) {
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost; // 비용을 기준으로 '오름차순' 정렬
	}
}

public class Main {

	private static int[] unf;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		unf = new int[v + 1];
		for(int i=1; i<=v; i++) {
			unf[i] = i;
		}
		List<Edge> edges = new ArrayList<>();

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges.add(new Edge(a, b, c));
		}

		Collections.sort(edges); // 비용이 작은 순서대로 연결되도록 정렬해준다. 그리디의 꽃은 정렬!!

		int answer = solution(edges, v);
		System.out.println(answer);
	}

	private static int solution(List<Edge> edges, int v) {
		int answer = 0;
		int linkCount = 0;

		for (Edge edge : edges) {
			if (linkCount == (v - 1)) { // 트리의 간선 갯수는 노드가 n개일 때 간선은 n-1개이므로 트리가 완성 된 이후 로직이 더 돌지 않도록 한다
				break;
			}

			int fv1 = find(edge.v1);
			int fv2 = find(edge.v2);

			if (fv1 != fv2) { // 같은 집합이 아니라면 연결된 상태가 아니므로 연결하고 비용을 추가해준다
				answer += edge.cost;
				linkCount++;
				union(edge.v1, edge.v2);
			}
		}

		return answer;
	}

	private static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);

		if (fa != fb) {
			unf[fa] = fb;
		}
	}

	private static int find(int v) {
		if (v == unf[v])
			return v;
		else
			return unf[v] = find(unf[v]);
	}
}
