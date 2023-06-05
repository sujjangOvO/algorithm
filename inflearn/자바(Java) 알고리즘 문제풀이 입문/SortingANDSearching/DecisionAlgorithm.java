package inflearn.SortingANDSearching;

import java.util.Arrays;
import java.util.Scanner;

// 6-9. 뮤직비디오(결정알고리즘)
// 결정알고리즘은 lt, rt 사이에 답이 있음을 확신할 수 있을 때 사용한다. !!
// 결정알고리즘은 이분검색 기반이다. 즉, 정렬이 되어있어야 한다.
// 이번 강의에서는 stream을 이용해서 배열의 max값과 sum값을 구할 수 있다
public class DecisionAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(new DecisionAlgorithm().solution(n, m, arr));
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt(); // ★★ 배열의 가장 큰 값. getAsInt() 메소드를 통해 optional int를 int형으로 변환
        int rt = Arrays.stream(arr).sum(); // sum은 기본형을 return하므로 getAsInt 메소드가 필요없다

        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if(count(arr, mid) <= m){
                answer = mid;
                rt = mid - 1;
            }
            else{
                lt = mid + 1; // 용량이 부족하므로 용량을 늘린다
            }
        }

        return answer;
    }

    // capcity가 dvd 1장 용량. 1장 용량으로 몇개의 DVD가 필요한지 return
    public int count(int[] arr, int capacity){
        int cnt = 1; // DVD 장수
        int sum = 0;

        for(int x : arr){
            if(sum + x > capacity){
                cnt++;
                sum = x; // 새로운 DVD에 녹음 시작
            }
            else{ // 용량이 크지않다면 계속 추가
                sum += x;
            }
        }

        return cnt;
    }
}
