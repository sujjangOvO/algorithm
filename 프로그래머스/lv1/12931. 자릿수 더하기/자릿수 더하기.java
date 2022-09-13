import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String str = Integer.toString(n);
        String[] strs = str.split("");
        for(int i=0; i<strs.length; i++){
            answer += Integer.parseInt(strs[i]);
        }
        

        return answer;
    }
}