package kr.or.ddit.member.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import kr.or.ddit.file.vo.AttachFileVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.util.UploadUtil;

@WebServlet("/member/insertProc.do")
@MultipartConfig
public class InsertProcController extends HttpServlet{
	// form.jsp 내용 받아오기
	// /member/insertProc.do
	
	MemberService memberService = MemberServiceImpl.getInstacne();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				Part part = req.getPart("img");
				AttachFileVo fileVo = UploadUtil.writeFile(part);
				
				int fileNo = memberService.getMaxFileNo();
				fileVo.setFile_no(fileNo);
						
				// file insert (회원이랑 관련되어서 멤버 xml에서 파일처리)
				memberService.insertFile(fileVo);
				
				String id = req.getParameter("id");
				String pw = req.getParameter("pw");
				String name = req.getParameter("name");
				String juso = req.getParameter("juso");
				String tell = req.getParameter("tell");
				
				int memNo = memberService.getMaxMemNo();
				MemberVo member = new MemberVo();
				member.setMem_no(memNo);
				member.setId(id);
				member.setPw(pw);
				member.setName(name);
				member.setJuso(juso);
				member.setTell(tell);
				member.setImg(fileNo);
				
				int cnt = memberService.insertMember(member);
				if(cnt == 0) {
					req.getRequestDispatcher("/WEB-INF/view/member/form.jsp").forward(req, resp);
				}
				else {
					req.getRequestDispatcher("/WEB-INF/view/member/form.jsp").forward(req, resp);
				}
		
			
			}
	}
	

