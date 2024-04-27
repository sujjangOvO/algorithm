import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Queue<Integer> minHeap = new PriorityQueue<>();
			Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			List<Integer> mid = new ArrayList<>();

			System.out.println((n + 1) / 2);

			int cnt = 1;

			for (int i = 0; i < n; i++) {
				if (i % 10 == 0) {
					st = new StringTokenizer(br.readLine(), " ");
				}

				int value = Integer.parseInt(st.nextToken());

				if (maxHeap.size() == minHeap.size()) {
					maxHeap.offer(value);
				} else {
					minHeap.offer(value);
				}

				if (!minHeap.isEmpty()) {
					if (maxHeap.peek() > minHeap.peek()) {
						int n1 = maxHeap.poll();
						int n2 = minHeap.poll();

						maxHeap.offer(n2);
						minHeap.offer(n1);
					}
				}

				if (cnt % 2 != 0) {
					mid.add(maxHeap.peek());
				}

				cnt++;
			}

			for(int i=0; i<mid.size(); i++){
				System.out.print(mid.get(i) + " ");
				if(i % 10 == 9){
					System.out.println();
				}
			}

			System.out.println();
		}
	}
}
