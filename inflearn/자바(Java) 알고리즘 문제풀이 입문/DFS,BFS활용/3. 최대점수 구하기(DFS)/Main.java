import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    private static int M, N, answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int score = Integer.parseInt(st.nextToken()); 
            int time = Integer.parseInt(st.nextToken());

            arr[i][0] = score;
            arr[i][1] = time;
        }
        DFS(0, 0, 0, arr);
        System.out.println(answer);

        br.close();
    }

    private static void DFS(int idx, int score, int time, int[][] arr) {
        if(time > M) return;

        if(idx == N) {
            answer = Math.max(answer, score);
        } else {
            DFS(idx+1, score+arr[idx][0], time+arr[idx][1], arr);
            DFS(idx+1, score, time, arr);
        }
    }
}
