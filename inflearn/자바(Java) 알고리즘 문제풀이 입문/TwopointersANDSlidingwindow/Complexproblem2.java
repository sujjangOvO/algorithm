package inflearn.TwopointersANDSlidingwindow;

import java.util.Scanner;


// 3-6. 최대 길이 연속부분수열
/*
0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
1 1 0 0 1 1 0 1 1 0 1 1 0 1
여러분이 만들 수 있는 1이 연속된 연속부분수열 최대 길이는 8입니다.
 */
public class Complexproblem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(new Complexproblem2().solution(n, k, arr));
    }

    // two pointer (lt, rt)
    // rt가 0을 만나면 1로 바꾼다(=cnt 증가) 이후 길이를 구한다 (rt-lt+1)
    // 만약 cnt가 k를 넘는다면 lt가 0을 만날 때 까지 증가시키고 lt가 0을 만난다면 cnt를 감소시킨다 (rt가 1로 바꾼 0을 다시 0으로 바꾼다는 개념)
    // 그리고 변한 lt값에서 다시 길이를 구해 최대 길이와 비교한다.
    public int solution(int n, int k, int[] arr){

        int answer = Integer.MIN_VALUE, lt = 0, cnt = 0, len = 0;

        for(int rt=0; rt<n; rt++){

            if(arr[rt] == 0) cnt++;
 
            while(cnt > k){ // cnt가 k보다 크다면(0->1이 횟수보다 더 많은 횟수라면) lt가 0을 만날때까지 증가하다가 0을 만나면 cnt를 감소하고 lt를 증가
                if(arr[lt++] == 0) {
                    cnt--;
                }
            }

            len = rt - lt + 1; // 증가한 lt가 있다면 증가한 lt를 기준으로 다시 길이를 측정
            answer = Math.max(answer, len);

        }

        return answer;
    }
}
