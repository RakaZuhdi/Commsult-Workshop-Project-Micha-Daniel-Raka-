package sensor;

public class Time implements Sensor {
	private int time = 0;
	private String formattedTime = null;

	public Time(int time) {
		this.time = time;
		this.formattedTime = formatTime(time);
	}
	
	public void update() {
		this.time = this.time ==  23? 0 : this.time+1; 
		this.formattedTime = formatTime(this.time);
	}
	
	public int getInfo() {
		return this.time;
	}
	
	public String formatTime (int time) {
		String result = null;
		int lineLength = String.valueOf(time).length();
		
		if(lineLength == 1) {
			result = "0"+ Integer.toString(time) + ".00";
		}else {
			result = Integer.toString(time) + ".00";
		}
		
		return result;
	}
	
	public Boolean isNightTime() {
		if(this.time > 15 || this.time < 6) {
			return true;
		}else {
			return false;
		}
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getFormattedTime() {
		return formattedTime;
	}

	public void setFormattedTime(String formattedTime) {
		this.formattedTime = formattedTime;
	}
	
	
}
