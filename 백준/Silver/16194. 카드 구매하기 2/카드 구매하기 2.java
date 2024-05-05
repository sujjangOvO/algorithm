import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dy = new int[n+1];
		int[] p = new int[n+1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		dy[1] = p[1];

		for(int i=2; i<=n; i++) {
			dy[i] = p[i];
			
			for(int j=1; j<=i; j++) {
				dy[i] = Math.min(dy[i], dy[i-j] + p[j]);
			}
		}

		System.out.println(dy[n]);
	}
}
