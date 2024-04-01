import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] memory;
    private static int[] b, p, ch;
    private static int n, f;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        memory = new int[n + 1][n + 1];
        b = new int[n]; // 조합수를 구해두는 배열
        p = new int[n]; // 순열을 구하는 배열
        ch = new int[n + 1]; // 중복을 피하기 위한 배열, 인덱스가 아니라 1부터 값으로 사요한다

        for (int i = 0; i < n; i++) {
            b[i] = combi(n - 1, i); // n이4라면 3C0, 3C1, 3C2, 3C3을 (=규칙) 더한 값이 답이 된다
        }

        DFS(0, 0);
    }

    private static int combi(int n, int r) {
        if (memory[n][r] > 0) return memory[n][r];
        if (r == 0 || n == r) return 1;
        else {
            memory[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
            return memory[n][r];
        }
    }

    private static void DFS(int level, int sum) {
        if (flag) return; // 정답을 찾았다면 나머지 재귀 함수들은 빠르게 pop해주기 위함

        if (level == n) { // n길이의 순열을 만들었을 때
            if (sum == f) {
                for (int xp : p) System.out.print(xp + " ");
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) { // i는 인덱스값이 아니라 1부터n까지의 데이터 값으로 사용한다
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[level] = i;
                    DFS(level + 1, sum + (b[level] * p[level])); // 중요, combi를 통해 구한 조합의 경우와 현재 순열을 곱하여 sum으로 추가한다 (ex. 3C0*3 = 1*3 = 3)
                    ch[i] = 0;
                }
            }
        }
    }
}
