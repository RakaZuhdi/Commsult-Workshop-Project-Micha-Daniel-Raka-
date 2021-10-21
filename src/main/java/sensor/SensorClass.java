package sensor;

public class SensorClass {
	public int time;
	public int wind;
	public int temperature;
	public String blinds = null;
	public String light = null;
	public String airConditioner = null;
	public String formattedTime = null;

	public SensorClass(int time, int wind, int temperature, String blinds, String light, String airConditioner) {
		this.time = time;
		this.wind = wind;
		this.temperature = temperature;
		this.blinds = blinds;
		this.light = light;
		this.airConditioner = airConditioner;
		this.formattedTime = formatTime(time);
	}

	public String formatTime(int time) {
		String result = null;
		int lineLength = String.valueOf(time).length();

		if (lineLength == 1) {
			result = "0" + Integer.toString(time) + ".00";
		} else {
			result = Integer.toString(time) + ".00";
		}

		return result;
	}

	public String getFormattedTime() {
		return formattedTime;
	}

	public void setFormattedTime(String formattedTime) {
		this.formattedTime = formattedTime;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getWind() {
		return wind;
	}

	public void setWind(int wind) {
		this.wind = wind;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public String getBlinds() {
		return blinds;
	}

	public void setBlinds(String blinds) {
		this.blinds = blinds;
	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

	public String getAirConditioner() {
		return airConditioner;
	}

	public void setAirConditioner(String airConditioner) {
		this.airConditioner = airConditioner;
	}

}
