package World;

public class Wind {
	private int windSpeed;
	private int max;
	private int min;

	public Wind(int min, int max) {
		this.max = max;
		this.min = min;
	}
	
	public int generateValue() {
		this.windSpeed = (int) ((Math.random() * (max - min)) + min);
		return this.windSpeed;
	}
	
	public void print() {
		
	}
	
	
}
