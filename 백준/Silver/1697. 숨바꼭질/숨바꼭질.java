import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		check = new boolean[100001];

		int answer = bfs(n, k);
		System.out.println(answer);
	}

	// BFS문제
	private static int bfs(int n, int k) {
		int level = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);

		while (!queue.isEmpty()) {
			int len = queue.size();

			for (int i = 0; i < len; i++) {
				int cur = queue.poll();
				check[cur] = true;

				if (cur == k) {
					return level;
				}

				if (cur + 1 <= 100000 && !check[cur + 1]) {
					queue.add(cur + 1);
				}

				if (cur - 1 >= 0 && !check[cur - 1]) {
					queue.add(cur - 1);
				}

				if (cur * 2 <= 100000 && !check[cur * 2]) {
					queue.add(cur * 2);
				}
			}

			level++;
		}

		return level;
	}
}
