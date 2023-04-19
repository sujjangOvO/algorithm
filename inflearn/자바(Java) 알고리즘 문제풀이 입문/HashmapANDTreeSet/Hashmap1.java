package inflearn.HashmapANDTreeset;

import java.util.HashMap;
import java.util.Scanner;

public class Hashmap1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(new Hashmap1().solution(n, str)); // 내가 푼 방법
        System.out.println(new Hashmap1().solution2(n, str)); // hashmap 사용 방법
    }

    public char solution2(int n, String str){
        char answer = ' ';
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(char x : str.toCharArray()){
            hashMap.put(x,hashMap.getOrDefault(x, 0)+1); // 처음에 키 값이 없을수도 있으므로 getOrDefalut 메소드 사용 !!!
        }

        int max = Integer.MIN_VALUE;
        for(char key : hashMap.keySet()){
            if(hashMap.get(key) > max) {
                max = hashMap.get(key);
                answer = key;
            }
        }

        System.out.println(hashMap.containsKey('A')); // true
        System.out.println(hashMap.containsKey('H')); // false

        System.out.println(hashMap.size()); // key의 갯수, 5

        System.out.println(hashMap.remove('A')); // key 'A' 삭제

        return answer;
    }

    public char solution(int n, String str){
        int[] arr = new int[5];
        char answer = ' ';

        for(int i=0; i<n; i++){
            char x = str.charAt(i);
            switch (x){
                case 'A': arr[0]++; break;
                case 'B': arr[1]++; break;
                case 'C': arr[2]++; break;
                case 'D': arr[3]++; break;
                case 'E': arr[4]++; break;
            }
        }

        int max = Integer.MIN_VALUE;
        int idx = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max) {
                max=arr[i];
                idx = i;
            }
        }

        switch (idx){
            case 4: answer = 'E'; break;
            case 3: answer = 'D'; break;
            case 2: answer = 'C'; break;
            case 1: answer = 'B'; break;
            case 0: answer = 'A'; break;
        }

        return answer;
    }
}
