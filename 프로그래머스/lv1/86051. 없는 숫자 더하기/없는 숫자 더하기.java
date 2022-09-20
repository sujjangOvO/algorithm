import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] checkNum = new boolean[10];
        Arrays.sort(numbers);
        
        for(int num:numbers){
            if(!checkNum[num]){
                checkNum[num] = true;
            }
        }
   
        for(int i=0; i<10; i++){
            if(!checkNum[i]) answer += i;
        }
        
        return answer;
    }
}