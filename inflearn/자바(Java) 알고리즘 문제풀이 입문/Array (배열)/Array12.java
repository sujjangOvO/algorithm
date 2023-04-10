package inflearn.Array;

import java.util.Scanner;

public class Array12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(new Array12().solution(n, m, arr));
    }

    public int solution(int n, int m, int[][] arr){
        int answer = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){

                int cnt = 0;

                for(int k=0; k<m; k++){ // 배열 탐색 (테스트 횟수)

                    int pi = 0, pj = 0;

                    for(int s=0; s<n; s++){ // 배열 탐색 (학생수)
                        if(arr[k][s] == i){
                            pi = s; // i학생 등수
                        }
                        if(arr[k][s] == j){
                            pj = s; // j학생 등수
                        }

                    }

                    if(pj > pi) cnt++; // j번 학생의 등수가 i번 학생보다 아래라면 cnt

                }

                if(cnt == m) answer++; // m번 다 등수가 높다면 조건에 부합
            }
        }

        return answer;
    }
}
