package KMP;

import java.io.*;

public class Problem1305 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int lastPi = getLastPi(str);
        System.out.println(L - lastPi);
    }

    static int getLastPi(String str){
        int len = str.length();
        int j=0; 
        int[] pi = new int[len];

        for (int i=1; i<len; i++){
            //System.out.println(str.charAt(i));
            //System.out.println(str.charAt(j));

            while (j > 0 && str.charAt(j) != str.charAt(i)){
                j = pi[j-1];
            }

            if (str.charAt(j) == str.charAt(i)){
                pi[i] = ++j;
            }
        }
        return pi[len - 1];
    }
}