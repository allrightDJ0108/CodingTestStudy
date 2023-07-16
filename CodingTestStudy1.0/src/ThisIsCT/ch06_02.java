package ThisIsCT;

public class ch06_02 {
	//ch.06 정렬
	//삽입정렬
	//데이터가 어느정도 정렬되어 있는 경우 최고 효율
	//두번째 부터 시작, 현재 인덱스의 숫자를 어느 위치에 삽입할지 결정
	static int[] array = {7,5,9,0,3,1,6,2,4,8};
	public static void main(String[] args) {
		
		
		for (int i=0; i<array.length; i++) {
			for (int j=i; j>0; j--) {
				if (array[j] < array[j-1]) {
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				} else {
					break;
				}
				
			}
			
		}
		
		for (int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
