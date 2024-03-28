import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    private static int total, n;
    private static boolean flag = false;
    private static String answer = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        DFS(0, 0, arr);
        System.out.println(answer);

        br.close();
    }

    public static void DFS(int idx, int sum, int[] arr) {
        if(flag) return; // stack에 남아있는 재귀함수들을 pop해 주어야 함

        if(idx == n) {
            if((total - sum) == sum) { // 2개의 부분집합을 구할 필요없이 1개의 부분집합만 구해도 해결 가능. 1개의 부분집합의 합과 총합의 차이가 다른 나머지 부분집합의 합이기 때문이다
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(idx+1, sum+arr[idx], arr); // 다음 인덱스를 포함한 부분집합을 만든다
            DFS(idx+1, sum, arr); // 다음 인덱스를 포함하지 않은 부분집합을 만든다
        }
    }
}
