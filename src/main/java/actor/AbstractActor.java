package actor;

public abstract class AbstractActor {
	protected Boolean status;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getInfo() {
		if (this.status) {
			return "on";
		} else {
			return "off";
		}

	}
}
