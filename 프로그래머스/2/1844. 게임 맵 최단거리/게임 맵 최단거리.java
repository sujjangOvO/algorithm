import java.util.*;

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

class Solution {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
    
        return bfs(0, 0, n, m, maps);
    }
    
    public int bfs(int x, int y, int n, int m, int[][] maps) {
        int[][] dis = new int[n][m];
        boolean[][] check = new boolean[n][m];
        
        Queue<Point> q = new LinkedList<>();
        Point point = new Point(x, y);
        q.offer(point);
        dis[x][y] = 1;
        check[x][y] = true;
        
        while(!q.isEmpty()) {
            int len = q.size();
            
            for(int i=0; i<len; i++) {
                Point cur = q.poll();
                
                for(int j=0; j<4; j++) {
                    int nx = cur.getX() + dx[j];
                    int ny = cur.getY() + dy[j];
                    
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && 
                       maps[nx][ny] == 1 && !check[nx][ny]) {
                        check[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                        dis[nx][ny] = dis[cur.getX()][cur.getY()] + 1;
                    }
                }
                
            }
        }
        
        if(dis[n-1][m-1] == 0) {
            return -1;
        } else {
            return dis[n-1][m-1];
        }
    }
}