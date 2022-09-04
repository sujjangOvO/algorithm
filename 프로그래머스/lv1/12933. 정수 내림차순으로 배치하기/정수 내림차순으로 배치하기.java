import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String temp = Long.toString(n);
        Integer[] digits = new Integer[temp.length()];
        for(int i=0; i<temp.length(); i++){
            digits[i] = temp.charAt(i) - '0';
        }
        Arrays.sort(digits, Comparator.reverseOrder());
        
        for(int i=0; i<digits.length; i++) {
            answer += Long.valueOf(digits[i]);
            
            if(i == digits.length -1) break;
            answer *= 10;
        }
        
        return answer;
    }
}