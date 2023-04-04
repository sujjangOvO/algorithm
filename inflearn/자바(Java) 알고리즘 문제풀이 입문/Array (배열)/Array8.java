package inflearn.Array;

import java.util.Scanner;

public class Array8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for(int i=0; i<n; i++){
            scores[i] = sc.nextInt();
        }

        Array8 array8 = new Array8();
        for(int x : array8.solution(n, scores)){
            System.out.print(x + " ");
        }

    }

    public int[] solution(int n, int[] scores){
        int[] answer = new int[n];

        for(int i=0; i<n; i++){
            int cnt = 1;

            for(int j=0; j<n; j++){
                if(scores[j] > scores[i]) cnt++;
            }

            answer[i] = cnt;
        }

        return answer;
    }
}
