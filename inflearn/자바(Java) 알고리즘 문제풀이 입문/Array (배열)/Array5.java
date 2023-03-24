package inflearn.Array;

import java.util.Scanner;

public class Array5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n+1];

        // 소수(에라토스테네스 체)
        System.out.println(new Array5().solution(n, arr));
    }

    public int solution(int n, int[] arr){
        int answer = 0;

        for(int i=2; i<=n; i++){ // 0과 1은 소수가 아니므로 2부터 시작. index 번호를 n까지 사용해야 하므로 n을 포함하는 범위
            if(arr[i] == 0){
                answer++;
                for(int j=i; j<=n; j+=i){ // j는 i의 배수만큼 증가. 해당 배수는 i를 약수를 가지므로 소수가 아님이 판별된다.
                    arr[j] = 1;
                }
            }

        }

        return answer;
    }
}
