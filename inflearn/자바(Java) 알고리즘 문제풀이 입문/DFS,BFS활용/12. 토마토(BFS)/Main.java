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
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] grid;
    private static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        grid = new int[n+1][m+1]; // 행, 열 헷갈리지 않기!

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < m+1; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = BFS();
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(grid[i][j] == 0) { // 만약 BFS를 수행하고도 익지않은 토마토가 존재한다면 토마토가 익지 못하는 상황이니 -1을 출력
                    count = -1;
                    break;
                }
            }

            if(count == -1) break;
        }
        System.out.println(count);
    }

    private static int BFS() {
        Queue<Point> q = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(grid[i][j] == 1) {
                    q.offer(new Point(i, j));
                }
            }
        }
        int level = -1; // 토마토가 모두 익어있다면 q에 처음에 다 들어가고 73번째 줄을 만족하지 못하므로 level이 1만 증가해서 0이 return됨

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Point cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && grid[nx][ny] == 0) {
                        q.offer(new Point(nx, ny));
                        grid[nx][ny] = 1; // 지나가는 곳은 체크
                    }
                }
            }

            level++;
        }

        return level;
    }
}
