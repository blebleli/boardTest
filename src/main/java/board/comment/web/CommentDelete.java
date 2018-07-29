package board.comment.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.comment.model.CommentVo;
import board.comment.service.CommentService;
import board.comment.service.CommentServiceInf;
import board.write.model.WriteVo;
import board.write.service.WriteService;
import board.write.service.WriteServiceInf;

/**
 * Servlet implementation class CommentDelete
 */
@WebServlet("/commentDelete")
public class CommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		System.out.println("삭제 =====================================================");
		
		//게시판번호
		int b_id = Integer.parseInt(request.getParameter("b_id"));
		
		//게시글번호
		int w_id = Integer.parseInt(request.getParameter("w_id"));

		//댓글 번호
		int c_id = Integer.parseInt(request.getParameter("c_id"));

		CommentServiceInf commentService = new CommentService();
		CommentVo commentVo = new CommentVo();

		//파라미터로 받은 값을 vo에 설정
		//writeVo.setW_parent(w_parent);--답글클릭해서할때만 set한다
		commentVo.setC_delny("Y");
		commentVo.setC_cmt("삭제된 댓글입니다.");
		commentVo.setC_id(c_id);
	
			
		System.out.println("WriteCreateServlet writeVo======>"+commentVo);
	
		//게시글 update
		commentService.updateComment(commentVo);
		//게시글 조회 화면으로 \
		response.sendRedirect("/writeDetailView?b_id="+b_id+"&w_id="+w_id);
		//request.getRequestDispatcher("/writeView").forward(request, response);
		//request.getRequestDispatcher("/write/writeView.jsp").forward(request, response); 
	}

}
