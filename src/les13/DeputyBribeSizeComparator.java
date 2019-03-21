package les13;

import java.util.Comparator;

public class DeputyBribeSizeComparator implements Comparator<Deputy>{

	@Override
	public int compare(Deputy o1, Deputy o2) {
		if (o1.getBribeSize()>o2.getBribeSize())
			return -1;
		else if (o1.getBribeSize()<o2.getBribeSize())
			return 1;
		else 
			return 0;
	}
	
	
}
