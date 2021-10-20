package actor;

import sensor.Temperature;
import sensor.Time;
import sensor.Wind;

public class Blinder extends AbstractActor implements Actor {

	public Blinder(Boolean status) {
		this.status = status;
	}

	public void checkStatus(Wind windSpeed, Time time) {
		if (windSpeed.getInfo() > windSpeed.getLimit()) {
			setStatus(true);
		} else {
			setStatus(false);
		}

		if (time.isNightTime()) {
			setStatus(true);
		}
	}
}
