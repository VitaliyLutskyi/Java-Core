package les18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Map<K,V>{
	
	 int capacity = 16;
	int size=0;
	private MyEntry<?, ?>[] table = new MyEntry<?, ?> [capacity];
	private double loadFactor = 0.75;
	private int threshold;
	
	public void addEntry(K key, V value) {
		threshold = (int) (capacity*loadFactor);
		if(size>=threshold) {
			capacity*=2;
			MyEntry<?, ?>[] tableCopy =  new MyEntry<?, ?> [capacity];
			for(int i =0; i<size;i++) 
				tableCopy[i]=table[i];
			table=tableCopy;	
		}
		table[size++]=new MyEntry<K,V>(key, value);
	}
	
	public void removeByKey(K key) {
		
		for(int i=0;i<size;i++) {
			if(table[i].getKey().equals(key) || table[i].getKey()==key) {
				for(int j=i; j<size;j++) 
					table[j]=table[j+1];
				size--;
				break;
			}
		}
	}
	
	public void removeByValue(V value) {
		
		for(int i=0;i<size;i++) {
			if(table[i].getValue().equals(value) || table[i].getValue()==value)
				table[i].setValue(null);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void outputKeysSet() {
		
		Set<K> keys = new HashSet<>();
		for(int i=0;i<size;i++) 
			keys.add((K)table[i].getKey());
		System.out.println("\nSet of Keys: ");
		for (Iterator<K> iterator = keys.iterator(); iterator.hasNext();) {
			K k = iterator.next();
			System.out.println(k);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void outputValuesList() {
		
		List<V> values = new ArrayList<>();
		for(int i=0;i<size;i++) 
			values.add((V)table[i].getValue());
		System.out.println("\nList of Values: ");
		for (Iterator<V> iterator = values.iterator(); iterator.hasNext();) {
			V v = iterator.next();
			System.out.println(v);
		}
	}
	
	public void outputAllMap() {
		
		System.out.println("\nAll Map:");
		for(int i=0;i<size;i++)
			System.out.println(table[i]);
	}
}

























