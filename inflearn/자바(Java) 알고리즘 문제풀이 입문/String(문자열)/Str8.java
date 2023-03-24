package inflearn.Str;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Str8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();  // 공백 포함이라 next()로 받으면 안된다. 실수 ㄴㄴ
        str = str.replaceAll("[^a-z]",""); // 알파벳 이외의 문자들은 공백으로 변경
        System.out.println(new Str8().solution(str));
    }
    public String solution(String str){
        String answer = "YES";
        String temp = new StringBuilder(str).reverse().toString();
        if(!str.equals(temp)) answer = "NO";

        // 정규표현식 연습
        // 1. 한글로 된 문자가 꼭 포함되어야 하며 숫자가 있어도 된다
        Pattern pattern1 = Pattern.compile("^([가-힣]+[0-9]*)$");
        System.out.println(pattern1.matcher("가가").matches()); // true
        System.out.println(pattern1.matcher("가가123").matches()); // true
        System.out.println(pattern1.matcher("가가aaa").matches()); // false
        System.out.println(pattern1.matcher("aa").matches()); // false
        System.out.println(pattern1.matcher("123").matches()); // false


        // 2. 한글로 된 문자가 꼭 포함되어야 하며 숫자는 있어도 된다. (단, 숫자의 개수는 3이 최대)
        Pattern pattern2 = Pattern.compile("^([가-힣]+[0-9]{0,3})$");
        System.out.println(pattern2.matcher("히하흐").matches()); // true
        System.out.println(pattern2.matcher("히하흐123").matches()); // true
        System.out.println(pattern2.matcher("히하흐7777777").matches()); // false
        System.out.println(pattern2.matcher("히하33흐").matches()); // false

        return answer;

        /* 정규 표현식 참조
        - https://velog.io/@minji/Java-%EC%A0%95%EA%B7%9C%ED%91%9C%ED%98%84%EC%8B%9DString.replaceAll-%EB%A9%94%EC%84%9C%EB%93%9C%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EC%B9%98%ED%99%98
        - https://gh402.tistory.com/54
         */

        /* 잘못된 풀이
        int len = str.length();
        int lt = 0, rt = len-1;
        while(rt > lt){
            if(Character.isAlphabetic(str.charAt(lt)) && Character.isAlphabetic(str.charAt(rt))) {
                if(str.charAt(lt) != str.charAt(rt)) {
                    answer = "NO";
                    break;
                }
            }
            lt++;
            rt--;
        }
        */
    }
}
