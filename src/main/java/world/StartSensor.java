package world;

import java.util.Timer;
import java.util.TimerTask;

import actor.AirConditioner;
import actor.Blinder;
import actor.Light;
import sensor.*;

public class StartSensor extends TimerTask {
	private Timer timer = new Timer();
	// private TimerTask task = new Helper();
	protected Time time;
	private Wind wind;
	private Temperature temp;
	private Blinder blinder;
	private AirConditioner airConditioner;
	private Light light;

	public StartSensor(Time time, Wind wind, Temperature temp, Blinder blinder, AirConditioner airConditioner, Light light) {
		this.time = time;
		this.wind = wind;
		this.temp = temp;
		this.setBlinder(blinder);
		this.setAirConditioner(airConditioner);
		this.light = light;
	}

	public void start() {
		timer.schedule(this, 0, 1000);
	}
	
	public void stop() {
		timer.cancel();
	}
	

	public void run() {
		update();
		print();
	}

	public void update() {

		this.wind.update();
		this.temp.update(this.airConditioner);
		this.time.update();
		
		this.light.checkStatus(time);
		this.blinder.checkStatus(wind, time);
		this.airConditioner.checkStatus(temp);

	}

	public void print() {

		System.out.print("Time: " + this.time.getInfo());
		System.out.print(" Windspeed: " + this.wind.getInfo());
		System.out.print(" Temperature: " + this.temp.getInfo());
		System.out.print(" Blinder: " + this.blinder.getInfo());
		System.out.print(" Light: " + this.light.getInfo());
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

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Temperature getTemp() {
		return temp;
	}

	public void setTemp(Temperature temp) {
		this.temp = temp;
	}

	public Light getLight() {
		return light;
	}

	public void setLight(Light light) {
		this.light = light;
	}
	
	

}
