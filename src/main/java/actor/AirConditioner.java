package actor;

import sensor.Temperature;

public class AirConditioner extends AbstractActor implements Actor {

	public AirConditioner(Boolean status) {
		this.status = status;
	}

	public void checkStatus(Temperature temp) {
		if (temp.getInfo() > temp.getLimit()) {
			setStatus(true);
		} else {
			setStatus(false);
		}
	}

}
