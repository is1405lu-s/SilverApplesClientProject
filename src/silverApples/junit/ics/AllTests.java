package silverApples.junit.ics;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestAttending.class);
		suite.addTestSuite(TestCustomer.class);
		suite.addTestSuite(TestEvent.class);
		//$JUnit-END$
		return suite;
	}

}
