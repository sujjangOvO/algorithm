package inflearn.SortingANDSearching;

import java.util.Scanner;

// 6-4. LRU(캐시, 카카오 변형)
// 삽입정렬 응용! , ArrayList 이용 X
public class LRU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int[] jobs = new int[n];
        for(int i=0; i<n; i++){
            jobs[i] = scanner.nextInt();
        }
        new LRU().solution(s, n, jobs);
    }

    public void solution(int s, int n, int[] jobs){
        int[] cache = new int[s];

        for(int x : jobs){
            int hit = 0;

            for(int i=0; i<s; i++){  // 3<=s<=10 이므로 ㄱㅊ음
                if(cache[i] == x) {
                    hit = i;
                    break;
                }
            }

            if(hit != 0){ // hit
                for(int i=hit; i>=1; i--){  // hit난 부분부터 1번째 인덱스까지 감소하면서 한 칸씩 값을 미룬다
                    cache[i] = cache[i-1];
                }
            }
            else{ // miss
                for(int i=s-1; i>=1; i--){
                    cache[i] = cache[i-1]; // hit가 안났다면 맨 뒤에서 부터 1번째 인덱스까지 감소하면서 한 칸씩 값을 미룬다
                }
            }
            cache[0] = x;  // 0번째는 항상 현재 작업
        }

        for(int i=0; i<s; i++) System.out.print(cache[i] + " ");
    }
}
