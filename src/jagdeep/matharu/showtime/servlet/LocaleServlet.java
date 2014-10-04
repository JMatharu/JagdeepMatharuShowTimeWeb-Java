package jagdeep.matharu.showtime.servlet;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LocaleServlet
 */
@WebServlet("/setLocale")
public class LocaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LocaleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String locVal = request.getParameter("ShowTime").trim();
		Locale locale = Locale.getDefault();
		if (locVal.equals("Canada - French")) {
			locale = Locale.CANADA_FRENCH;
		} else if (locVal.equals("United States")) {
			locale = Locale.US;
		} else if (locVal.equals("Canada - English")) {
			locale = Locale.CANADA;
		} else {
			doGet(request, response);
		}
		session.setAttribute("Locale", locale);
		RequestDispatcher rd = request.getRequestDispatcher("clock");
		rd.forward(request, response);

		return;

	}

}
