package inflearn.TwopointersANDSlidingwindow;

import java.util.Scanner;

public class Slidingwindow1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        Slidingwindow1 slidingwindow1 = new Slidingwindow1();
        System.out.println(slidingwindow1.solution(n, k, arr));

    }

    public int solution(int n, int k, int[] arr){

        int sum = 0;
        for(int i=0; i<k; i++) sum += arr[i];
        int answer = sum;

        for(int i=k; i<n; i++){ // 시간복잡도 O(n)
            sum = sum + arr[i] - arr[i-k]; // sum += (arr[i] - arr[i-k])

            answer = Math.max(answer, sum);
            // if(sum > answer) answer = sum;
        }

        /*

        풀이방법은 똑같이했는데 코드를 이상하게 짰네 ,,

        int answer = Integer.MIN_VALUE;
        int p1 = 0;
        int sum = 0;

        while(p1<n){

            if(p1%k == 0 && p1 != 0){
                int temp = sum - arr[p1-k] + arr[p1++];
                if(sum > temp){
                    if(sum > answer){
                        answer = sum;
                        sum = 0;
                    }
                }
                else{
                    if(temp > answer){
                        answer = temp;
                        sum = 0;
                    }
                }
            }

            else sum += arr[p1++];
        }
        */


        return answer;
    }
}
