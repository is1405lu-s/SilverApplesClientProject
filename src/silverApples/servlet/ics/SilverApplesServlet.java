package silverApples.servlet.ics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import silverApples.ejb.ics.Attending;
import silverApples.ejb.ics.AttendingId;
import silverApples.ejb.ics.Customer;
import silverApples.ejb.ics.Event;
import silverApples.facade.ics.FacadeLocal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/SilverApplesServlet")
public class SilverApplesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	FacadeLocal facade;

	public SilverApplesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub PrintWriter out = response.getWriter();
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * response.getWriter().append("Served at: ").append(request.getServletPath());
	 * out.println("SilverApplesServlet-doGet"); out.close();
	 * 
	 * }
	 */

	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/plain; charset=ISO8859-1");

		String url = null;
		// Get hidden field
		boolean ajax = false;
		String operation = request.getParameter("operation");
		
		if (operation.equals("showcustomer")) {
			System.out.println("SilverApplesServlet-showcustomer");
			String cPnr = request.getParameter("txtPnr");
			Customer c = facade.findCustomer(cPnr);
			request.setAttribute("customer", c);
			url = "/SearchCustomer.jsp";
		} else if (operation.equals("searchcustomer")) {
			System.out.println("SilverApplesServlet-searchcustomer");
			url = "/SearchCustomer.jsp";
		} else if (operation.equals("ajax_findcustomer")) { // Ajax skickas data med response inte dispatch
			String id = request.getParameter("cPnr");
			Customer c = facade.findCustomer(id);
			if (c != null) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				
				String json = gson.toJson(c);
				System.out.println(json);
				
				/*
				ArrayList<String> list = new ArrayList<String>();
				list.add("\"" + c.getCName() + "\"");
				list.add("\"" +c.getCAddress() + "\"");
				list.add("\"" +c.getCPhone() + "\"");
				list.add("\"" +c.getCMail() + "\"");

				out.println(list);
				//out.println(c.getCName());
				//out.println(c.getCAddress());
				//out.println(c.getCPhone());
				//out.println(c.getCMail());
				 * 
				 */
			} else {
				System.out.println("Customer not exists.");
			}
			out.close();
			ajax = true;
		} else {
			System.out.println("asdfghjkl");
			url = "/SearchCustomer.jsp";
		}

		if (!ajax) {
			System.out.println(url);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

}
