package board.student.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.student.model.StudentVo;
import board.student.service.StudentService;
import board.student.service.StudentServiceInf;

/**
 * Servlet implementation class StudentDetailServlet
 */
@WebServlet("/studentDetail")
public class StudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//학생 id를 파라미터 확인
		String std_id = request.getParameter("std_id");
		System.out.println("StudentDetailServlet std_id====="+std_id);
		
		
		//service 학생 정보를 조회
		StudentServiceInf studentService = new StudentService();
		StudentVo studentVo= studentService.getStudentById(std_id);
		
		//request 객체에 저장
		
		request.setAttribute("studentVo", studentVo);
		
		//student/studentDetail.jsp로 위임
		request.getRequestDispatcher("/student/studentDetail.jsp").forward(request, response);
	}
}
