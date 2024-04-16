class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] arr = s.split("");
        String x = arr[0];
        
        int same = 0;
        int diff = 0;
        for (int i=0; i<arr.length; i++){
            // x를 분리된 문자열의 첫 글자로 지정
            if (x.equals("")) x = arr[i];
            
            if (x.equals(arr[i])) same++;
            else diff++;
            
            if (same == diff) {
                answer++;
                // 기존 변수들을 초기화
                same = 0;
                diff = 0;
                x = "";
            }

            // 문자열을 나누기 전에 종료되면 마지막 문자열을 개수에 포함시킴
            if (i == arr.length - 1 && same != diff) answer++;
        }
        return answer;
    }
}
