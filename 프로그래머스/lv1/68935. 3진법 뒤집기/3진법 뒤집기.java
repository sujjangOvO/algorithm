import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(n>0){
            temp.add(n%3);
            n /= 3;
        }
        
        //Collections.reverse(temp);
        
        for(int i=1; i<=temp.size(); i++){
            // System.out.println((int)Math.pow(3, temp.size()-i) * temp.get(i-1));
            answer += (int)Math.pow(3, temp.size()-i) * temp.get(i-1);
        }
        return answer;
    }
}