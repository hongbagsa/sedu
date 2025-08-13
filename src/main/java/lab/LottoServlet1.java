package lab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String num = request.getParameter("number");
		int num1 = (int)(Math.random()*6+1);
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
