package inflearn.SortingANDSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 6-7. 좌표 정렬
class Point implements Comparable<Point>{  // 제너릭 타입을 통해 Point 객체를 정렬

    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void print(){
        System.out.println(this.x + " " + this.y);
    }

    // 오름차순 정렬이 되기 위해서는 음수값이 리턴 (this - object)
    // 내림차순 정렬이 되기 위해서는 양수값이 리턴 (object - this)
    @Override
    public int compareTo(Point o) {
        if(this.x == o.x){ // x값이 같으면 y값으로 정렬
            return this.y - o.y; // 오름차순 정렬 (this가 작고 object가 크므로 음수 리턴)
        }
        else{
            return this.x - o.x;
        }
    }
}


public class CompareTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Point> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            list.add(new Point(x, y));
        }

        Collections.sort(list); // CompareTo 재정의한 정렬의 기준에 의해 정렬된다

        for(Point p : list){
            p.print();
        }

    }


}
