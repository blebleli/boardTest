package board.createBoard.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.createBoard.model.BoardVo;
import board.createBoard.service.BoardService;
import board.createBoard.service.BoardServiceInf;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/boardView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		BoardServiceInf boardService = new BoardService();
		
//		List<BoardVo> boardList = boardService.getAllBoards();
//		System.out.println("BoardViewServlet boardList=====>"+boardList);
//		request.setAttribute("boardList",boardList );
		
		request.getRequestDispatcher("/board/boardView.jsp").forward(request, response); //인자 -- 위임할 주소 입력
	}


}
