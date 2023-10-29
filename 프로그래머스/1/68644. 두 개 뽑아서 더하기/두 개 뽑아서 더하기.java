import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> temp = new TreeSet<>(); // TreeSet은 요소를 정렬한 상태로 넣어둠
        
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                
                if(!temp.contains(sum)) {
                    temp.add(sum);
                }
            }
        }
        
        answer = new int[temp.size()];
        int idx = 0;
        for(Integer num : temp) {
            answer[idx++] = num;
        }
        
        return answer;
    }
}