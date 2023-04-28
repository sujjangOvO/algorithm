package inflearn.StackANDQueue;

import java.util.Scanner;
import java.util.Stack;

// 5-4. 후위식 연산(postfix)
public class Stack4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(new Stack4().solution(str));
    }
    public int solution(String str){
        int answer = -1;
        Stack<Integer> stack = new Stack<>();

        for(char x : str.toCharArray()){
            if(Character.isDigit(x)) stack.push(x-48); // 아스키값 빼서 정수화
            else {
                int rt = stack.pop();
                int lt = stack.pop();

                switch(x){
                    case '+':
                        stack.push(lt+rt); // 연산한 값을 다시 stack에 넣어줘야 한다 !!
                        break;
                    case '-':
                        stack.push(lt-rt); // 2번째 pop한 값에서 1번째 pop한 값을 빼야한다 !! 여기서 실수 ㅜㅜ
                        break;
                    case '*':
                        stack.push(lt*rt);
                        break;
                    case '/':
                        stack.push(lt/rt);
                        break;
                }
            }
        }

        answer = stack.pop();
        return answer;
    }
}
