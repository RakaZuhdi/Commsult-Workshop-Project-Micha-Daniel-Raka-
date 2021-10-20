package world;

import java.util.Timer;
import java.util.TimerTask;
import sensor.*;



public class StartSensor extends TimerTask {
	private Timer timer = new Timer();
	//private TimerTask task = new Helper();
	protected Time time;
	private Wind wind;
	private Temperature temp;
	
	
	public StartSensor(Time time, Wind wind, Temperature temp) {
		this.time = time;
		this.wind = wind;
		this.temp = temp;
	}
	
	public void start() {
		timer.schedule(this, 0, 1000);	
	}
	
	
	public void run() {
		update();
		print();
	}
	
	public void update() {
		this.time.update();
		this.wind.update();
		this.temp.update();
	}
	
	public void print() {
		System.out.print("Time: " + this.time.getInfo());
		System.out.print("\t Windspeed: " + this.wind.getInfo());
		System.out.println("\t Temperature " + this.temp.getInfo());
	}
	

}
