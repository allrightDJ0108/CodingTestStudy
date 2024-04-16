import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
    
        int N = wallpaper.length;
        int M = wallpaper[0].length();
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        ArrayList<int[]> arr = new ArrayList<>();
        
        for (int i=0; i<N; i++){
            String wall = wallpaper[i];
            for (int j=0; j < M; j++){
                if(wall.charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        
        return new int[]{minX, minY, maxX + 1, maxY + 1};
    }
}