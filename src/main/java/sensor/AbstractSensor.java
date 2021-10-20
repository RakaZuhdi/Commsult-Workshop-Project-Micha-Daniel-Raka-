package sensor;

public abstract class AbstractSensor {
	protected int value;
	protected int max;
	protected int min;
	protected int limit;

	public int getInfo() {
		return this.value;
	}

	public void print() {
		StringBuffer string = new StringBuffer();
		string.append(this.value).append("");
		System.out.println(string);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	

}
