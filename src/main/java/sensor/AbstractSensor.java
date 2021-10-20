package sensor;

public abstract class AbstractSensor {
	protected int value;
	protected int max;
	protected int min;
	
	public void update() {
		this.value = (int) ((Math.random() * (max - min)) + min);
	}
	
	public int getInfo() {
		return this.value;
	}
	
	public void print() {
		StringBuffer string = new StringBuffer();
		string.append(this.value).append("");
		System.out.println(string);
	}

}
