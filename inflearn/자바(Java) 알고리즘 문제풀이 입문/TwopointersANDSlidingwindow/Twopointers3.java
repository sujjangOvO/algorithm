package inflearn.TwopointersANDSlidingwindow;

import java.util.Scanner;

public class Twopointers3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n/2+1];
        for(int i=0; i<n/2+1; i++) arr[i] = i+1;

        Twopointers3 twopointers3 = new Twopointers3();
        System.out.println(twopointers3.solution(n, arr));
    }

    public int solution(int n, int[] arr){
        int answer = 0;
        int lt = 0, sum = 0;

        // lt와 rt로 연속된 수열을 구하는 문제
        for(int rt=0; rt<arr.length; rt++){

            sum += arr[rt];
            if(sum == n) answer++;

            while (sum >= n){ // sum이 n보다 커진다면 lt값을 빼면서 lt를 증가시키며 n값과 작아질때 까지 반복 ( n값과 같으면 if문에 걸려서 answer count )
                sum -= arr[lt++];
                if(sum == n) answer++;
            }

        }
        return answer;
    }
}
