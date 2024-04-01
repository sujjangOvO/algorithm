import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 12시, 3시, 6시, 9시 방향
    private static int[] dx = {-1, 0, 1, 0}; 
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] grid;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        grid = new int[8][8]; // index 1번부터 사용
        count = 0;

        for (int i = 1; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < 8; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        grid[1][1] = 1; // 출발점으로 되돌아 오지 못하도록 check 건다
        DFS(1, 1);
        System.out.println(count);

    }

    private static void DFS(int x, int y) {
        if (x == 7 && y == 7) {
            count++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && grid[nx][ny] == 0) {
                    grid[nx][ny] = 1;
                    DFS(nx, ny);
                    grid[nx][ny] = 0; //중요, 되돌아 올 때 체크를 다시 풀어주어야 한다
                }
            }
        }
    }
}
