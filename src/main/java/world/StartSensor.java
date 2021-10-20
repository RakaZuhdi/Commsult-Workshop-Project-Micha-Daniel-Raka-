package world;

import java.util.Timer;
import java.util.TimerTask;

import actor.AirConditioner;
import actor.Blinder;
import sensor.*;

public class StartSensor extends TimerTask {
	private Timer timer = new Timer();
	// private TimerTask task = new Helper();
	protected Time time;
	private Wind wind;
	private Temperature temp;
	private Blinder blinder;
	private AirConditioner airConditioner;

	public StartSensor(Time time, Wind wind, Temperature temp, Blinder blinder, AirConditioner airConditioner) {
		this.time = time;
		this.wind = wind;
		this.temp = temp;
		this.setBlinder(blinder);
		this.setAirConditioner(airConditioner);
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

		this.blinder.checkStatus(wind, time);
		this.airConditioner.checkStatus(temp);
	}

	public void print() {

		System.out.print("Time: " + this.time.getInfo());
		System.out.print(" Windspeed: " + this.wind.getInfo());
		System.out.print(" Temperature: " + this.temp.getInfo());
		System.out.print(" Blinder: " + this.blinder.getInfo());
		System.out.println(" AC: " + this.airConditioner.getInfo());
	}

	public Blinder getBlinder() {
		return blinder;
	}

	public void setBlinder(Blinder blinder) {
		this.blinder = blinder;
	}

	public AirConditioner getAirConditioner() {
		return airConditioner;
	}

	public void setAirConditioner(AirConditioner airConditioner) {
		this.airConditioner = airConditioner;
	}

}
