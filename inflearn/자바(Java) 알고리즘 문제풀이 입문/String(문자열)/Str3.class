package inflearn;

import java.util.Scanner;

public class Str3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String answer = "";

        // 1. split 메소드 사용 방법
        String[] strArr = str.split(" "); // 공백을 기준으로 자름
        int len = Integer.MIN_VALUE;

        for(String s:strArr){
            if(s.length() > len){
                len = s.length();
                answer = s;
            }
        }

        System.out.println(answer);

        // 2. indexOf, subString 사용 방법
        Str3 str3 = new Str3();
        System.out.println(str3.solution(str));
    }

    public String solution(String str){
        String answer = "";
        int min = Integer.MIN_VALUE, pos;

        while((pos = str.indexOf(" "))!= -1){ // 띄어쓰기를 발견하지 못하면 indexOf는 -1을 return. "it is time to study"에서는 pos가 2로 return
            String tmp = str.substring(0, pos); // 0번부터 pos-1 까지 잘라내라.
            int len = tmp.length();

            if(len > min){ // >=는 사용X, 같은 길이중 가장 앞쪽에 위치한 단어를 답으로 해야 하므로
                answer = tmp;
                min = len;
            }

            str = str.substring(pos+1); // "is time to study"가 된다
        }

        if(str.length() > min) answer = str; // 마지막 단어 처리 필요. 마지막 단어는 pos가 -1 이므로

        return answer;
    }
}
