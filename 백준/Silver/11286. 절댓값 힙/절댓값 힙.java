import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	private static Queue<Integer> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int a = Math.abs(o1);
				int b = Math.abs(o2);

				if(a==b) {
					return o1-o2;
				} else {
					return a-b;
				}
			}
		});

		int n = Integer.parseInt(br.readLine());

		for(int i=0; i<n; i++) {
			int value = Integer.parseInt(br.readLine());
			solution(value);
		}
	}

	private static void solution(int value) {
		if(pq.isEmpty() && value == 0) {
			System.out.println(0);
		} else if (value == 0) {
			System.out.println(pq.poll());
		} else {
			pq.add(value);
		}
	}
}
