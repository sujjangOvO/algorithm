package inflearn.Array;

import java.util.Scanner;

public class Array7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(new Array7().solution(n, arr));
        System.out.println(new Array7().solution2(n, arr));
    }

    // 강사님 코드
    // 1을 만나면 cnt 증가 answer에 cnt 누적, 0을 만나면 cnt 0으로 초기화
    public int solution2(int n, int[] arr){
        int answer = 0, cnt = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == 1){
                cnt++;
                answer += cnt;
            }
            else cnt = 0;
        }

        return answer;
    }

    // 내 해답
    public int solution(int n, int[] arr){
        int answer = 0, cnt = 0, cur = arr[0];
        if(arr[0] == 1) cnt+=1;

        for(int i=1; i<n; i++){
            if(arr[i] != cur) {
                answer += cnt;
                cur = arr[i];

                if(arr[i] == 1) cnt = 1;
                else cnt = 0;
            }
            else if(arr[i] != 0) {
                answer += cnt;
                cnt++;
            }
        }

        if(cur!=0) answer+=cnt;  // 마지막 배열의 숫자도 더해줘야 함

        return answer;

    }
}
