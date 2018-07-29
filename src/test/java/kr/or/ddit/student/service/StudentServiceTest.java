package kr.or.ddit.student.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import board.student.model.StudentVo;
import board.student.service.StudentService;
import board.student.service.StudentServiceInf;

public class StudentServiceTest {

	private StudentServiceInf studentService;
	
	//@before - test - after
	@Before
	public void setup(){
		studentService = new StudentService();
	}
	
	
	@Test
	public void selectAllStudents() {

		/***Given***/

		/***When***/
		List<StudentVo> stdList = studentService.getAllStudents();
		for(StudentVo vo : stdList){
			System.out.println(vo);
		}
		
		/***Then***/
		assertEquals(25, stdList.size());
	}
	
	@Test
	public void selectStudentsById(){
		
		/***Given***/
		String std_id = "std_14";
		
		/***When***/
		StudentVo stdVo = studentService.getStudentById(std_id);
		
		/***Then***/
		assertEquals("한수정",stdVo.getName()) ;
	}
	
	
	@Test
	public void selectStudentsByVo(){
		
		/***Given***/
		StudentVo studentVo = new StudentVo();
		studentVo.setStd_id("std_14");
		
		/***When***/
		StudentVo stdVo = studentService.getStudentByVo(studentVo);
		
		/***Then***/
		assertEquals("한수정",stdVo.getName()) ;
	}
	
	

	@Test
	public void getStudentPageList(){
		
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 3);
		map.put("pageSize", 10);
		
		/***When***/
		Map<String, Object> resultMap = studentService.getStudentPageList(map);
		
		//학생 페이지 리스트
		List<StudentVo> pageList = (List<StudentVo>)resultMap.get("pageList");
		//학생 전체 건수
		int totCnt = (int)resultMap.get("totCnt");
		
		/***Then***/
		assertEquals(5,pageList.size()) ;
		assertEquals(25,totCnt) ;
		
	}
	
	@Test
	public void calculatePageNavi(){
		/***Given***/
		int totCnt = 25;
		int pageSize = 10;

		int cnt = totCnt / pageSize;
		int mod = totCnt % pageSize;
		if(mod>0) cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer();

		
		for(int i=1; i<=cnt; i++){
			pageNaviStr.append("<li><a href=\"#\">"+i+"</a></li>");

		}		

		
		/***Then***/

	}
	
	
	
	
	

}
