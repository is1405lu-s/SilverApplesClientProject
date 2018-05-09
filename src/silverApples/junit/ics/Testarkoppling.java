package silverApples.junit.ics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import silverApples.ejb.ics.Customer;
import silverApples.ejb.ics.Event;
import silverApples.facade.ics.FacadeLocal;

/**
 * Servlet implementation class Testarkoppling
 */
@WebServlet("/Testarkoppling")
public class Testarkoppling extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//@EJB
	//FacadeLocal facade;
	     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testarkoppling() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Context context;
		try {
			context = new InitialContext();
			FacadeLocal facade = (FacadeLocal) context.lookup("java:app/SilverApplesEJBProject/Facade!silverApples.facade.ics.FacadeLocal");
		
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html><html><head>");
			out.println("<title>Lab1</title>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("</head><body>");
			out.println("<h2>Event</h2>");
			
			/*
			Customer c = new Customer();
			c.setCPnr("12");
			c.setCName("q");
			c.setCAddress("q");
			c.setCPhone("q");
			c.setCMail("q");
			facade.createCustomer(c);
			*/
			Customer c = facade.findCustomer("1");
			out.println("<h2>" + c.getCName() + "</h2>");

			
			out.println("</body></html>");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
