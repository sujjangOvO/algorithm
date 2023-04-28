package inflearn.StackANDQueue;

import java.util.Scanner;
import java.util.Stack;

// 5-3. 크레인 인형뽑기(카카오)
public class Stack3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = scanner.nextInt();
            }
        }

        int m = scanner.nextInt();
        int[] moves = new int[m];
        for(int i=0; i<m; i++){
            moves[i] = scanner.nextInt();
        }

        System.out.println(new Stack3().solution(board, moves));
    }

    // 터트러져 사라진 인형의 갯수 출력
    public int solution(int[][] board, int[] moves){
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int pos : moves){
            for(int i=0; i<board.length; i++){
                if(board[i][pos-1] != 0){ // 인형이 존재할 때

                    int tmp = board[i][pos-1];
                    board[i][pos-1] = 0;

                    if(!stack.isEmpty() && tmp == stack.peek()){ // stack이 비어있지 않고 stack 최상단이 현재 인형과 같다면
                        answer += 2; 
                        stack.pop();
                    }
                    else{
                        stack.push(tmp);
                    }
                    break; // if문이 참이 되면 i가 더이상 증가되지 않도록 멈춰야 한다.
                }
            }
        }


        return answer;
    }
}
