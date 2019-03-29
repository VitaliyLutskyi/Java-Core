package les17;

public class Main {

	public static void main(String[] args) {
		
		Number arr[] = {23, 3.69, -18, 45.2222, 129, 63.02, -14, 25.30, 127, 100, 23.23, -100};
		
		Collection collection = new Collection(arr);
		
		Iterator iterator1 = collection.createForward();
		while(iterator1.hasNext())
			iterator1.next();
		
		System.out.println();
		Iterator iterator2 = collection.createBackward();
		while(iterator2.hasNext())
			iterator2.next();
		
		System.out.println();
		Iterator iteratorAnonymous = collection.createAnonymous();
		while(iteratorAnonymous.hasNext())
			iteratorAnonymous.next();
		
		
		System.out.println();
		Iterator iteratorLocal = collection.createLocal();
		while(iteratorLocal.hasNext())
			iteratorLocal.next();
		
		System.out.println();
		Iterator iteratorStatic = new Collection.staticIterator();
		while(iteratorStatic.hasNext())
			iteratorStatic.next();
		
		
		
		
		
		
	}

}
