import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int number;
	int count;

	public Node(int number, int count) {
		this.number = number;
		this.count = count;
	}

	@Override
	public int compareTo(Node o) {
		if (o.count == this.count) {
			return this.number - o.number;
		} else {
			return this.count - o.count;
		}
	}
}

public class Main {
	private static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new int[3][3];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		while (true) {
			if (time > 100) {
				time = -1;
				break;
			}


			if(r-1 < arr.length && c-1 < arr[0].length && arr[r-1][c-1] == k) {
				break;
			}

			if (arr.length >= arr[0].length) {
				arr = sortR();
			} else {
				arr = sortC();
			}

			time++;
		}

		System.out.println(time);
	}

	public static int[][] sortR() {
		int[][] temp = new int[101][101];
		int max_row = 0;

		for (int i = 0; i < arr.length; i++) {
			int[] number = new int[101];
			Queue<Node> pq = new PriorityQueue<>();

			// 숫자(1~100) 카운팅
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] != 0) {
					number[arr[i][j]]++;
				}
			}

			// 카운팅한 숫자 정렬하기
			for (int j = 1; j < number.length; j++) {
				if (number[j] == 0)
					continue;
				pq.add(new Node(j, number[j]));
			}

			// 정렬 된 값을 임시 배열에 넣고 최대 행 길이 구하기
			int size = 0;
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				temp[i][size++] = cur.number;
				temp[i][size++] = cur.count;
			}
			max_row = Math.max(max_row, size);

		}

		if(max_row > 100) max_row = 100;
		int[][] result = new int[arr.length][max_row];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < max_row; j++) {
				result[i][j] = temp[i][j];
			}
		}

		return result;
	}

	public static int[][] sortC() {
		int[][] temp = new int[101][101];
		int max_col = 0;

		for (int i = 0; i < arr[0].length; i++) {
			int[] number = new int[101];
			Queue<Node> pq = new PriorityQueue<>();

			// 숫자(1~100) 카운팅
			for (int j = 0; j < arr.length; j++) {
				if (arr[j][i] != 0) {
					number[arr[j][i]]++;
				}
			}

			// 카운팅한 숫자 정렬하기
			for (int j = 1; j < number.length; j++) {
				if (number[j] == 0)
					continue;
				pq.add(new Node(j, number[j]));
			}

			// 정렬 된 값을 임시 배열에 넣고 최대 행 길이 구하기
			int size = 0;
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				temp[size++][i] = cur.number;
				temp[size++][i] = cur.count;
			}

			max_col = Math.max(max_col, size);
		}

		if(max_col > 100) max_col = 100;
		int[][] result = new int[max_col][arr[0].length];
		for (int i = 0; i < max_col; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				result[i][j] = temp[i][j];
			}
		}

		return result;
	}
}
