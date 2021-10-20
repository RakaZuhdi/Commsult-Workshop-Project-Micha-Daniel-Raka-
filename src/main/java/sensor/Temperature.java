package sensor;

public class Temperature {
	private int temperature;
	private int max;
	private int min;

	public Temperature(int min, int max) {
		this.temperature = (int) ((Math.random() * (max - min)) + min);
		this.max = max;
		this.min = min;
	}
	
	public int getInfo() {
		this.temperature = (int) ((Math.random() * (max - min)) + min);
		return this.temperature;
	}
	
	public void print() {
		StringBuffer string = new StringBuffer();
		string.append(this.temperature).append(" C");
		System.out.println(string);
	}
	
	
}
