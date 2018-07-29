package board.write.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.createBoard.model.BoardVo;
import board.createBoard.service.BoardService;
import board.createBoard.service.BoardServiceInf;
import board.student.model.StudentVo;
import board.student.service.StudentService;
import board.student.service.StudentServiceInf;
import board.write.model.WriteVo;
import board.write.service.WriteService;
import board.write.service.WriteServiceInf;

/**
 * Servlet implementation class WriteViewServlet
 */
@WebServlet("/writeView")
public class WriteViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//
		BoardServiceInf boardService = new BoardService();
		WriteServiceInf writeService = new WriteService();
		
		//선택한 게시판번호 가져와 name set
		int b_id = Integer.parseInt(request.getParameter("b_id"));
		BoardVo boardVo= boardService.getBoardById(b_id);
		request.setAttribute("boardName",boardVo.getB_name());
		
	
		//pagenation======================================================
		
		String pageStr = request.getParameter("page");
		int page = pageStr == null? 1 : Integer.parseInt(pageStr);
		
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = pageSizeStr == null? 10 : Integer.parseInt(pageSizeStr);	
		
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("b_id", b_id);
		
		request.setAttribute("b_id", b_id);
		//List<WriteVo> writeList = writeService.getWriteView(paramMap);
		Map<String, Object>resultMap = writeService.getWriteView(paramMap);
		
		//게시판 페이지 리스트
		List<WriteVo> writeList = (List<WriteVo>)resultMap.get("pageList");
		request.setAttribute("writeList",writeList );

		//페이지 네비게이션 문자열
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		request.getRequestDispatcher("/write/writeView.jsp").forward(request, response); //인자 -- 위임할 주소 입력"
		//request.getRequestDispatcher("/write/writeView.jsp?b_id="+b_id).forward(request, response);
		//"/write/writeView.jsp?b_id="+b_id
	}

}
