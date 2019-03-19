package les12.arraylist;

import java.util.Arrays;

public class ArrayList {
	
	private int countOfElements;
	private Object [] array;
	
	public ArrayList() {		
		array = new Object[10];
	}
	
	public ArrayList(int size) {
		array = new Object[size];
	}

	public void add(Object element) {
		
		// If the array is full size=size*1.5+1
		if (countOfElements == array.length) {
			Object [] arrayCopy = array;
			array = new Object[(int)(countOfElements*1.5) + 1];
			for (int i=0; i<countOfElements; i++) 
				array[i]=arrayCopy[i];		
		}
		
		array[countOfElements] = element;
		countOfElements++;
	}
	
	public void remove(int index) {
		
		for(int i=index;i<countOfElements-1; i++) 
			array[i] = array[i+1];
		array[countOfElements-1] = null;
		countOfElements--;
		
		// If the array is too long size=(size-1)/1.5
		if (countOfElements < (array.length-1)/1.5) {
			Object [] arrayCopy = array;
			array = new Object[(int) ((arrayCopy.length-1)/1.5)];
			for (int i=0; i<array.length; i++) 
				array[i]=arrayCopy[i];		
		}
	}

	@Override
	public String toString() {
		Object [] arrayCopy = new Object[countOfElements];
			for (int i=0;i<countOfElements; i++)
				arrayCopy[i] = array[i];
		
		return "ArrayList=" + Arrays.toString(arrayCopy);
	}
	
	
}
