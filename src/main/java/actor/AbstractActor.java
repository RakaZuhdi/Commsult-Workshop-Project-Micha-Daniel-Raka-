package actor;

public abstract class AbstractActor {
	protected Boolean active;
	protected boolean disabled = false;

	public Boolean getStatus() {
		if(disabled)
			return false;
		
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public void disable() {
		this.disabled = !disabled;
	}

	public String getInfo() {
		if (this.active && !disabled) {
			return "on";
		} else {
			return "off";
		}

	}
}
