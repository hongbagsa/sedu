package lab;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String pid = request.getParameter("pid");
		HttpSession session = request.getSession();
		
		
		if(pid != null && pid.equals("clear")) {
			session.setAttribute("cnt", new int[10]);
			request.getRequestDispatcher("/clientexam/basketResult.jsp").forward(request, response);
			return;
		}
		if(session.getAttribute("cnt") == null) {
			session.setAttribute("cnt", new int[10]);
		}
		int[] count = (int[])session.getAttribute("cnt");
		String str ="";
		str = pid.replaceAll("[^0-9]", "");
		count[Integer.parseInt(str)-1]++;
		session.setAttribute("cnt", count);
		session.setAttribute("pid", pid);
		
		request.getRequestDispatcher("/clientexam/basketResult.jsp").forward(request, response);
		}
}


