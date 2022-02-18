package bookStudy;

import java.util.ArrayList;

public class dfs_bfs {

    public static final int INF = 999999999;

    // 2차원 리스트를 이용해 인접 행렬 표현
    public static int[][] graph_list = {
            {0,7,5},
            {7,0,INF},
            {5,INF,0}
    };


    public static int factorialItrative(int n) // 반복문 팩토리얼
    {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result ;
    }

    public static int factorialRecursive(int n){
        if( n <= 1){
           return 1;
        }
        return n * factorialRecursive(n-1);
    }

    public static void main(String[] args) {
        // 팩토리얼
        System.out.println("반복 팩토리얼 : " +  factorialItrative(5));
        System.out.println("재귀 팩토리얼 : " +  factorialRecursive(5));

        // 행이 3개인 인접 리스트 표현
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<Node>()); // 그래프 초기화
        }

        graph.get(0).add(new Node(1,7));
        graph.get(0).add(new Node(2,5));

        graph.get(1).add(new Node(0,7));

        graph.get(2).add(new Node(0,5));

        for (int i = 0; i <3; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                graph.get(i).get(j).show();
            }
            System.out.println();
        }

    }

}

class Node{
    private int index;
    private int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    public void show(){
        System.out.println("("+this.index+","+this.cost+")");
    }
}

