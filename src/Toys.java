
public class Toys {
	private int ID;
	private String name;
	private int count;
	private int weight;
	
	public Toys(int iD, String name, int count, int weight) {
		ID = iD;
		this.name = name;
		this.count = count;
		this.weight = weight;

	}
	public boolean isEmpty() {
		return  count<=0;
	}		
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getID() {
		return ID;
	}
	@Override
	public String toString() {
		return "Toys [ID=" + ID + ", name=" + name + ", count=" + count + ", weight=" + weight + ", isEmpty=" + isEmpty()
				+ "]";
	}
	
}
