import java.io.*;
import java.util.*;

public class Main {
	
	static int N, W, L;
	static Queue<Integer> trucks = new LinkedList<>();
	static Queue<Integer> bridge = new LinkedList<>();
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(str.nextToken());
        W = Integer.parseInt(str.nextToken());
        L = Integer.parseInt(str.nextToken());
        
        str = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
        	trucks.add(Integer.parseInt(str.nextToken()));
        }
        
        for (int i=0; i<W; i++) {
        	bridge.add(0);
        }
        
        bridge();
        
    }
    
    static void bridge() {

    	int time = 0;
    	int sum = 0;
    	
    	while(!bridge.isEmpty()) {
    		time++;
    		
    		sum -= bridge.poll();
    		
    		if (!trucks.isEmpty()) {
    			if(trucks.peek() + sum <= L) {
    				sum += trucks.peek();
    				bridge.add(trucks.poll()); // 다리 위에 트럭을 올린다.
    			} else {
    				bridge.add(0);
    			}
    			
    			//System.out.println(bridge.toString());
    		}
    		
    		
    	}
    	
    	System.out.println(time);
    }
    
    
}
