class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String[] number_split = phone_number.split("");
        
        int cnt = 1;

        for(int i=phone_number.length()-1; i>=0; i--){
            if(cnt > 4){
                number_split[i] = "*";
                
            }
            else{
                cnt += 1;
            }
        }
        
        
        answer = String.join("",number_split);
        return answer;
    }
}