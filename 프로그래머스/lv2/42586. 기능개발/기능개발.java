import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int count = 1;
        int cur = 0;
        
        List<Integer> days = new ArrayList<>();
        List<Integer> answers = new ArrayList<>();
        
        for (int i = 0; i <progresses.length; i++) {
            int day = 0;
            int num = 100 - progresses[i];
            
            if(num % speeds[i] != 0){
                day = (100-progresses[i]) / speeds[i];
                day += 1;
            }
            else{
                day = (100-progresses[i]) / speeds[i];
            }
            
            days.add(day);
            //System.out.println(day);
        }
        
              for (int i = 0; i < days.size()-1 ; i++) {
            
            if(days.get(i+1)>days.get(cur)){
                answers.add(count);
                count = 1;
                cur = i+1;
                //continue;
            }
            else count += 1;

            if(i+1==days.size()-1) answers.add(count);

        }
        answer = answers.stream().mapToInt(i->i).toArray();
        return answer;
    }
}