package code;

public class Road {
	/*
	 * class Road consists only of a pair of integers, to represent
	 * roads between towns; there are
	 * corresponding get and set methods for those
	*/
	 
	private Integer city1;
	private Integer city2;
	
	public Road(Integer f, Integer s) {
		city1 = f;
		city2 = s;
	}
	
	public Integer getCity1() {
		return city1;
	}

	public Integer getCity2() {
		return city2;
	}

	public void setCity1(int f) {
		city1 = f;
	}
	
	public void setCity2(int s) {
		city2 = s;
	}
}
