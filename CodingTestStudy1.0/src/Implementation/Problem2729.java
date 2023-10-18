package Implementation;

import java.io.*;
import java.util.*;

public class Problem2729 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        while (T-- > 0 ){
            StringBuilder sb = new StringBuilder();
            StringTokenizer str = new StringTokenizer(br.readLine());
            String A = str.nextToken();
            String B = str.nextToken();

            int len = 0;        //더 큰 문자열의 길이
            int diff = 0;       //두 문자열의 크기 차이
            int carry = 0;      //반올림 처리
            int remain = 0;     

            if (A.length() > B.length()){
                len = A.length();
                diff = A.length() - B.length();
                while (diff-- > 0){
                    B = '0' + B;
                }
                //System.out.println("B "+B);
            } else if(A.length() < B.length()){
                len = B.length();
                diff = B.length() - A.length();
                while (diff-- > 0 ){
                    A = '0' + A;
                }
                //System.out.println("A "+A);
            } else {
                len = A.length();
            }

            for (int i=len-1; i>=0; i--){
                int sum = (A.charAt(i) - '0') + (B.charAt(i) - '0') + carry;

                carry = sum / 2;
                remain = sum % 2;

                //System.out.printf("sum=%d carry=%d remain=%d \n", sum, carry, remain);

                sb.append(remain);

                //반올림 처리
                if (i == 0 && carry == 1){
                    sb.append(1);
                }
            }
            
            //결과에 000과 같은 경우가 담기면 처리
            char[] arr = sb.reverse().toString().toCharArray();
            int cnt = 0;
            for (int i=0; i<arr.length; i++){
                if (arr[i] == '0'){
                    cnt++;
                }
                else break;
            }

            if (cnt == arr.length){
                System.out.println(0);
            } else {
                //결과가 0으로 시작할 수 있으니 cnt부터 시작
                for (int i=cnt; i<arr.length; i++){
                    System.out.print(arr[i]);
                }
                System.out.println();
            }

        }

        
    }
}
