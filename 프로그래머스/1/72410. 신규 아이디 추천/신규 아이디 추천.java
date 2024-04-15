import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        //Step.1
        String step1 = new_id.toLowerCase();
        
        //Step.2
        String step2 = "";
        for (int i=0; i < step1.length(); i++){
            char c = step1.charAt(i);
            
            if ((c >= 97 && c <= 122) || (c >= 48 && c <= 57) || c == '-' || c == '_' || c == '.' ){
                step2 += c;
            } 
        }
        
        //Step.3
        String step3 = step2;
        while (step3.contains("..")){
            step3 = step3.replace("..", ".");
        }
        System.out.println(step3);
        
        String step4 = step3;
        if (step4.length() > 0){
            if (step4.charAt(0) == '.') step4 = step4.substring(1, step4.length());
            //if (step4.charAt(step4.length() - 1) == '.') step4 = step4.substring(0, step4.length() - 1);
        }
        System.out.println(step4);
        
        //Step.5
        String step5 = step4;
        if (step5.equals("")) step5 = "a";
        
        //Step.6
        String step6 = step5;
        if (step6.length() >= 16) step6 = step6.substring(0, 15);
        if (step6.charAt(step6.length() - 1) == '.') step6 = step6.substring(0, step6.length() - 1);
        
        //Step.7
        String step7 = step6;
        if (step7.length() <= 2){
            int ind = step7.length() - 1;
            while (step7.length() < 3){
                step7 += step7.charAt(ind);
            }
        }
        
        answer = step7;
        
        return answer;
    }
}