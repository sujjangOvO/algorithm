package bookStudy;

import java.util.*;

public class timeN { // 완전탐색 구혁

    public static boolean check_Three(int h, int m, int s){
        if(h%10==3 || m%10==3 || m/10==3 || s%10==3 || s/10==3)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;

        // 3중 반복문
        for (int i = 0; i <= n; i++) { // i < n 아니고 n 포함
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if(check_Three(i,j,k)) count++;
                }
            }
        }

        System.out.println(count);
    }
}
