package sensor;

import java.util.Timer;
import java.util.TimerTask;

class Helper extends TimerTask {
    public static int i = 1;
     
    // TimerTask.run() method will be used to perform the action of the task
     
    public void run() {
        System.out.println("This is called " + i++ + " time");
    }
}

public class Time implements Sensor {
	private Timer timer = new Timer();
	private TimerTask task = new Helper();
	private int time;
	
	public Time(int time) {
		this.time = time;
	}
	
	@Override
	public int getInfo() {
		// TODO Auto-generated method stub
		return this.time;
	}
	
	public void start() {
		 timer.schedule(task, 0, 1000);
	}

}
