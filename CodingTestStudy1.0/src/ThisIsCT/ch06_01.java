package ThisIsCT;

public class ch06_01 {
	//ch.06 정렬
	//선택정렬
	//다른 정렬 기법에 비해 비효율적이지만, 특정 리스트에서 가장 작은 값을 구하는 경우 유용하므로 코드에 익숙해질 것!
	static int[] array = {7,5,9,0,3,1,6,2,4,8};
	public static void main(String[] args) {
		
		
		for (int i=0; i<array.length; i++) {
			int min_index = i;
			for (int j=i; j<array.length; j++) {
				if (array[min_index] > array[j]) {
					min_index = j;
				}
				
			}
			int temp = array[i];
			array[i] = array[min_index];
			array[min_index] = temp;
			
		}
		
		for (int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
