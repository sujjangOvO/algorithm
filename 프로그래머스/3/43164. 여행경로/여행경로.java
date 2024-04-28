import java.util.*;

class Solution {
    
    static boolean[] visited;
    static List<String> route = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(route);

        return route.get(0).split(" ");
    }
    
    public void dfs(int depth, String now, String path, String[][] tickets) {
        if(depth == tickets.length) {
            route.add(path);
            return;
        } else {
            for(int i=0; i<tickets.length; i++) {
                if(!visited[i] && now.equals(tickets[i][0])) {
                    visited[i] = true;
                    dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                    visited[i] = false;
                }
            }
        }
    }
}