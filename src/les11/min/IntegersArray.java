package les11.min;

import java.util.Arrays;
import java.util.Random;

public class IntegersArray {
	public static void main(String[] args) {
		
		int [] arr = new int[10];
		Random r = new Random();
		
		for(int i=0;i<arr.length;i++)
			arr[i]=r.nextInt(1000);
		
		System.out.println("����� �� ����������: \n" + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("����� ���� ����������: \n" + Arrays.toString(arr));
		
//		Arrays.sort(arr , Collections.reverseOrder());

		
	}
}
