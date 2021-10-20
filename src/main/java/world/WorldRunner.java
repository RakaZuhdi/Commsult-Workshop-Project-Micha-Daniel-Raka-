package world;

import sensor.*;

public class WorldRunner {
	public static void main(String[] args) {
		Temperature temp = new Temperature(0, 100);
		
		System.out.println(temp.getInfo());
	}
}
