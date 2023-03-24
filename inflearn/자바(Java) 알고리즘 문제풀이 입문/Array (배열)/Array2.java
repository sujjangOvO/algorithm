package inflearn.Array;

import java.util.Scanner;

public class Array2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(new Array2().solution(n, arr));
    }

    public int solution(int n, int[] arr){
        int answer = 1; // 처음 한명은 무조건 보이므로
        int max = arr[0];

        for(int i=1; i<n; i++){
            if(arr[i] > max){
                answer++;
                max = arr[i];
            }
        }

        return answer;
    }
}
