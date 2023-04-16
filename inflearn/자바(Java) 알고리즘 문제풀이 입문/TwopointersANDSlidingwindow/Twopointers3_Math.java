package inflearn.TwopointersANDSlidingwindow;

import java.util.Scanner;

// 3-5. 연속된 자연수의 합(two pointers) + (수학)
public class Twopointers3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n/2+1];  // 연속된 자연수의 합중에 가장 큰 숫자는 n/2+1 이므로
        for(int i=0; i<n/2+1; i++) arr[i] = i+1;

        Twopointers3 twopointers3 = new Twopointers3();
        System.out.println(twopointers3.solution2(n));
    }

    // 수학적 방법
    public int solution2(int n){
        int answer = 0, cnt=1;
        n -= cnt;

        while(n>0){
            cnt++; // 자릿수 증가
            n -= cnt; // cnt가 연속된 자연수의갯수
            if(n % cnt == 0) answer++; // 0%cnt도 0이므로 정답으로 카운팅된다.
        }

        return answer;
    }

}
