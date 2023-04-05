package inflearn.Array;

import java.util.Scanner;

public class Array11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][5];

        for(int i=0; i<n; i++){
            for(int j=0; j<5; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(new Array11().solution(n, arr));

    }

    public int solution(int n, int[][] arr){
        int answer = 0;
        int[] score = new int[n];

        for(int i=0; i<n-1; i++){
            for(int k=i+1; k<n; k++){
                for(int j=0; j<5; j++){
                    if(arr[i][j] == arr[k][j]){
                        score[i]++;
                        score[k]++;
                        break; // break가 없어서 연산이 안 됐었음
                        // break가 필요한 이유는 만약 4번 학생과 3번 학생을 비교할 때 2번 카운트하게 되므로 (2학년, 3학년이 같아서) 잘못된 값이 발생
                        // 따라서 같으면 한 번만 count하고 다음 학생으로 넘어가야 한다.
                    }
                }
            }
        }

        int max_num = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(score[i] > max_num){
                answer = i+1;
                max_num = score[i];
            }
        }


        return answer;
    }
}
