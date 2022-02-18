package bookStudy;

import java.util.Scanner;

public class game_develop {

    public static int n, m, x, y, d;

    // 북 동 남 서 ( 반시계 90도 방향 )
    public static int dx[] = {-1,0,1,0};
    public static int dy[] = {0,1,0,-1};

    public static int[][] mem = new int[50][50]; // 가본 위치 기록
    // 배열의 초기값으로 따로 값을 지정하지 않으면 int형의 경우 0으로 default 값이 정의된다.
    public static int[][] map = new int[50][50]; // 맵 정보


    public static void turn_left(){
        d -= 1; // 반시계 90도 방향으로 회전
        if(d == -1 ) d = 3; // d=3은 서쪽임 dx, dy의 인덱스로 이용하는 것이 d (방향)
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt(); // 공백을 기준으로 읽는다.

        x = scan.nextInt();
        y = scan.nextInt();
        d = scan.nextInt();

        mem[x][y] = 1; // 현재 위치 기록
        int count = 1; // 방문한 칸의 수 (현재 위치 포함)

       // 맵 정보 입력받기 (1은 바다, 0은 육지)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        // 기능 구현
        int turn_count = 0; // 4 방향 돌았는지 체크하기 위한 변수

        while(true){
            turn_left(); // 왼쪽 방향으로 회전 ( d값 변화 )

            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if(mem[nextX][nextY]==0 && map[nextX][nextY]==0){ // 가보지 않았고 육지
                mem[nextX][nextY] = 1; // 기록
                x = nextX;
                y = nextY;
                count += 1;
                turn_count = 0; // 초기화
                continue; // 다음 반복문으로
            }
            else{ // 가봤거나 바다
                turn_count += 1;
            }

            if(turn_count == 4){ // 4방향 모두 갈 수 없음

                nextX = x - dx[d];
                nextY = y - dy[d]; // 뒤로 (방향 유지, 그대로 빼면 기호 반대라 뒤로 가는 것임)

                if(map[nextX][nextY] != 1){ // 뒤에가 육지인 경우
                    x = nextX;
                    y = nextY;
                }
                else{
                    break; // 뒤에가 바다인 경우 움직임을 멈춘다.
                }

                turn_count = 0;
            }

        }

        System.out.println(count);

    }
}
