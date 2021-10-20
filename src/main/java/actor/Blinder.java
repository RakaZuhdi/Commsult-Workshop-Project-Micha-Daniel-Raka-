package actor;

import sensor.Temperature;
import sensor.Time;
import sensor.Wind;

public class Blinder implements Actor {
	private Boolean status;

	public Blinder(Boolean status) {
		this.status = status;
	}

	public void checkStatus(Wind windSpeed, Time time) {
		if (time.isNightTime()) {
			setStatus(true);
		} else {
			if (windSpeed.getInfo() > 72) {
				setStatus(true);
			} else {
				setStatus(false);
			}
		}
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getInfo() {
		if (this.status) {
			return "off";
		} else {
			return "on";
		}
	}
}
