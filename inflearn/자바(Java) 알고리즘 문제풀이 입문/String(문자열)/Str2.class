package inflearn;

import java.util.Scanner;

public class Str2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        String str = scanner.next();
        for(char ch:str.toCharArray()){
            answer += Character.isUpperCase(ch)
                    ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
                    // ch가 대문자라면 소문자로 바꿔서 answer에 연산, ch가 대문자가 아니라면 대문자로 바꿔서 answer에 연산
        }
        System.out.println(answer);
    }
}
