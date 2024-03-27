import java.io.*;
import java.util.*;

public class Problem2607 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String first = br.readLine();

        int result = 0;

        for (int i=0; i<N-1; i++){
            String next = br.readLine();
            int cnt = 0;
            int[] chars = new int[26];

            for (int j=0; j<first.length(); j++){
                int index = first.charAt(j) - 'A';
                chars[index] += 1;
            }

            for (int j=0; j<next.length(); j++){
                int index = next.charAt(j) - 'A';

                if (chars[index] > 0){
                    cnt++;
                    chars[index]--;
                }
            }

            if (first.length() == next.length() && (cnt == first.length() || cnt == first.length() - 1)){
                result++;
            }
            // 비교하는 문자열이 더 짧은 경우
            else if (first.length() == next.length() + 1 && cnt == next.length() ){
                result++;
            }
            // 비교하는 문자열이 더 긴 경우
            else if (first.length() == next.length() - 1 && cnt == next.length() - 1){
                result++;
            }
        }

        System.out.println(result);

    }



}