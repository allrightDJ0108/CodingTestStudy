package Greedy;

import java.io.*;
import java.util.*;

public class Problem1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        char[] arr = S.toCharArray();

        int countOne = 0;
        int countZero = 0;

        if (arr[0] == '1') countOne++;
        else countZero++;


        for (int i=1; i<arr.length; i++){
            if (arr[i-1] != arr[i]){
                if (arr[i] == '1') countOne++;
                else countZero++;
            }

        }

        int result = Math.min(countOne, countZero);
        System.out.println(result);
    }
}