package board.student.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.student.model.StudentVo;
import board.student.service.StudentService;
import board.student.service.StudentServiceInf;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/studentList")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 링크로 오기때문에 doget 사용
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//page, pageSize 파라미터  ------
		StudentServiceInf studentService = new StudentService();
		
		String pageStr = request.getParameter("page");
		int page = pageStr == null? 1 : Integer.parseInt(pageStr);
		
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = pageSizeStr == null? 10 : Integer.parseInt(pageSizeStr);	
		
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		Map<String, Object>resultMap = studentService.getStudentPageList(paramMap);
		
		//학생 페이지 리스트
		List<StudentVo> studentList = (List<StudentVo>)resultMap.get("pageList");
		request.setAttribute("studentList",studentList );


		//페이지 네비게이션 문자열
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);

		request.getRequestDispatcher("/student/studentList.jsp").forward(request, response); //인자 -- 위임할 주소 입력
	
	}


}
