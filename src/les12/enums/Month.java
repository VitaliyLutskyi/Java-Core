package les12.enums;

public class Month {
	
	private String month;
	private int days;
	private Seasons season;
	public Month(String month, int days, Seasons season) {
		this.month = month;
		this.days = days;
		this.season = season;
	}
	public String getMonth() {
		return month;
	}
	public int getDays() {
		return days;
	}
	public Seasons getSeason() {
		return season;
	}
	@Override
	public String toString() {
		return "Month [month=" + month + ", days=" + days + ", season=" + season + "]";
	}
	
	
	
	
}
