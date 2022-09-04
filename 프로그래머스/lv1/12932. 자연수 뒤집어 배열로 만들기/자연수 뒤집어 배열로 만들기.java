import java.util.*;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        ArrayList<Long> list = new ArrayList<>(); 
        // Integer말고 Long => n범위 오버플로우 때문에
        
        while(n > 0){
            list.add((long)n % 10);
            n /= 10;
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).intValue(); // Long to int
        }
        
        return answer;
    }
}