import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer=0;
        
        while(n>0){ // n이 0보다 같아지거나 작아질 때까지 반복
            answer+=n%10; // n%10을 하면 n이 (71233) 첫째자리를 얻을 수 있다. 이렇게 얻은 자릿수를 계속해서 answer에 더한다.
            n/=10; // n/10을 하면 7123 즉 첫째자리가 떨어진다. 
        }

        return answer;
    }
    
}