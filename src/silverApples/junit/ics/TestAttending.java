package silverApples.junit.ics;

import javax.naming.Context;
import javax.naming.InitialContext;

import junit.framework.TestCase;
import silverApples.ejb.ics.Attending;
import silverApples.ejb.ics.AttendingId;
import silverApples.facade.ics.FacadeLocal;

public class TestAttending extends TestCase {

	Attending attg;
	AttendingId attgId;
	FacadeLocal facade;
	Context context;
	
	public TestAttending(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		attgId = new AttendingId("1", "1");
		attg = new Attending(attgId, true);
		
		context = new InitialContext();
		facade = (FacadeLocal) context.lookup("java:app/SilverApplesEJBProject/Facade!silverApples.facade.ics.FacadeLocal");
	}

	public void testCreateAttending() {
		facade.createAttending(attg);
		assertNotNull(attg);
	}
	
	public void testUpdateAttending() {
		attg.setHasPaid(false);
		assertEquals(false, attg.getHasPaid());
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		facade.deleteAttending(attgId);
		facade = null;
	}

}
