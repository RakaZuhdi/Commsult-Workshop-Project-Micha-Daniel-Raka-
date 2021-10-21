package World;

import actor.*;
import sensor.*;

public class WorldRunner {
	public static void main(String[] args) {
		System.out.println("Test 12");
		StartSensor start = new StartSensor(new Time(0), new Wind(0, 90, 72), new Temperature(0, 40, 20), new Blinder(false), new AirConditioner(false), new Light(true, 18, 6));
		start.start();
	}
}
