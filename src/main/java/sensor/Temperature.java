package sensor;

import actor.AirConditioner;

public class Temperature extends AbstractSensor {

	public Temperature(int min, int max, int limit) {
		this.value = (int) ((Math.random() * (max - min + 1)) + min);
		this.max = max;
		this.min = min;
		this.limit = limit;
	}

	public void update(AirConditioner AC) {
		int random;
		if (AC.getStatus()) {
			random = (int) ((Math.random() * (5 - 3)) + 3);
			setValue(this.getValue() - random);
		} else {
			random = (int) ((Math.random() * (this.max + this.min)) + this.min);
			setValue(random);
		}
	}
}
