package JavaExample;

import java.io.*;
import java.util.*;

public class Sorting {
    public static void main(String[] args) throws IOException {
        int[][] arr1 = {{3,5}, {4,2}, {3,4}};
        int[][] arr2 = {{3,5}, {4,2}, {3,4}};
        int[][] arr3 = {{3,5}, {4,2}, {3,4}};
        int[][] arr4 = {{3,5}, {4,2}, {3,4}};


        Arrays.sort(arr1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) 
                    return o1[1] - o2[1];
                else 
                    return o1[0] - o2[0];
            }
        });

        Arrays.sort(arr2, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            else 
                return o1[0] - o2[0];
        });

        Arrays.sort(arr3, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                else 
                    return o2[0] - o1[0];
            }
        });

        Arrays.sort(arr4, (o1,o2) -> {
            if (o1[0] == o2[0])
                return o2[1] - o1[1];
            else
                return o2[0] - o1[0];
        });

        for (int[] temp : arr1){
        System.out.println("Sorted arr1[]: " + Arrays.toString(temp));
        }

        for (int[] temp : arr2){
        System.out.println("Sorted arr2[]: " + Arrays.toString(temp));
        }

        for (int[] temp : arr3){
        System.out.println("Sorted arr3[]: " + Arrays.toString(temp));
        }

        for (int[] temp : arr4){
        System.out.println("Sorted arr4[]: " + Arrays.toString(temp));
        }

        
    }

    
}
