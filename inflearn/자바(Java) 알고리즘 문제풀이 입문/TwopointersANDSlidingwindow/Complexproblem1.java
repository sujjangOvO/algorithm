package inflearn.TwopointersANDSlidingwindow;

import java.util.Scanner;

public class Complexproblem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = scanner.nextInt();
        System.out.println(new Complexproblem1().solution(n, m, arr));
    }
    
    public int solution(int n, int m, int[] arr){
        int answer = 0;
        int sum = 0, lt = 0;

        for(int rt=0; rt<arr.length; rt++){
            sum += arr[rt];
            while(sum > m){
                sum -= arr[lt++];
            }
            if(sum == m) answer++;
        }
        
        /*
        for(int rt=0; rt<arr.length; rt++){
            sum += arr[rt];
            if(sum == m) answer++;
            
            while(sum > m){
                sum -= arr[lt++];
                if(sum == m) answer++;
            }
        }
        */
        
        return answer;
    }
}
