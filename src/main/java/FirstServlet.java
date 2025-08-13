

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/first", "/first1", "/first2"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("myname");
		out.println("<h1> 반가워요~~" +name+"님!!</h1>");
		out.println("<h2>현재시간 : "+new java.util.Date() +"</h2>");
		System.out.println("서블릿에서 표준을 출력해요~~~");
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
 