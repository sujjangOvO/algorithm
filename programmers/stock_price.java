package programmers;

import java.util.ArrayList;
import java.util.List;

public class stock_price {

    public static int[] prices = {1,2,3,2,3};

    public static void main(String[] args) {

        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < prices.length ; i++) {

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

        int[] answer = answers.stream().mapToInt(i -> i).toArray();

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }
}
