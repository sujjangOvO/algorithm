package inflearn.Array;

import java.util.Scanner;

public class Array9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n]; // 2차원 배열 할당

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(new Array9().solution(n, arr));
    }

    public int solution(int n, int[][] arr){
        int answer = 0;
        int row = 0, col = 0, dia1 = 0, dia2 = 0;

        // 행, 열 합
        for(int i=0; i<n; i++){
            row = 0;
            col = 0;
            for(int j=0; j<n; j++){
                row += arr[i][j];
                col += arr[j][i];
            }
            answer = Math.max(answer, row);
            answer = Math.max(answer, col);
        }

        // 대각선 합
        for(int i=0; i<n; i++){
            dia1 += arr[i][i];
            dia2 += arr[i][n-i-1];
        }

        answer = Math.max(answer, dia1);
        answer = Math.max(answer, dia2);


        return answer;
    }
}
