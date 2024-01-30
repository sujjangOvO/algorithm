class Solution {
    public String solution(String new_id) {
        
        new_id = new_id.toLowerCase(); // 1단계
        
        new_id = new_id.replaceAll("[~!@#$%^&*()=+\\[{\\]}:?,<>/]", ""); // 2단계
        
        new_id = new_id.replaceAll("\\.{2,}", "."); // 3단계
        
        new_id = new_id.replaceFirst("^\\.", ""); // 4단계
        new_id = new_id.replaceFirst("\\.$", "");
        
        if(new_id.isBlank()) // 5단계
            new_id += "a";
        
        if(new_id.length() > 15) { // 6단계
            new_id = new_id.substring(0, 15);
            
            if(new_id.endsWith(".")) {
                new_id = new_id.replaceFirst("\\.$", "");
            }
        }
        
        if(new_id.length() < 3) { // 7단계
            String ch = String.valueOf(new_id.charAt(new_id.length()-1));

            while(new_id.length() < 3) {
                new_id += ch;
            }
        }
        
        return new_id;
    }
}