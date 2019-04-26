package Cinema;

import java.io.Serializable;
import java.util.TreeSet;

public class Schedule implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Time cleaningTime;	
	private TreeSet<Seance> seanceSet;
	
	public Schedule() {
		this.seanceSet = new TreeSet<Seance>();
	}
	
	public TreeSet<Seance> getSeanceSet() {
		return seanceSet;
	}

	@Override
	public String toString() {
		String schedule = "";
		for(Seance sc:seanceSet)
			schedule+="\n\t" + sc.toString();
		return "Розклад сеансів: " + schedule;
	}

	public void addSeance (Seance s) throws NotCorrectTimeException {
		
		if (!betweenSeancesCheck(s))
			throw new NotCorrectTimeException("Час сеансу перетинається з іншими сеансами або часом на прибирання!");

		seanceSet.add(s);
	}
	
	public void removeSeance (Seance s) {
		seanceSet.remove(s);
	}

	
	// Checks if the seance conflicts with other seances including cleaning time
	private boolean betweenSeancesCheck(Seance s) throws NotCorrectTimeException {
		cleaningTime= new Time(10, 0);
		if(seanceSet.floor(s)==null || (seanceSet.floor(s).getEndTime().add(cleaningTime).compareTo(s.getStartTime()) < 1)) {
				if(seanceSet.higher(s)==null || (s.getEndTime().add(cleaningTime).compareTo(seanceSet.higher(s).getStartTime()) <1))
					return true;
				else 
					return false;
		}
		else
			return false;
	}
}
