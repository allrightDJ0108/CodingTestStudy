package KEASWAcademy;

import java.util.*;

public class greedy_02 {
    public static void main(String[] args) {
        int[][] courses = {{4, 8}, {3, 5}, {2, 4}, {1, 4}, {8, 10}, {6, 8}, {5, 7}, {4, 5}, {5, 8}, {9, 11}};

        //수업 시간 정렬 : 시작시간 오름차순
        Arrays.sort(courses, new Comparator<int[]>() {
            public int compare (int[] o1, int[] o2){
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int lastEnd = Integer.MIN_VALUE;
        ArrayList<int[]> result = new ArrayList<>();

        for (int[] course : courses){
            int start = course[0];
            int end = course[1];

            //현재 선택된 수업이 종료된 후 시작하는 수업 선택
            if (start > lastEnd){
                lastEnd = end;
                result.add(new int[]{start, end});
            }
        }

        System.out.println("[ 최대로 수강 가능한 수업] ");
        for (int[] temp : result){
            System.out.println("["+temp[0]+","+ temp[1]+"]");
        }
        
    }
}





