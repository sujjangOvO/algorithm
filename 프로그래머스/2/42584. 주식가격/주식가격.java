import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        List<Integer> answers = new ArrayList<>();
        
        for (int i = 0; i < prices.length; i++) {
            
            if(i == prices.length -1 ) {
                answers.add(0);
                break;
            }

            int count = 0;

            for (int j = i+1; j < prices.length; j++) {
                if(prices[i] > prices[j]){
                    answers.add(++count);
                    break;
                }
                count += 1;

                if(j == prices.length-1) answers.add(count);
            }

        }

        answer = answers.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}