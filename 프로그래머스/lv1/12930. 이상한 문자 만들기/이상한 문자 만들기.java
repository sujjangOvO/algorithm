class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ",-1); // limit값으로 -1을 주면 공백도 배열에 들어간다!
        
        
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[i].length(); j++){
                if(j%2==0){
                    sb.append(Character.toUpperCase(words[i].charAt(j)));
                }
                else{
                    sb.append(Character.toLowerCase(words[i].charAt(j)));
                }
            }
            if(i != words.length-1) sb.append(" ");
        }
        
        //if(s.charAt(s.length()-1) == (' ')) sb.append(" ");
        
        answer = sb.toString();
        return answer;
    }
}