package Softeer;

import java.util.*;
import java.io.*;

public class lv2_408 {
	public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int[] inp = new int[input.length + 1];

        for (int i=0; i<input.length; i++){
            inp[i] = Integer.parseInt(input[i]);
        }

        boolean result = false;
        int type = 0;           //0이면 mixed   1이면 오름차순 1 > 8      2이면 내림차순 8 > 1
        
        if (inp[0] == 1) type = 1;
        if (inp[0] == 8) type = 2;

        if (type > 0){
            for (int i=1; i < 8; i++){

                if (type == 1){
                    if (inp[i] == inp[i-1] + 1){
                        result = true;
                    } else {
                        result = false;
                    }
                }
                if (type == 2){
                    if (inp[i] == inp[i-1] - 1){
                        result = true;
                    } else {
                        result = false;
                    }
                }



                if (!result) break;
            }
        } 

        String res = "";
        if (!result) res = "mixed";
        else if (result && type == 1) res = "ascending";
        else if (result && type == 2) res = "descending";

        System.out.println(res);
        
    }
}

/*	연습용 테스트케이스
1 2 3 4 5 6 7 8
8 7 6 5 4 3 2 1
1 5 4 3 2 8 7 6
8 7 6 5 4 3 1 2
2 5 6 7 8 4 3 1
*/
