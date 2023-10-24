import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> count = new HashMap<>();
        
        answer[0] = -1; // 첫 단어는 무조건 -1
        count.put(s.charAt(0), 0); // 첫 단어 넣고 인덱스 값 넣고
        
        for(int index=1; index<s.length(); index++) { // 두번째 단어부터 진행
            
            char c = s.charAt(index);
            
            if(count.containsKey(c)) { // count된 적 있는 단어
                answer[index] = index - count.get(c); // 현재 인덱스 - 가장 최근에 count된 인덱스
                count.put(c, index); // 다시 인덱스 카운트
            } else {
              answer[index] = -1;  // 처음 나오는 단어이므로 -1
              count.put(c, index); // 이제 count 시작
            }
            
        }
        
        return answer;
    }
}