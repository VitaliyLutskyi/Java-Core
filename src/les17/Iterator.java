package les17;

public interface Iterator {
	
	public boolean hasNext();
	public void next();
}

class Collection {
	
	private static Number[] arr;
	
	Collection(Number[] arr){
		Collection.arr = arr;
	}
	
	private class Forward implements Iterator{
		
		private int i=0;

		@Override
		public boolean hasNext() {
			
			return i<arr.length;
		}

		@Override
		public void next() {
			
			if(i%2==1)	{
				System.out.println(0);
				i++;
			}
			else
				System.out.println(arr[i++]);
		}

	}
	public Forward createForward(){
		return new Forward();
	}
	
	private class Backward implements Iterator{
		
		int i=arr.length-1;

		@Override
		public boolean hasNext() {
			
			return i>=0;
		}

		@Override
		public void next() {
			
			System.out.println(arr[i]);
			i-=2;
		}

	}
	public Backward createBackward() {
		return new Backward();
	}
	
	public Iterator createAnonymous() {
		return new Iterator() {

			private int i=arr.length-1;

			@Override
			public boolean hasNext() {
				
				return i>=0;
			}

			@Override
			public void next() {
				
				if(i%2==1)	
					System.out.println(arr[i]);
				i-=3;
			}
			
		};
	}
	
	public Iterator createLocal() {
		
		 class Local implements Iterator{
			 
			private int i=0;
			 
			@Override
			public boolean hasNext() {
				
				return i<arr.length;
			}

			@Override
			public void next() {
				
				if(i%2==0)
					System.out.println(arr[i].doubleValue()-100);
				i+=5;
			}
			
		}
		return new Local();
	}
	
	static class staticIterator implements Iterator{
		
		private int i=0;
		
		@Override
		public boolean hasNext() {
			
			return i<arr.length;
		}

		@Override
		public void next() {
			
			if(arr[i].doubleValue()%2==0) 
				System.out.println(arr[i].doubleValue()+1);
			i+=2;
		}
		
		
	}
	
}































