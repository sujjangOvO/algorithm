import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] unf;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		unf = new int[n+1];
		for(int i=1; i<=n; i++) {
			unf[i] = i;
		}

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		if(find(a) == find(b)) { // a과 b가 같은 집합이라면 친구
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static int find(int v) {
		if(v == unf[v]) return v;
		else return unf[v] = find(unf[v]); // unf[v]에 값을 넣어줌으로서 일자로 이어지던 경로를 단축해준다!!!
	}

	private static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);

		if(fa != fb) unf[fa] = fb;
	}
}
