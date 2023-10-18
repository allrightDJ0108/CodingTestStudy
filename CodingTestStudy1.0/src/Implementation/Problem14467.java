package Implementation;

import java.io.*;
import java.util.StringTokenizer;

public class Problem14467 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[11];
        int cnt = 0;
        StringTokenizer str;
        for (int i=1; i<=10; i++){
            arr[i] = 2;
        }
        for (int i=1; i<=N; i++){
            str = new StringTokenizer(br.readLine());
            int ind = Integer.parseInt(str.nextToken());
            int yn = Integer.parseInt(str.nextToken());
            
            if (arr[ind] == 0 && yn == 1){
                cnt++;
            }
            if (arr[ind] == 1 && yn == 0){
                cnt++;
            }

            arr[ind] = yn;
        }

        System.out.println(cnt);
    }
}
