package silverApples.junit.ics;

import javax.naming.Context;
import javax.naming.InitialContext;

import junit.framework.TestCase;
import silverApples.ejb.ics.Event;
import silverApples.facade.ics.FacadeLocal;

public class TestEvent extends TestCase {

	Event e;
	FacadeLocal facade;
	Context context;
	
	public TestEvent(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		e = new Event();
		
		context = new InitialContext();
		facade = (FacadeLocal) context.lookup("java:app/SilverApplesEJBProject/Facade!silverApples.facade.ics.FacadeLocal");
	}
	
	public void testCreateEvent() {
		e.setEId("111");
		e.setEName("asdfghjk");
		e.setEPrice(100);
		facade.createEvent(e);
		assertNotNull(e);
		facade.deleteEvent("111");

	}

	protected void tearDown() throws Exception {
		super.tearDown();
		facade = null;
	}

}
