package code;

public class Assign {
	/*
	 * class Edge consists only of a pair of integers, to represent
	 * edges in a graph with vertices labelled with integers; there are
	 * corresponding get and set methods for those
	*/
	 
	private Integer city;
	private Integer assign;
	
	public Assign(Integer f, Integer s) {
		city = f;
		assign = s;
	}
	
	public Integer getCity() {
		return city;
	}

	public Integer getAssign() {
		return assign;
	}

	public void setCity(int f) {
		city = f;
	}
	
	public void setAssign(int s) {
		assign = s;
	}
}
