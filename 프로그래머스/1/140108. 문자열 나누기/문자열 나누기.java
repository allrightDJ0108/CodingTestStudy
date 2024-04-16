class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] arr = s.split("");
        String x = arr[0];
        
        int same = 0;
        int diff = 0;
        for (int i=0; i<arr.length; i++){
            if (x.equals("")) x = arr[i];
            
            if (x.equals(arr[i])) same++;
            else diff++;
            
            if (same == diff) {
                answer++;
                same = 0;
                diff = 0;
                x = "";
            }
            
            if (i == arr.length - 1 && same != diff) answer++;
        }
        return answer;
    }
}