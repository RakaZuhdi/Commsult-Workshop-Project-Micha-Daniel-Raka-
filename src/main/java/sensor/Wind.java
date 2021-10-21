package sensor;

import actor.AirConditioner;

public class Wind extends AbstractSensor {

	public Wind(int min, int max, int limit) {
		this.value = (int) ((Math.random() * (max - min + 1)) + min);
		this.max = max;
		this.min = min;
		this.limit = limit;
	}

	public void update() {
		this.value = (int) ((Math.random() * (max - min + 1)) + min);
	}
}
