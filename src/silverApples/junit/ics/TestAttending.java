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
		
		attg = new Attending();
		attgId = new AttendingId();
		
		context = new InitialContext();
		facade = (FacadeLocal) context.lookup("java:app/SilverApplesEJBProject/Facade!silverApples.facade.ics.FacadeLocal");
	}

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
		facade = null;
	}

}
