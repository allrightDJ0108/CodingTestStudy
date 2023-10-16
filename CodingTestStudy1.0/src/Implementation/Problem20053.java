package Implementation;

import java.io.*;
import java.util.*;

public class Problem20053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            int N = Integer.parseInt(br.readLine());
            str = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i=0; i<N; i++){
                int temp = Integer.parseInt(str.nextToken());

                if (max < temp) max = temp;
                if (min > temp) min = temp;
            }

            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.println(sb);

    }
}
