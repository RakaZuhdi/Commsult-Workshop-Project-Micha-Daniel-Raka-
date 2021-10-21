package actor;

import sensor.Temperature;
import sensor.Time;
import sensor.Wind;

public class Blinder extends AbstractActor implements Actor {

	public Blinder(Boolean status) {
		this.active = status;
	}

	public void checkStatus(Wind windSpeed, Time time) {
		if (windSpeed.getInfo() > windSpeed.getLimit()) {
			setActive(true);
		} else {
			setActive(false);
		}

		if (time.isNightTime()) {
			setActive(true);
		}
	}
}
