package inflearn.Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = sc.nextInt();
        }

        for(int x:new Array1().solution(n, num)){
            System.out.print(x+" ");
        }


        // 내 풀이 방법
        System.out.print(num[0]+" "); // 첫번째 수는 무조건 출력

        for(int i=1; i<n; i++){
            if(num[i] > num[i-1]) System.out.print(num[i]+" ");
        }
    }

    // 강사님 풀이방법
    public ArrayList<Integer> solution(int n, int[] num){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(num[0]);

        for(int i=1; i<n; i++){
            if(num[i] > num[i-1]) answer.add(num[i]);
        }

        return answer;
    }
}
