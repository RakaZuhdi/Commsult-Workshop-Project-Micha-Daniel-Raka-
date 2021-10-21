package actor;

public abstract class AbstractActor {
	protected Boolean active;

	public Boolean getStatus() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getInfo() {
		if (this.active) {
			return "on";
		} else {
			return "off";
		}

	}
}
