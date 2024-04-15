import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] dy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dy = new int[n];

		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = solution(arr);
		System.out.println(answer);
	}

	private static int solution(int[] arr) {
		int answer = Integer.MIN_VALUE;
		dy[0] = 1; // 첫번째 항은 자기 자신밖에 없으므로 길이는 1

		for(int i=1; i<arr.length; i++) {
			int len = 1;

			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i]) {
					len = Math.max(len, dy[j] + 1);
				}
			}

			dy[i] = len;
			answer = Math.max(answer, dy[i]);
		}

		return answer;
	}
}
