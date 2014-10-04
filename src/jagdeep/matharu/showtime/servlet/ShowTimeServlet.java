package jagdeep.matharu.showtime.servlet;

import jagdeep.matharu.showtime.model.ClockBean;
import jagdeep.matharu.showtime.model.DateTimeFormatException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowTimeServlet
 */
@WebServlet("/clock")
public class ShowTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowTimeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/index.jsp");
		rd.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ClockBean clock = new ClockBean();
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		String format = null;
		Locale locale = null;
		if (request.getParameter("format") != null) {
			format = request.getParameter("format").trim();
		} else {
			format = "FULL";
		}
		try {
			locale = (Locale) session.getAttribute("Locale");
			String time = clock.getCurrentTimeFormatted(format, locale);

			ArrayList<String> TimeLog = (ArrayList<String>) session
					.getAttribute("timelog");
			if (TimeLog == null) {
				TimeLog = new ArrayList<String>();
			}
			TimeLog.add(time);
			session.setAttribute("timelog", TimeLog);
			request.setAttribute("format", format);

			if (locale.equals(Locale.CANADA)) {

				session.setAttribute("locale", "Canada - English");
				rd = request.getRequestDispatcher("/showtimeCaEn.jsp");
			} else if (locale.equals(Locale.CANADA_FRENCH)) {
				session.setAttribute("locale", "Canada - French");
				rd = request.getRequestDispatcher("/showtimeCaFr.jsp");
			} else if (locale.equals(Locale.US)) {
				session.setAttribute("locale", "United States");
				rd = request.getRequestDispatcher("/showtime.jsp");
			} else {

			}
			rd.forward(request, response);
		} catch (DateTimeFormatException e) {
			System.out.println(e.getStackTrace());
		}
		
	}
}
