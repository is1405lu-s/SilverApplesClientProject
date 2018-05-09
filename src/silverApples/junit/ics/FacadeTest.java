package silverApples.junit.ics;

import javax.naming.Context;
import javax.naming.InitialContext;

import junit.framework.TestCase;
import silverApples.ejb.ics.Attending;
import silverApples.ejb.ics.AttendingId;
import silverApples.ejb.ics.Customer;
import silverApples.ejb.ics.Event;
import silverApples.facade.ics.FacadeLocal;

public class FacadeTest extends TestCase {

	FacadeLocal facade;
	Customer c;
	Customer b;
	Event e;
	AttendingId attgId;
	Attending attg;
	Context context;

	public FacadeTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();

		c = new Customer();
		b = new Customer();
		e = new Event();
		attgId = new AttendingId();
		attg = new Attending();
		context = new InitialContext();
		facade = (FacadeLocal) context.lookup("java:app/SilverApplesEJBProject/Facade!silverApples.facade.ics.FacadeLocal");

	}

	/*
	 * public void testFindCustomer() { fail("Not yet implemented"); }
	 */

	public void testCreateCustomer() {

		c.setCPnr("100");
		c.setCName("q");
		c.setCAddress("q");
		c.setCPhone("q");
		c.setCMail("q");
		facade.createCustomer(c);
		assertNotNull(c);
		facade.deleteCustomer("100");
		 b = facade.findCustomer("1");
		 assertNotNull(b);

	}

	public void testCreateEvent() {
		e.setEId("111");
		e.setEName("asdfghjk");
		e.setEPrice(100);
		facade.createEvent(e);
		assertNotNull(e);
		facade.deleteEvent("111");

	}
	
	/*
	 public void testFindCustomer() {
		 b = facade.findCustomer("1");
		 assertNotNull(b);
	 }
	 */
	
	
	public void testCreateAttending() {
		attgId.setCPnr("1");
		attgId.setEId("1");
		attg.setAttendingId(attgId);
		facade.createAttending(attg);
		assertNotNull(attg);
		facade.deleteAttending(attgId);
	}
	
	
	protected void tearDown() throws Exception {
		super.tearDown();
		//b = null;
		facade = null;
	}

}
