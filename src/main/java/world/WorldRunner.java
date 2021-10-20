package world;

import actor.*;
import sensor.*;

public class WorldRunner {
	public static void main(String[] args) {
		System.out.println("Test");
		StartSensor start = new StartSensor(new Time(0), new Wind(0, 90), new Temperature(0, 40), new Blinder(false), new AirConditioner(false));
		start.start();
	}
}
