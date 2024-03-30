import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static int M, answer=Integer.MAX_VALUE;
    private static Integer[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        coin = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coin, Collections.reverseOrder()); // 큰 동전부터 돌도록 해서 실행시간을 줄인다, 성능 향상

        M = Integer.parseInt(br.readLine());
        DFS(0, 0);
        System.out.println(answer);
    }

    private static void DFS(int level, int sum) {
        if(sum > M) return;
        if(level >= answer) return; // 최소 level을 구하기때문에 현재 answer보다 큰 level은 볼 필요없다 !!, 성능 향상

        if(sum == M) {
            answer = Math.min(answer, level); // level의 최솟값을 찾자
        } else {
            for(int i=0; i<coin.length; i++) { // 중복순열처럼 n가닥 뻗어나가는 것
                DFS(level+1, sum+coin[i]);
            }
        }
    }
}
