package actor;

import sensor.Temperature;

public class AirConditioner implements Actor {
	private Boolean status;

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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public String getInfo() {
		if(this.status) {
			return "on";
		}else {
			return "off";
		}
	}

}
