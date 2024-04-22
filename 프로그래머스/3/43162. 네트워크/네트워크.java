import java.util.*;

class Solution {
	public int solution(int n, int[][] computers) {
		int answer = 0;

		boolean[] check = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());

			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;

				if (computers[i][j] == 1) {
					graph.get(i).add(j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				q.offer(i);
				check[i] = true;

				while (!q.isEmpty()) {
					int cur = q.poll();

					for (int c : graph.get(cur)) {
						if (!check[c]) {
							q.offer(c);
							check[c] = true;
						}
					}
				}
				answer++;
			}

		}
		return answer;
	}
}    