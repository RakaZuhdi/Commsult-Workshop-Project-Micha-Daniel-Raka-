package sensor;

public class Wind extends AbstractSensor {

	public Wind(int min, int max, int limit) {
		this.value = (int) ((Math.random() * (max - min)) + min);
		this.max = max;
		this.min = min;
		this.limit = limit;
	}
}
