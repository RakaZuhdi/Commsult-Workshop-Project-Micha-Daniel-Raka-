package sensor;

public class Wind {
	private int windSpeed;
	private int max;
	private int min;

	public Wind(int min, int max) {
		this.windSpeed = (int) ((Math.random() * (max - min)) + min);
		this.max = max;
		this.min = min;
	}
	
	public void update() {
		this.windSpeed = (int) ((Math.random() * (max - min)) + min);
	}
	
	public int getInfo() {
		return this.windSpeed;
	}
	
	public void print() {
		StringBuffer string = new StringBuffer();
		string.append(this.windSpeed).append(" KM/H");
		System.out.println(string);
	}
	
	
}
