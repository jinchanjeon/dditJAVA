package kr.or.ddit.member.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVo;

@WebServlet("/login.do")
public class LoginController extends HttpServlet{
	
	MemberService memberService = MemberServiceImpl.getInstacne();
			
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("로그인 페이지");
		
		req.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberVo member = new MemberVo();
		member.setId(id);
		member.setPw(pw);
		
		member = memberService.login(member);
		if(member == null) {
			// 로그인 실패
			
			req.setAttribute("message", "fail");
			req.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(req, resp);
		
		}
		else {
			//로그인 성공
			// req-> 1회 session -> 브라우저 servletContext ->서버당 
			HttpSession session = req.getSession();
			session.setAttribute("member", member);
			
			resp.sendRedirect("/FileIOWeb/index.do");
		}
	}

}
