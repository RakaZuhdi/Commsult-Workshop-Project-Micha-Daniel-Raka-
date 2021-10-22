package id.ac.sgu;

import static org.junit.jupiter.api.Assertions.*;

import org.easymock.TestSubject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actor.*;
import sensor.*;

class TestDemoTest {

	@TestSubject
	private Light lightTest = new Light(true, 18, 6);
	private Blinder blindTest = new Blinder(false); 
	private AirConditioner acTest = new AirConditioner(false);
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void isLightOnAtNight() {

		lightTest.checkStatus(new Time(20));
		Boolean result = lightTest.getStatus();
		assertEquals(true, result);
	}
	@Test
	void didBlindActiveAtHighWindSpped() {
		
		Wind wind = new Wind(0, 90, 72);
		wind.setValue(73);
		blindTest.checkStatus(wind, new Time(12));
		Boolean result = blindTest.getStatus();
		assertEquals(true, result);
	}
	@Test
	void didBlindActiveAtNight() {
		Wind wind = new Wind(0, 90, 72);
		wind.setValue(20);
		blindTest.checkStatus(wind, new Time(20));
		Boolean result = blindTest.getStatus();
		assertEquals(true, result);
	}
	@Test
	void didAirconActiveAtHotTemp() {
		Temperature temp= new Temperature(25,40,34);
		temp.setValue(35);
		acTest.checkStatus(temp);
		Boolean result = acTest.getStatus();
		assertEquals(true, result);
	}
	
	 //new Temperature(0, 40, 20)

}
