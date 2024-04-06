import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    private static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    private static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};
    private static int[][] grid;
    private static int count, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        count = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(count);
    }

    private static void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // 섬을 발견한 순간부터 DFS 호출 시작
                    count++;
                    grid[i][j] = 0; // 출발점을 바다로 만들어서 되돌아오지 못하도록 하자
                    DFS(i, j);
                }
            }
        }
    }

    private static void DFS(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                grid[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }
}
