package inflearn.Str;

import java.util.Scanner;

public class Str7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toLowerCase();
        int lt = 0, rt = str.length()-1;
        String answer = "YES";

        // 문자열 길이 전체만큼 돌아야해서 시간이 더 걸림
        while(rt > lt){
            if(str.charAt(rt)!=str.charAt(lt)) {
                answer = "NO";
                break;
            }
            else{
                lt++;
                rt--;
            }
        }
        System.out.println(answer);

        // 2. 문자열 길이만큼 반복 할 필요없이 문자열 길이의 반만큼만 반복
        System.out.println(new Str7().solution(str));

        // 3. equalsIgnoreCase 메소드로 뒤집은 문자열과 원래 문자열을 비교
        System.out.println(new Str7().solution2(str));
    }

    public String solution(String str){
        int len = str.length();

        for(int i=0; i<len/2; i++){ // len-i-1 라는 규칙을 찾아야 함 !!
            if(str.charAt(i) != str.charAt(len-i-1)) return "NO";
        }

        return "YES";
    }

    public String solution2(String str){
        String temp = new StringBuilder(str).reverse().toString(); // 뒤집은 상태로 비교
        if(str.equalsIgnoreCase(temp)) return "YES"; // equalsIgnoreCase는 대소문자를 구분하지 않고 동일한지 비교하는 메소드
        else return "NO";
    }
}
