package sensor;

public class Time {
	private int time = 0;

	public Time(int time) {
		this.time = time;
	}
	
	public void increment() {
		this.time = this.time ==  23? 0 : this.time+1; 
	}
	
	public int getInfo() {
		return this.time;
	}
}
