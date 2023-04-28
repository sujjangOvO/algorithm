package inflearn.StackANDQueue;

import java.util.Scanner;
import java.util.Stack;

// 5-5. 쇠막대기
public class Stack5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(new Stack5().solution(str));
    }
    public int solution(String str){
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){ // ')' 앞이 ')' 인지 확인하기 위해 foreach문이 아닌 for문으로 index에 접근한다. charAt(i-1)을 활용 !
            if(str.charAt(i)== '('){
                stack.push('(');
            }
            else{
                if(!stack.empty()){
                    stack.pop();
                    if(str.charAt(i-1) == '(') answer += stack.size(); // 레이저 => '()' 일때 check
                    else answer++; // 막대기의 끝 => '))' 일때  check
                }
            }
        }
        return answer;
    }
}
