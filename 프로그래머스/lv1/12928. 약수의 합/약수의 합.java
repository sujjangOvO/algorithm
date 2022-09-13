import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int sqrt = (int)Math.sqrt(n);
        
        for(int i=1; i<=sqrt; i++){ // n만큼 돌지않고 제곱근만큼 돈다.
            if(n%i == 0){
                answer += i;
                if(n/i != i){ // ex) n이 144일때 12, 12가 들어가지 않도록 한다.
                    answer += (n/i);
                }
            }
        }
        
        return answer;
    }
}