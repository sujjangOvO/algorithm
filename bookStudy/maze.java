package bookStudy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class NodeBFS{
    private int x, y;

    public NodeBFS(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class maze { // bfs 문제
    public static int n, m;
    public static int[][] maze = new int[201][201]; // m, n 최대값이 200이므로 201로 설정

    // 상, 하, 좌, 우
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int bfs(int x, int y){
        Queue<NodeBFS> q = new LinkedList<>();
        q.offer(new NodeBFS(x,y)); // 처음 위치에서 시작.

        while(!q.isEmpty()){
            NodeBFS node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) { // 4방향 이동
                int nx = x + dx[i];
                int ny = y + dy[i];

                if( nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if( maze[nx][ny] != 1) // 괴물있는 위치
                    continue;
                else{ // 없는 위치
                    maze[nx][ny] = maze[x][y] + 1; // 거리 +1
                    q.offer(new NodeBFS(nx,ny)); // 인접 노드 큐에 offer
                }


            }
        }

        return maze[n-1][m-1]; // 최단 경로 값
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        // 미로 맵 설정
        for (int i = 0; i <n  ; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0)); // 처음 위치에서 시작

        // bfs는 시작 지점에서 가까운 노드부터 차례대로 그래프의 모든 노드를 탐색색

    }
}


