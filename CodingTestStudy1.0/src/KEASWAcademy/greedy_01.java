package KEASWAcademy;

import java.io.*;

public class greedy_01 {
    public static void main(String[] args) throws IOException {

        int result = 0;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        int[] firstRoute = {190, 150, 180};
        int[] secondRoute = {230, 170, 220};

        for (int i=0; i<3; i++){
            if (firstMin > firstRoute[i]){
                firstMin = firstRoute[i];
            }
            if (secondMin > secondRoute[i]){
                secondMin = secondRoute[i];
            }
        }
        
        result = firstMin + secondMin;

        System.out.printf("첫번째 최단거리 : %d, 두번째 최단거리 : %d\n", firstMin, secondMin);
        System.out.println("최단거리의 합 : "+result);
    }
}
