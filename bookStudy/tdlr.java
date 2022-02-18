package bookStudy;

import java.util.Scanner;

public class tdlr { // 구현 문제, 상하좌우

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 공간의 크기
        scanner.nextLine(); // 버퍼 비우기(남은 엔터 nextInt 는 숫자만 받기 때문에 엔터가 남음)

        String[] plans = scanner.nextLine().split(" ");
        // next() : 공백 전까지 입력받은 문자열 리턴
        // nextLine() : enter 입력 전까지 쓴 문자열 모두 리턴

        int x = 1, y = 1; // 좌표
        String[] moveTypes = {"L","R","U","D"};
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        /*        for (int i = 0; i < plans.length; i++) {
            System.out.println("plans = "+plans[i]);
        }*/


        for (int i = 0; i < plans.length; i++) {

            int nx = -1, ny = -1;
            for (int j = 0; j < moveTypes.length; j++) {
                if(plans[i].equals(moveTypes[j])){
                    nx = x + dx[j];
                    ny = y + dy[j];
                }

                if(nx<1 || ny<1 || nx > n || ny > n) continue;

                x = nx;
                y = ny;


            }

        }

        System.out.println(x+" "+y);



    }

}
