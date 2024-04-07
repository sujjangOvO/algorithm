import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    private static int[][] grid;
    private static int[] combi;
    private static int answer = Integer.MAX_VALUE, n, m;
    private static List<Point> house, piza;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        combi = new int[m];
        house = new ArrayList<>();
        piza = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());

                if (grid[i][j] == 1) {
                    house.add(new Point(i, j));
                }

                if (grid[i][j] == 2) {
                    piza.add(new Point(i, j));
                }
            }
        }

        DFS(0, 0);
        System.out.println(answer);
    }

    private static void DFS(int level, int startNum) {
        if (level == m) {
            // 구한 피자집 조합으로 각 집에서 피자집까지 거리 구하기
            int dis = solution(0);
            answer = Math.min(answer, dis);
        } else {
            for (int i = startNum; i < piza.size(); i++) {
                combi[level] = i; // 조합은 '인덱스 번호'를 조합하는 것이다
                DFS(level + 1, i + 1);
            }
        }
    }

    private static int solution(int sum) {
        for (Point h : house) {
            int dis = Integer.MAX_VALUE;

            for (int i : combi) {
                Point point = piza.get(i);
                dis = Math.min(dis, Math.abs(h.x - point.x) + Math.abs(h.y - point.y)); // 1개의 집에 대해 조합된 피자집 중 가장 가까운 "피자배달거리"를 구한다
                // "피자배달거리": 해당 집과 도시에 존재하는 피자집들과의 거리 중 최소값을 의미, 그래서 Math.min으로 비교하는 것
            }

            sum += dis; // 도시의 피자 배달거리(=sum) : 각 집들의 "피자배달거리"를 합한 것을 의미
        }

        return sum;
    }
}
