import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] combi;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        combi = new int[m]; // m이 2인 경우 2개를 뽑는 배열만 갖고있으면 됨

        DFS(0, 1); // 첫번째 숫자를 1으로 넘겨준다 (첫번째 숫자가 1..)
    }

    private static void DFS(int level, int startNum) {
        if (level == m) {
            for (int x : combi) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = startNum; i <= n; i++) {
                combi[level] = i;
                DFS(level + 1, i + 1);
            }
        }
    }
}
