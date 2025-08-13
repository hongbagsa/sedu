package lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>요청 데이터 추출(POST)</h1>");
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("username");
		String strMemo = request.getParameter("memo");
		LocalDate date = LocalDate.now();
		String[] arr = date.toString().split("-");
		out.print("<h2>"+userName+"님이"+arr[0]+"년 "+Integer.parseInt(arr[1])+"월 "+Integer.parseInt(arr[2])+"일 "+"에 남긴 글입니다.</h2><hr>");
		out.print("<p>"+strMemo+"</p>");
		out.close();
	}

}
