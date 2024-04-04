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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] grid, dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        grid = new int[8][8];
        dis = new int[8][8];

        for (int i = 1; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < 8; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        grid[1][1] = 1; // 출발점 체크
        BFS(1, 1);

        if (dis[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dis[7][7]);
        }
    }

    private static void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Point cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur.getX() + dx[j];
                    int ny = cur.getY() + dy[j];

                    if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && grid[nx][ny] == 0) { // 조건문 순서 유의, 좌표값이 유효한지 먼저 체크해야 인덱스 런타임 에러가 발생하지 않는다!!!!!!!!
                        q.offer(new Point(nx, ny));
                        grid[nx][ny] = 1; // 지나가는 곳은 체크
                        dis[nx][ny] = dis[cur.getX()][cur.getY()] + 1; // 거리는 이전 거리의 +1
                    }
                }
            }
        }
    }
}
