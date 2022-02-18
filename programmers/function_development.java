package programmers;

import java.util.*;

public class function_development {

    public static void main(String[] args) {

        int[] progress = {93,30,55};
        int[] speeds = {1,30,5};

        List<Integer> days = new ArrayList<>();
        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i <progress.length; i++) {
            int day = 0;
            int num = 100 - progress[i];
            if(num % speeds[i] != 0){
                day = (100-progress[i]) / speeds[i];
                day += 1;
            }
            else{
                day = (100-progress[i]) / speeds[i];
            }

            days.add(day);
            System.out.println(day);
        }

        int count = 1;
        int cur = 0;

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

        int[] answer = answers.stream().mapToInt(i -> i).toArray(); // arraylist를 배열로 전환
        for (int i = 0; i < answer.length; i++) {
            System.out.println("s["+i+"] = "+answer[i]);
        }


    }
}
