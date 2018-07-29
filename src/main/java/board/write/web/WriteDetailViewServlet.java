package board.write.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.write.model.WriteVo;
import board.write.service.WriteService;
import board.write.service.WriteServiceInf;

/**
 * Servlet implementation class WriteDetailViewServlet
 */
@WebServlet("/writeDetailView")
public class WriteDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WriteServiceInf writeService = new WriteService();

		String w_id = request.getParameter("w_id");
		int w_id_Int =Integer.parseInt(w_id); 
		
		WriteVo writeVo = writeService.getWriteById(w_id_Int);
		
		request.setAttribute("writeVo", writeVo);
	
		request.getRequestDispatcher("/write/writeDetailView.jsp").forward(request, response);
	}
}
