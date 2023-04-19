package inflearn.HashmapANDTreeset;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Hashmap2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        if(new Hashmap2().solution(str1, str2)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

        System.out.println(new Hashmap2().solution2(str1, str2));
    }

    // HashMap 객체를 1개만 선언하고 해당 해쉬맵에서 value값을 감소하는 방식으로 비교한다.
    // 객체를 2개 선언할 필요가 없어지므로 공간효율성이 높아진다.
    public String solution2(String str1, String str2){
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();

        for(char x : str1.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        for(char x : str2.toCharArray()){
            if(!map.containsKey(x) || map.get(x) == 0) return "NO"; // value가 0이면 더이상 존재하지 않는다는 의미
            map.put(x, map.get(x)-1);
        }

        return answer;
    }

    public boolean solution(String str1, String str2){
        boolean answer = true;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(char x : str1.toCharArray()){
            map1.put(x, map1.getOrDefault(x, 0)+1);
        }
        for(char x : str2.toCharArray()){
            map2.put(x, map2.getOrDefault(x, 0)+1);
        }

        // 이미 길이가 같은 두개의 단어가 주어지므로 사이즈는 비교할 필요x
        for (char key : map1.keySet()) {
            if (!map2.containsKey(key)) {
                answer = false;
                break;
            } else {
                if (map1.get(key) != map2.get(key)) {
                    answer = false;
                }
            }
        }

        return answer;
    }
}
