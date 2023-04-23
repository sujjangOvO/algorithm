package inflearn.HashmapANDTreeset;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Hashmap5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(new Hashmap5().solution(n, k, arr));
    }

    // 3중 for문을 통해 3장을 뽑을 수 있는 모든 경우를 찾아야 한다.
    // 중복을 허용하지 않는 TreeSet 자료구조를 통해 k번째 큰 값을 찾아낸다
    public int solution(int n, int k, int[] arr){
        int answer = -1; // k번째 수가 존재하지 않으면 -1을 출력
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder()); // 내림차순 정렬

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int l=j+1; l<n; l++){
                    treeSet.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }

        int count = 0;
        for(int num : treeSet){
            count++;
            if(count == k) {
                answer = num;
                break;
            }
        }

        return answer;
    }


    // 내가 푼 거
    // 잘못 푼 점 : 3장을 뽑을 수 있는 "모든" 경우를 구해야 하는데 그렇게 하지 않고 큰 값을 정렬하여 합의 정렬을 시켜버림, 즉 문제 이해 못 함
    public int solution2(int n, int k, int[] arr){
        int answer = 0;
        TreeSet<Integer> treeSet = new TreeSet<>(((o1, o2) -> { // 내림차순 + 중복허용 TreeSet
            if(o1<o2) return 1;
            else if(o1 == o2) return 1;
            else return -1;
        }));

        for(int x:arr){
            treeSet.add(x);
        }

        int count = 0;
        for(int num : treeSet){
            count++;
            if(count >= k && count < k+3){
                answer += num;
            }
        }

        return answer;
    }
}
