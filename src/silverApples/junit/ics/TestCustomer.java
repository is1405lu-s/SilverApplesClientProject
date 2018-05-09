package silverApples.junit.ics;

import javax.naming.Context;
import javax.naming.InitialContext;

import junit.framework.TestCase;
import silverApples.ejb.ics.Customer;
import silverApples.facade.ics.FacadeLocal;

public class TestCustomer extends TestCase {

	Customer c;
	Customer b;
	FacadeLocal facade;
	Context context;
	
	public TestCustomer(String name) {
		super(name);

	}

	protected void setUp() throws Exception {
		super.setUp();
		
		c = new Customer();
		b = new Customer();
		
		context = new InitialContext();
		facade = (FacadeLocal) context.lookup("java:app/SilverApplesEJBProject/Facade!silverApples.facade.ics.FacadeLocal");
	}

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
	
	protected void tearDown() throws Exception {
		super.tearDown();
		facade = null;
	}

}
