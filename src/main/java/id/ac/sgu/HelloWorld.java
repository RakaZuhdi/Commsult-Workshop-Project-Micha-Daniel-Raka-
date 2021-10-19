package id.ac.sgu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {

	private static final Logger LOG = LogManager.getLogger(HelloWorld.class);

	public static void main(String[] args) {

		// System.out.println("Hello World");
		
		LOG.trace("TRACE");
		LOG.debug("DEBUG");
		LOG.info("INFO");
		LOG.warn("WARN");
		LOG.error("ERROR");
	}
}
