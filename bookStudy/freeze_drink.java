package bookStudy;

import java.util.Scanner;

public class freeze_drink {

    public static int n,m;
    public static int[][] graph = new int[1000][1000];

    public static boolean dfs(int x, int y){

        if(x < 0 || y < 0 || x >= n || y >= m )
            return false;

        if(graph[x][y]==0) { // 아직 노드 방문 x
            graph[x][y] = 1; // 방문 처리

            dfs(x-1,y); // 상
            dfs(x,y+1); // 하
            dfs(x+1,y); // 좌
            dfs(x,y-1); // 우

            return true;

        }

        return false;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        scan.nextLine(); // 버퍼 비움

        int count = 0; // 총 아이스크림 갯수

        // 맵 정보 받기
        for (int i = 0; i < n; i++) {
            String str = scan.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // 모든 노드에 대해 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dfs(i,j)){ // 반환값이 true일 때
                    count += 1;
                }
            }
        }

        System.out.println(count);

    }

}
