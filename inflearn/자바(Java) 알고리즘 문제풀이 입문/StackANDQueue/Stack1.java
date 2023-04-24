package inflearn.StackANDQueue;

import java.util.Scanner;
import java.util.Stack;

public class Stack1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(new Stack1().solution(s));
    }

    public String solution(String s){
        String answer = "NO";
        Stack<Character> stack = new Stack<>();

        if(s.charAt(s.length()-1) == '(') return answer;

        for(char x : s.toCharArray()){
            if(x == '(') stack.push('(');
            else {
                // runtime error 발생 => stack이 비어있을 때 pop을 하게됨. 이를 해결하기 위해 stack이 비어있는지 확인 필요
                if(!stack.empty()) stack.pop();
                else return answer;
            }
        }

        // 또는 try catch(EmptyStackException e)를 통해 예외처리 할 수도 있다.

        if(stack.empty()) answer = "YES";

        return answer;
    }
}
