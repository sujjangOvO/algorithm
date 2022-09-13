class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int[] check_arr = {0,0};

        String[] arr_s = s.split("");
        
        for(String str: arr_s){
            if(str.equals("p") || str.equals("P")){
                check_arr[0]++;
            }
            else if(str.equals("y") || str.equals("Y")){
                check_arr[1]++;
            }
        }

        if(check_arr[0] != check_arr[1]){
            answer = false;
        }
        
        return answer;
    }
}