package inflearn.Str;

import java.util.Scanner;

public class Str6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();
        String answer = "";
        for(char c:arr){
            // contains 메소드의 인자타입은 CharSequence이다. 이는 인터페이스이고 이를 구현한 클래스로는 CharBuffer, String, StringBuffer, StringBuilder 등이 있다.
            if(!answer.contains(String.valueOf(c))) answer += c;
        }

        System.out.println(answer);

        // 2. indexOf() 사용 => indexOf()에서 나오는 index가 자기 현재 위치가 다르다면 이미 앞에 중복이 있다는 것
        // indexOf 메소드는 문자열 문자중에 가장 첫번째로 나온 위치를 반환
        System.out.println(new Str6().solution(str));
    }

    public String solution(String str){
        String answer = "";

        for(int i=0; i<str.length(); i++){
            if(i == str.indexOf(str.charAt(i))) answer += str.charAt(i);
        }

        return answer;
    }
}
