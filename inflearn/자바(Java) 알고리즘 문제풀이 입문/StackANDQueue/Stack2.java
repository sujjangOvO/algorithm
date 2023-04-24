package inflearn.StackANDQueue;

import java.util.Scanner;
import java.util.Stack;

// 5-2. 괄호문자제거
public class Stack2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(new Stack2().solution(s));
    }

    // 강사님 풀이
    // 문자를 다 넣고 ')'가 '('를 만날때 까지 계속 pop() 진행 후 남은 문자를 get하여 answer에 더한다
    public String solution2(String s){
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char x : s.toCharArray()){
            if(x == ')'){
                while(stack.pop() != '(');
            }
            else stack.push(x);
        }

        for(int i=0; i<stack.size(); i++)
            answer += stack.get(i);

        return answer;
    }

    // 내 풀이
    public String solution(String s){
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char x:s.toCharArray()){
            if(x == '(') stack.push(x);
            else if(x == ')'){
                if (!stack.empty()) stack.pop(); // 해당 문제는 괄호가 무조건 성립하므로 해당 조건문이 필요없긴 하다.
            }
            else{
                if(stack.empty()) answer.append(x);
            }
        }

        return answer.toString();
    }
}
