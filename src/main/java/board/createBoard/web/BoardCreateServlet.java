package board.createBoard.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.createBoard.model.BoardVo;
import board.createBoard.service.BoardService;
import board.createBoard.service.BoardServiceInf;
import board.student.model.StudentVo;

/**
 * Servlet implementation class BoardCreateServlet
 */
@WebServlet("/boardCreate")
public class BoardCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
	
		//
		HttpSession session = request.getSession();
		StudentVo studentVo = (StudentVo)session.getAttribute("studentVo");
		String std_id=studentVo.getStd_id();
		System.out.println("BoardCreateServlet u_id======>"+std_id);
		
		//파라미터 확인
	    String boardName = request.getParameter("boardName");
	    System.out.println("BoardCreateServlet boardName======>"+boardName);
	    //
		BoardServiceInf boardService = new BoardService();
		BoardVo boardVo = new BoardVo();
		
		//파라미터로 받은 값을 vo에 설정
		boardVo.setB_name(boardName);
		boardVo.setStd_id(std_id);
		boardVo.setB_regdt(new Date());
		System.out.println("BoardCreateServlet boardVo======>"+boardVo);
	
		//게시판 insert
		boardService.insertBoard(boardVo);
		
		//게시판 조회 화면으로 
		response.sendRedirect("/boardView");

	}

}
