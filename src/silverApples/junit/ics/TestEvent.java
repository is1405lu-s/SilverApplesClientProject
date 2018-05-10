package silverApples.junit.ics;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;

import junit.framework.TestCase;
import silverApples.ejb.ics.Event;
import silverApples.facade.ics.FacadeLocal;

public class TestEvent extends TestCase {

	Event e;
	Event v;
	FacadeLocal facade;
	Context context;
	
	public TestEvent(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		e = new Event("100", "Karateträning", 100, new Date());
		
		context = new InitialContext();
		facade = (FacadeLocal) context.lookup("java:app/SilverApplesEJBProject/Facade!silverApples.facade.ics.FacadeLocal");
	}
	
	public void testCreateEvent() {
		facade.createEvent(e);
		assertNotNull(e);
	}
	
	public void testFindEvent() {
		v = facade.findEvent("1");
		assertNotNull(e);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		facade.deleteEvent(e.getEId());
		e = null;
		facade = null;
	}

}
