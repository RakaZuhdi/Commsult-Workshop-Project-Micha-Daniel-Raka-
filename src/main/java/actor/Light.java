package actor;

import sensor.Temperature;
import sensor.Time;

public class Light extends AbstractActor {
	private int timeActive;
	private int timeOff;

	public Light(Boolean status, int timeActive, int timeOff) {
		this.active = status;
		this.timeActive = timeActive;
		this.timeOff = timeOff;
	}

	public void checkStatus(Time time) {
		if (time.getInfo() >= this.timeActive || time.getInfo() <= this.timeOff) {
			setActive(true);
		} else {
			setActive(false);
		}
	}
}
