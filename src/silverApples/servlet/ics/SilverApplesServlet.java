package silverApples.servlet.ics;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		} else if (operation.equals("ajax_createcustomer")) {
			String cPnr = request.getParameter("cPnr");
			String cName = request.getParameter("cName");
			String cAddress = request.getParameter("cAddress");
			String cPhoneNo = request.getParameter("cPhoneNo");
			String cEmail = request.getParameter("cEmail");
			Customer cust = facade.findCustomer(cPnr);
			if (cust == null) {
				Customer c = new Customer();
				c.setCPnr(cPnr);
				c.setCName(cName);
				c.setCAddress(cAddress);
				c.setCPhone(cPhoneNo);
				c.setCMail(cEmail);
				facade.createCustomer(c);
			}
			else {
				System.out.println("Finns redan");				
			}
			ajax = true;
		} else if (operation.equals("ajax_findcustomer")) { // Ajax skickas data med response inte dispatch
			String cPnr = request.getParameter("cPnr");
			Customer c = facade.findCustomer(cPnr);
			if (c != null) {
				//Gson gson = new GsonBuilder().setPrettyPrinting().create();
				
				//String json = gson.toJson(c);
				//System.out.println(json);
				
				
				ArrayList<Object> list = new ArrayList<Object>();
				list.add("\"" + c.getCName() + "\"");
				list.add("\"" +c.getCAddress() + "\"");
				list.add("\"" +c.getCPhone() + "\"");
				list.add("\"" +c.getCMail() + "\"");

				ArrayList<Object> attendingList = new ArrayList<Object>();
				c.getAttendingList().forEach(attending -> {
					attendingList.add("\"" + attending.getEvent().getEName() + "\"");
					attendingList.add("\"" + attending.getEvent().getEDate() + "\"");
					attendingList.add("\"" + attending.getEvent().getEPrice() + "\"");
				});
				
				list.add(attendingList);
				
				ArrayList<Object> attendedList = new ArrayList<Object>();
				c.getAttendedList().forEach(attended -> {
					attendedList.add("\"" + attended.getEvent().getEName() + "\"");
					attendedList.add("\"" + attended.getEvent().getEDate() + "\"");
					attendedList.add("\"" + attended.getEvent().getEPrice() + "\"");
				});
				
				list.add(attendedList);

				/*
				ArrayList<String> eventList = new ArrayList<String>();
				list.add(c.getAttendingList());
				*/
				
				out.println(list);
				

			} else {
				System.out.println("Customer not exists.");
			}
			out.close();
			ajax = true;
		} else if (operation.equals("ajax_deletecustomer")) {
			String cPnr = request.getParameter("cPnr");
			Customer c = facade.findCustomer(cPnr);
			if (c != null) {
				facade.deleteCustomer(cPnr);
			}
			ajax = true;
		} else if (operation.equals("ajax_eventcombobox")) {
			List<Event> list = facade.findAllEvents();
			ArrayList<String> eventList = new ArrayList<String>();
			
			for(int i = 0; i < list.size(); i++) {
				eventList.add("\"" + list.get(i).getEName() + "\"");	
			}
			
			out.println(eventList);
			//System.out.println(list);
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
