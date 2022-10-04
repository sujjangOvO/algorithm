import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        
        // 1억 미만인 수라 이렇게 했지 n이 더 커지면 진법의 원리에 맞게 해야 함
        while(n>0){
            temp.add(n%3);
            n /= 3;
        }
        
        //Collections.reverse(temp); 어차피 뒤집혀서 들어가있기 때문에 뒤집어줄 필요가 없다.
        
        for(int i=1; i<=temp.size(); i++){
            // System.out.println((int)Math.pow(3, temp.size()-i) * temp.get(i-1));
            answer += (int)Math.pow(3, temp.size()-i) * temp.get(i-1);
        }
        return answer;
    }
}