import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dy = new int[1001]; // n이 1일때 2번째 인덱스에 ArrayIndexOutOfBoundsException 예외가 터지므로 배열 크기를 최대로 할당
		dy[1] = 1;
		dy[2] = 2;

		for(int i=3; i<=n ;i++) {
			dy[i] = (dy[i-1] + dy[i-2]) % 10007;
		}


		System.out.println(dy[n]);
	}
}
