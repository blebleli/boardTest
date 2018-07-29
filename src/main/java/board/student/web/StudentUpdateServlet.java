package board.student.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import board.boardFile.web.FileUtil;
import board.student.model.StudentVo;
import board.student.service.StudentService;
import board.student.service.StudentServiceInf;

/**
 * Servlet implementation class StudentUpdateViewServlet
 */
@WebServlet("/studentUpdate")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//학생정보수정화면
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//학생 id를 파라미터 확인
		String std_id = request.getParameter("std_id");
		
		//service 학생 정보를 조회
		StudentServiceInf studentService = new StudentService();
		StudentVo studentVo= studentService.getStudentById(std_id);
		
		//request 객체에 저장
		request.setAttribute("studentVo", studentVo);
		
		//student/studentDetail.jsp로 위임
		request.getRequestDispatcher("/student/studentUpdate.jsp").forward(request, response);
	}
	
	
	
	//학생정보수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//파라미터 확인
	    String std_id = request.getParameter("std_id");
	    String name  = request.getParameter("name");
	    String addr1 = request.getParameter("addr1");
	    String addr2 = request.getParameter("addr2");
	    String zipcd = request.getParameter("zipcd");
	    
	    Part picPart = request.getPart("pic");
	     
		//학생정보조회
		StudentServiceInf studentService = new StudentService();
		StudentVo studentVo = studentService.getStudentById(std_id);
		
		System.out.println("StudentUpdateServlet studentVo==============" + studentVo);
		
		
		
		//파라미터로 받은 값을 vo에 설정
		studentVo.setName(name);
		studentVo.setAddr1(addr1);
		studentVo.setAddr2(addr2);
		studentVo.setZipcd(zipcd);
		
		//신규이미지로 업데이트 하는경우
		if (picPart.getSize() >0) {
			//업로드 당시 파일명 (pic)
			
			String contentDisposition = picPart.getHeader("Content-Disposition");
			String pic = FileUtil.getFileName(contentDisposition);
			String picpath = FileUtil.fileUploadPath;
			String picname = UUID.randomUUID().toString();
			
			studentVo.setPic(pic);
			studentVo.setPicpath(picpath);
			studentVo.setPicname(picname);
			

			picPart.write(picpath + File.separator + picname);
			picPart.delete();
			//uuid를 통해 임의의 파일명을 하나 작성(picname)
			//업로드 할 경로(FileUtil.uploadPath)
		}
		
		//학생정보 업데이트
		studentService.studentUpdate(studentVo);
	
		// 학생정보 상세조회 화면으로 
		response.sendRedirect("/student/studentDetail.jsp?std_id="+std_id);
		
	}
}
