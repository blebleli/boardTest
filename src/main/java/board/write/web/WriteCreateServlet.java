package board.write.web;

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
import board.write.model.WriteVo;
import board.write.service.WriteService;
import board.write.service.WriteServiceInf;

/**
 * Servlet implementation class WriteCreateServlet
 */
@WebServlet("/writeCreate")
public class WriteCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		
		//부모글 번호
		int w_parent = Integer.parseInt(request.getParameter("w_parent"));
		
		//접속한 사용자 id 
		HttpSession session = request.getSession();
		StudentVo studentVo = (StudentVo)session.getAttribute("studentVo");
		String std_id=studentVo.getStd_id();
		System.out.println("WriteCreateServlet u_id======>"+std_id);
		
		//게시판번호
		int b_id = Integer.parseInt(request.getParameter("b_id"));
		
		//제목
		String w_title= request.getParameter("w_title");
		
		//내용
		String smarteditor = request.getParameter("smarteditor");
		
		
		WriteServiceInf writeService = new WriteService();
		WriteVo writeVo = new WriteVo();

		//파라미터로 받은 값을 vo에 설정
		//writeVo.setW_parent(w_parent);--답글클릭해서할때만 set한다
		writeVo.setW_parent(w_parent);
		writeVo.setStd_id(std_id);
		writeVo.setB_id(b_id);
		writeVo.setW_title(w_title);
		writeVo.setW_content(smarteditor);
		writeVo.setW_regdt(new Date());
			
		System.out.println("WriteCreateServlet writeVo======>"+writeVo);
	
		//게시글 insert
		writeService.insertWrite(writeVo);

	
		//게시글 조회 화면으로 \
		response.sendRedirect("/writeView?b_id="+b_id);
		//request.getRequestDispatcher("/writeView").forward(request, response);
		//request.getRequestDispatcher("/write/writeView.jsp").forward(request, response); 
	}

}
