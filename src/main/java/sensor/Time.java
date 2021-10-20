package sensor;

public class Time implements Sensor {
	private int time = 0;

	public Time(int time) {
		this.time = time;
	}
	
	public void update() {
		this.time = this.time ==  23? 0 : this.time+1; 
	}
	
	public int getInfo() {
		return this.time;
	}
	
	public Boolean isNightTime() {
		if(this.time > 2) {
			return true;
		}else {
			return false;
		}
	}
}
