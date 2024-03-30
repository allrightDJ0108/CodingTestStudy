// You may use import as below.
//import java.util.*;

class Solution {
    public String solution(long num) {
        // Write code here.
        StringBuilder sb = new StringBuilder();
        long answer = num + 1;
        //System.out.println(answer);
        String str = String.valueOf(answer);
        char[] arr = str.toCharArray();
        for (char c : arr){
            if (c == '0') sb.append('1');
            else sb.append(c);
        }
        return sb.toString();
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        src.Solution sol = new src.Solution();
        long num = 9949999;
        String ret = sol.solution(num);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}
