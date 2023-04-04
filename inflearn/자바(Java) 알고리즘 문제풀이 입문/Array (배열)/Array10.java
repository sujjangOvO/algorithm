package inflearn.Array;

import java.util.Scanner;

public class Array10 {

    // 강사님 전역변수 배열. 12시/3시/6시/9시 방향 => 나중에 8방향으로 대각선까지 활용 가능한 방법
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+2][n+2]; // 양 끝 모서리

        int[][] arr2 = new int[n][n]; // 강사님 배열

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i+1][j+1] = sc.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr2[i][j] = sc.nextInt(); // 강사님 배열 할당
            }
        }

        System.out.println(new Array10().solution(n, arr));

        System.out.println(new Array10().solution2(n, arr2));
    }

    // 강사님 풀이
    // 3중 for문.
    public int solution2(int n, int[][] arr2){
        int answer = 0;

        for(int i=0; i<n; i++){

            for(int j=0; j<n; j++){
                boolean flag = true;

                for(int k=0; k<4; k++){ // 4방향이라 k는 0~3

                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < n
                            && arr2[nx][ny] >= arr2[i][j]) { // and 연산은 앞에가 맞으면 뒤를 검사하기 때문에 nx, ny를 먼저 검사해줘야 한다. 이렇게 하지 않으면 boundary exception이 난다.
                                                            // 따라서 and 연산의 순서를 중요하게 작성해야 한다.
                        flag = false;
                        break;
                    }
                }

                if(flag) answer++;
            }
        }


        return answer;
    }

    // 내 풀이
    public int solution(int n, int[][] arr){
        int answer = 0;

        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(arr[i][j] > arr[i-1][j] && arr[i][j] > arr[i][j-1] &&
                     arr[i][j] > arr[i][j+1] && arr[i][j] > arr[i+1][j]) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
