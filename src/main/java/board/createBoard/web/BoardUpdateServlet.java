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
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		//파라미터 확인
	    String boardName = request.getParameter("boardName");
	    int b_id = Integer.parseInt(request.getParameter("b_id"));
	    String b_useny = request.getParameter("b_useny");//request.getParameter("b_useny");
	
		BoardVo boardVo = new BoardVo();
		boardVo.setB_id(b_id);
		boardVo.setB_name(boardName);
		boardVo.setB_useny(b_useny);
		
		System.out.println("BoardUpdateServlet boardVo======>"+boardVo);
	
		//게시판 insert
		BoardServiceInf boardService = new BoardService();
		boardService.updateBoard(boardVo);
		
		//게시판 조회 화면으로 
		response.sendRedirect("/boardView");
	}

}
