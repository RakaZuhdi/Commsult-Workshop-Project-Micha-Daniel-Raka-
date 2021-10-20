package sensor;

public class Temperature extends AbstractSensor implements Sensor{

	public Temperature(int min, int max) {
		this.value = (int) ((Math.random() * (max - min)) + min);
		this.max = max;
		this.min = min;
	}
}
