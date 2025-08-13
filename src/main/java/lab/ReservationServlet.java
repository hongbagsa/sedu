package lab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("username");
		String Room[] = request.getParameterValues("room");
		String money[] = request.getParameterValues("moremoney");
		String date = request.getParameter("date");
		String[] arr = date.toString().split("-");
		out.print("<style>h2 { color: blue; }</style>");
		out.print("<h2>"+userName+"의 예약내용</h2><hr>");
		out.print("<ul>");
		if(Room != null && Room.length !=0) {
			for(String R:Room) {
				out.print("<li>선택한 룸 : "+R+"</li>");
			}
		}
		else {
			out.print("<li>예약된 방이 없습니다。</li>");
		}
		if(money != null && money.length !=0) {
			for(String M:money) {
				out.print("<li> 추가 요청 사항 : "+M+"</li>");
			}
		}
		else {
			out.print("<li>예약된 서비스가 없습니다。 돈을 더 써주세요。</li>");
		}
		out.print("<li>예약날짜 : "+arr[0]+"년 "+arr[1]+"월 "+arr[2]+"일 "+"</li></ul>");
		out.close();
	}

}
