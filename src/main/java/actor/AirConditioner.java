package actor;

import sensor.Temperature;

public class AirConditioner extends AbstractActor implements Actor {

	public AirConditioner(Boolean status) {
		this.active = status;
	}

	public void checkStatus(Temperature temp) {
		if (temp.getInfo() > temp.getLimit()) {
			setActive(true);
		} else {
			setActive(false);
		}
	}

}
