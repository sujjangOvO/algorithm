import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    private static int C, N, answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        DFS(0, 0, arr);
        System.out.println(answer);

        br.close();
    }

    private static void DFS(int idx, int sum, int[] arr) {
        if(sum > C)
            return;
        if(sum > answer)
            answer = sum;

        if(idx < N) {
            DFS(idx+1, sum + arr[idx], arr);
            DFS(idx+1, sum, arr);
        }
    }
}
