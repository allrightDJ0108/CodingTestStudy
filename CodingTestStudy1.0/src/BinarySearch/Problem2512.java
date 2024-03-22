package BinarySearch;

import java.util.*;
import java.io.*;

public class Problem2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        StringTokenizer str = new StringTokenizer(br.readLine());

        int min = 0;
        int max = Integer.MIN_VALUE;

        for (int i=0; i<N; i++) {
            num[i] = Integer.parseInt(str.nextToken());
            max = Math.max(max, num[i]);
        }

        int M = Integer.parseInt(br.readLine());


        while (min <= max) {
            int mid = (min + max) / 2;

            int sum = 0;
            for (int i=0; i<N; i++) {
                if (num[i] >= mid) sum += mid;
                else sum += num[i];
            }

            System.out.println(sum + " " + mid);

            if (sum <= M) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(max);

    }
}