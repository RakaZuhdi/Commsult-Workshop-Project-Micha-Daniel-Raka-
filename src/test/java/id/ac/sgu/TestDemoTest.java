package id.ac.sgu;

import static org.junit.jupiter.api.Assertions.*;

import org.easymock.TestSubject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actor.Light;
import sensor.Time;

class TestDemoTest {

	@TestSubject
	private Light lightTest = new Light(true, 18, 6);

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

}
