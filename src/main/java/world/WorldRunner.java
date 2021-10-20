package world;

import sensor.*;

public class WorldRunner {
	public static void main(String[] args) {
		System.out.println("Test");
		StartSensor start = new StartSensor(new Time(0), new Wind(0, 0), new Temperature(0, 0));
		start.start();
		System.out.print("sdakfjasl;kdfj;l");
	}
}
