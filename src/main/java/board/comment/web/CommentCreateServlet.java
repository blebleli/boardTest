package board.comment.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.comment.model.CommentVo;
import board.comment.service.CommentService;
import board.comment.service.CommentServiceInf;
import board.student.model.StudentVo;

/**
 * Servlet implementation class CommentCreateServlet
 */
@WebServlet("/commentCreate")
public class CommentCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//
		HttpSession session = request.getSession();
		StudentVo studentVo = (StudentVo)session.getAttribute("studentVo");
		String std_id=studentVo.getStd_id();
		System.out.println("CommentCreateServlet u_id======>"+std_id);
		
		//파라미터 확인
		int b_id = Integer.parseInt(request.getParameter("b_id"));
		int w_id = Integer.parseInt(request.getParameter("w_id"));
		String c_cmt = request.getParameter("c_cmt");
		
		CommentVo commentVo = new CommentVo();
		
		//파라미터로 받은 값을 vo에 설정
		commentVo.setW_id(w_id);
		commentVo.setStd_id(std_id);
		commentVo.setC_cmt(c_cmt);
		commentVo.setC_regdt(new Date());
		System.out.println("CommentCreateServlet commentVo======>"+commentVo);
		
		CommentServiceInf commentService = new CommentService();
		//댓글 insert
		commentService.insertComment(commentVo);

		//게시글 조회 화면으로 
		response.sendRedirect("/writeDetailView?b_id="+b_id+"&w_id="+w_id);
	}
}
