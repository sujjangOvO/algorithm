package inflearn.SortingANDSearching;

import java.util.Arrays;
import java.util.Scanner;

// 6-10. 마구간 정하기(결정알고리즘)
// lt와 rt는 두 말의 거리가 될 수 있는 범위를 나타낸다. 즉 이 사이에 값이 있으므로 결정알고리즘 적용
// 거리는 1부터 가장 멀리 있는 말의 좌표부터 좁혀나간다
public class DecisionAlgorithm2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(new DecisionAlgorithm2().solution(n, c, arr));

    }

    public int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr); // 이분검색은 정렬이 되어있어야 한다
        int lt = 1; // 가장 작은 거리인 1부터 시작, arr[0]부터 시작하면 안된다. "거리"를 찾는 문제이기에 1부터 시작

        //int rt = Arrays.stream(arr).max().getAsInt();
        int rt = arr[n-1]; // 이미 정렬했으므로 끝의 숫자가 가장 큰 숫자

        while(lt <= rt){
            int mid = (lt + rt) / 2;

            if(count(arr, mid) >= c){  // mid라는 거리로 있다면 배치할 수 있는 말의 수가 주어진 말의 수 보다 크다면
                answer = mid;
                lt = mid + 1; // 거리를 넓혀서 다시 해보자
            }
            else{
                rt = mid - 1; // 거리가 너무 넓어서 주어진 말의 수를 충족 X => 거리를 좁혀서 다시 해보자
            }
        }

        return answer;
    }

    // 결정알고리즘은 count와 같은 유효성검사하는 메소드를 작성하는 것이 중요하다
    public int count(int[] arr, int dis){
        int cnt = 1; // 말의 수 (적어도 1마리는 배치되므로 1부터 시작)
        int endPoint = arr[0];

        for(int i=1; i<arr.length; i++){
            if(arr[i] - endPoint >= dis){ // 처음 말과 현재 말의 거리가 주어진 거리를 충족한다면
                cnt++; // 말의 수를 추가하고
                endPoint = arr[i]; // 거리 기준을 현재 말로 교체한다
            }
        }

        return cnt;
    }

}
