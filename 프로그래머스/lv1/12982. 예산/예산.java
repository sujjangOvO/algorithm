import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int sum = 0;
        
        for(int amount : d){
            sum += amount;
            answer += 1;
            
            if(sum > budget){
                sum -= amount;
                answer -= 1;
            }
            
            
        }
        
        return answer;
    }
}