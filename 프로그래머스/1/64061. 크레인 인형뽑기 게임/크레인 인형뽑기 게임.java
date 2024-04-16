import java.util.*;

class Solution {
    
    static ArrayList<Integer> list = new ArrayList<>();
    static int answer = 0;
    
    public int solution(int[][] board, int[] moves) {
        
        int N = board.length;
        
        for (int m : moves){
            int mIdx = m - 1;
            for (int i=0; i<N; i++){
                if (board[i][mIdx] != 0){
                    System.out.println("friend==="+board[i][mIdx]);
                    list.add(board[i][mIdx]);
                    same();
                    board[i][mIdx] = 0;
                    i = N+1;
                }
            }
        }
        
        return answer;
    }
    
    static void same(){
        System.out.println("list==="+list.size());
        if (list.size() >= 2){
            int last = list.size() - 1;
            int prev = last - 1;
            
            System.out.println("last/prev==="+list.get(last)+" "+list.get(prev));
            
            if (list.get(last) == list.get(prev)){
                list.remove(last);        
                list.remove(prev);   
                answer += 2;
                System.out.println("list(after)==="+list.size());
            }
        }
    }
}