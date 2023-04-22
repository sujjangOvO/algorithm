package inflearn.HashmapANDTreeset;

import java.util.HashMap;
import java.util.Scanner;

// 4-4. 모든 아나그램 찾기
/*
S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
*/
public class Hashmap4 {
    public static void main(String[] args) {
        Scanner scaneer = new Scanner(System.in);
        String S = scaneer.next();
        String T = scaneer.next();
        System.out.println(new Hashmap4().solution(S, T));
    }

    // Hashmap, two pointers, sliding window, 시간복잡도 O(n) => 4가지 복합문제
    public int solution(String S, String T){
        int answer = 0;
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for(char x : T.toCharArray()){
            tmap.put(x, tmap.getOrDefault(x, 0)+1);
        }

        // sliding 하기 전 까지 미리 해둠. 이 과정을 통해 rt가 T.length()-1에서 시작함으로써 반복문을 수행할 수 있게 됨
        for(int i=0; i<T.length()-1; i++){
            smap.put(S.charAt(i), smap.getOrDefault(S.charAt(i),0)+1);
        }

        // two pointers
        int lt = 0;
        for(int rt = T.length()-1; rt < S.length(); rt++){
            smap.put(S.charAt(rt), smap.getOrDefault(S.charAt(rt),0)+1);
            if(smap.equals(tmap)) answer++; // Hashmap 객체는 equals 메소드를 통해 비교할 수 있다.

            smap.put(S.charAt(lt), smap.get(S.charAt(lt))-1); // lt 빼주고
            if(smap.get(S.charAt(lt)) == 0) smap.remove(S.charAt(lt)); // lt 값이 0이면 remove => equlas 메소드에 count 되지 않도록
            lt++;
        }

        return answer;
    }
}
