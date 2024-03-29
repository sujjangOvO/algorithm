import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] pm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pm = new int[M]; // M번 뽑아 저장하는 배열
        DFS(0);
        br.close();
    }

    private static void DFS(int idx) {
        if(idx == M) {
            for(int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for(int i=1; i<=N; i++) { // i는 1부터 N까지 번호가 적힌 구슬
                pm[idx] = i;
                DFS(idx+1);
            }
        }
    }
}
