package bookStudy;

import java.util.*;

public class knight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String location = scan.nextLine();
/*      int row = Integer.valueOf(location.charAt(1));
        int col = Integer.valueOf(location.charAt(0));*/

        int row = location.charAt(1) - '0';
        int col = location.charAt(0) - 'a' + 1;

        int[] dx = {1,-1,1,-1,-2,-2,2,2};
        int[] dy = {2,2,-2,-2,-1,1,-1,1};

        int count = 0; // 경우의 수 count

        for (int i = 0; i < dx.length; i++) { // 8가지 방향에 대해 확인
            int nextX = dx[i] + row;
            int nextY = dy[i] + col;

            if(nextX <= 8 && nextY <=8 && nextY >=1 && nextX >=1 )
                count += 1;
        }

        System.out.println(count);


    }
}
