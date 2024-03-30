import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[] arr, ch, pm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ch = new int[N];
        pm = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);
    }

    private static void DFS(int level) {
        if(level == M) {
            for(int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for(int i=0; i<N; i++) {
                if(ch[i] == 0) { // 중복순열이 아니라 순열이기 때문에 중복을 허용하지 않는다
                    pm[level] = arr[i];
                    ch[i] = 1;
                    DFS(level+1);
                    ch[i] = 0; // 다시 돌아오면서 ch를 풀어주어야 한다
                }
            }
        }
    }
}
