package silverApples.junit.ics;

import javax.naming.Context;
import javax.naming.InitialContext;

import junit.framework.TestCase;
import silverApples.ejb.ics.Customer;
import silverApples.facade.ics.FacadeLocal;

public class TestCustomer extends TestCase {

	Customer c;
	FacadeLocal facade;
	Context context;
	
	public TestCustomer(String name) {
		super(name);

	}

	protected void setUp() throws Exception {
		super.setUp();
		
		c = new Customer("100", "Flora", "Gångvägen 25", "123", "@me");
		
		context = new InitialContext();
		facade = (FacadeLocal) context.lookup("java:app/SilverApplesEJBProject/Facade!silverApples.facade.ics.FacadeLocal");
	}

	public void testCreateCustomer() {

		facade.createCustomer(c);
		assertNotNull(c);
	}
	
	public void testUpdateCustomer() {
		c.setCName("Tim");
		facade.updateCustomer(c);
		assertEquals("Tim", c.getCName());
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		facade.deleteCustomer(c.getCPnr());
		facade = null;
	}
	
}
