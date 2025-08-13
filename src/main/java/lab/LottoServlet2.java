package lab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String num = request.getParameter("number");
		int num1 = (int)(Math.random()*6+1);
		HttpSession session = request.getSession();
		int[] cunt = (int[])session.getAttribute("cnt");
		if(session.getAttribute("cnt") == null) {
			session.setAttribute("cnt", new int[1]);
		}
		else {
			cunt[0]++;
		}
		if(cunt[0] >3) {
			 RequestDispatcher rd = request.getRequestDispatcher("clientexam/impossible.html");
	         rd.forward(request, response);
	         return;
		}
		
		if (num1 == Integer.parseInt(num)) {
			RequestDispatcher rd= request.getRequestDispatcher("clientexam/success.html");
			rd.forward(request,  response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("clientexam/fail.html");
			System.out.println("전달된 값: " + num);
			System.out.println("추출된 값: " + num1);
			rd.forward(request,  response);
		}
	}

}
