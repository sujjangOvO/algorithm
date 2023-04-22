package inflearn.HashmapANDTreeset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// 4-3. 매출액의 종류(Hash, sliding window)
/*
현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를 각 구간별로 구하라고 했습니다.
만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
20 12 20 10 23 17 10
각 연속 4일간의 구간의 매출종류는
첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별 매출액의 종류를 출력하는 프로그램을 작성하시오.
*/
public class Hashmap3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        for(int x:new Hashmap3().solution(n, k, arr)){
            System.out.print(x+" ");
        }
    }

    // sliding window, two pointer, hashmap 복합문제
    public ArrayList<Integer> solution(int n, int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<k-1; i++){ // k-1전까지 미리 구해둔다.
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        int lt = 0;
        for(int rt = k-1; rt<n; rt++){ // rt는 k-1부터 시작한다.
            map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
            answer.add(map.size()); // size가 key의 종류

            map.put(arr[lt], map.get(arr[lt])-1);
            if(map.get(arr[lt]) == 0) map.remove(arr[lt]); // value가 0이면 size에 카운팅되지 않도록 remove 해줘야 한다
            lt++;
        }

        return answer;
    }
}
