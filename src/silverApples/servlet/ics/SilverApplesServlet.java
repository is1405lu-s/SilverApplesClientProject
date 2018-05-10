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

import silverApples.ejb.ics.Attended;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");

		String url = null;
		boolean ajax = false;
		String operation = request.getParameter("operation");

		if (operation.equals("ajax_findCustomer")) { // Ajax skickas data med response inte dispatch
			String cPnr = request.getParameter("cPnr");
			Customer c = facade.findCustomer(cPnr);
			ArrayList<Object> list = new ArrayList<Object>();
			list.add("\"" + c.getCName() + "\"");
			list.add("\"" + c.getCAddress() + "\"");
			list.add("\"" + c.getCPhone() + "\"");
			list.add("\"" + c.getCMail() + "\"");

			ArrayList<Object> attendingList = new ArrayList<Object>();
			c.getAttendingList().forEach(attending -> {
				attendingList.add("\"" + attending.getEvent().getEName() + "\"");

				SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm");
				String s = dt.format(attending.getEvent().getEDate());
				attendingList.add("\"" + s + "\"");

				attendingList.add("\"" + attending.getEvent().getEPrice() + "\"");
			});

			list.add(attendingList);

			ArrayList<Object> attendedList = new ArrayList<Object>();
			c.getAttendedList().forEach(attended -> {
				attendedList.add("\"" + attended.getEvent().getEName() + "\"");

				SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm");
				String s = dt.format(attended.getEvent().getEDate());

				attendedList.add("\"" + s + "\"");
				attendedList.add("\"" + attended.getEvent().getEPrice() + "\"");
			});

			list.add(attendedList);

			out.println(list);

			out.close();
			ajax = true;
		} else if (operation.equals("ajax_createCustomer")) {
			String cPnr = request.getParameter("cPnr");
			Customer cust = facade.findCustomer(cPnr);
			String cName = request.getParameter("cName");
			String cAddress = request.getParameter("cAddress");
			String cPhone = request.getParameter("cPhone");
			String cMail = request.getParameter("cMail");
			Customer c = new Customer(cPnr, cName, cAddress, cPhone, cMail);

			facade.createCustomer(c);
			ajax = true;

		} else if (operation.equals("ajax_deleteCustomer")) {
			String cPnr = request.getParameter("cPnr");
			Customer c = facade.findCustomer(cPnr);

			for (Attending attg : c.getAttendingList()) {
				facade.deleteAttending(attg.getAttendingId());
			}

			for (Attended attd : c.getAttendedList()) {
				facade.deleteAttended(attd.getAttendedId());
			}

			facade.deleteCustomer(cPnr);

			ajax = true;

		} else if (operation.equals("ajax_eventCombobox")) {
			List<Event> list = facade.findAllEvents();
			ArrayList<String> eventList = new ArrayList<String>();

			for (int i = 0; i < list.size(); i++) {
				Date d = new Date();
				if (list.get(i).getEDate().after(d))
				eventList.add("\"" + list.get(i).getEId() + ": " + list.get(i).getEName() + "\"");
			}

			out.println(eventList);
			out.close();
			ajax = true;
		} else if (operation.equals("ajax_addToEvent")) {
			String cPnr = request.getParameter("cPnr");
			Customer c = facade.findCustomer(cPnr);
			String event = request.getParameter("event");

			String[] parts = event.split(": ");
			String eId = parts[0];

			Event e = facade.findEvent(eId);

			Attending attg = new Attending();
			AttendingId attgId = new AttendingId(c.getCPnr(), e.getEId());
			attg.setAttendingId(attgId);
			facade.createAttending(attg);

			ajax = true;
		} else {
			url = "/Startpage.jsp";
		}

		if (!ajax) {
			System.out.println(url);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

}
