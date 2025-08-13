package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDTO;

@WebServlet("/remember")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String num = request.getParameter("phone");
		String id = request.getParameter("Id");
		String pwd = request.getParameter("psword");
		MemberDTO dto = new MemberDTO();
		
		if(num.isEmpty()) {
			num="없음";
		}
		if(name.isEmpty()) {
			name="없음";
		}
		if(id.isEmpty()) {
			id="없음";
		}
		if(pwd.isEmpty()) {
			pwd = "없음";
		}
		dto.setNumber(num);
		dto.setName(name);
		dto.setId(id);
		dto.setPassword(pwd);
		
		request.setAttribute("objtbc", dto);
		request.getRequestDispatcher("/jspexam/memberView.jsp").forward(request, response);
	}

}
