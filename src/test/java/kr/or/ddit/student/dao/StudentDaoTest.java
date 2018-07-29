package kr.or.ddit.student.dao;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import board.student.dao.StudentDao;
import board.student.dao.StudentDaoInf;
import board.student.model.StudentVo;

public class StudentDaoTest {

	
	//테스트 메소드 안에 중복되는 내용 : student Dao 구현체에 대한 생성 로직
	// --> before 어노테이션이 붙은 setup메소드에 위임
	//모든 테스트 메소드에서 StudentDao 객체를 참조할 수 있게끔 클래스 변수로 생성할 필요가 있고
	//클래스 변수를 setup 메소드에서 초기화하는 로직이 필요
	//테스트 메소드에서 생성했던 StudentDao를 생성하는 로직은 삭제
	
	private StudentDaoInf studentDao;
	
	//@before - test - after
	@Before
	public void setup(){
		 studentDao = new StudentDao();
		
	}

	/**
	 * 
	 * Method   : selectAllStudentsTest 
	 * 최초작성일  : 2018. 7. 10. 
	 * 작성자 : PC06 
	 * 변경이력 :  
	 * Method 설명 : 전체 학생 정보를 조회한다.
	 */
	@Test
	public void selectAllStudentsTest() {
		/***Given***/

		/***When***/
		List<StudentVo> studentList = studentDao.getAllStudents();
		
		for (StudentVo vo : studentList) {
			System.out.println(vo);
		}
		/***Then***/
		assertEquals(25, studentList.size());
	}
	
	/**
	 * 
	 * Method   : selectStudentsById 
	 * 최초작성일  : 2018. 7. 10. 
	 * 작성자 : PC06 
	 * 변경이력 :  
	 * Method 설명 : 학생정보조회 test
	 */ 
	@Test
	public void selectStudentsById() {
		/***Given***/
		String std_id = "std_1";
		
		/***When***/
		StudentVo student = studentDao.getStudentById(std_id);
		System.out.println("selectStudentsById : "+ student);
		
		/***Then***/
		assertEquals("김마음", student.getName());
	}
	
	
	/**
	 * 
	 * Method   : selectStudentsById 
	 * 최초작성일  : 2018. 7. 10. 
	 * 작성자 : PC06 
	 * 변경이력 :  
	 * Method 설명 : 학생정보조회 test
	 */ 
	@Test
	public void selectStudentsByVo() {
		/***Given***/
		StudentVo studentVo = new StudentVo();
		String std_id = "std_1";
		studentVo.setStd_id(std_id);
		
		/***When***/
		StudentVo student = studentDao.getStudentByVo(studentVo);

		System.out.println("selectStudentsByVo : "+ student);
		
		/***Then***/
		assertEquals("김마음", student.getName());
	}
	

	@Test
	public void getStudentPageList() {
		/***Given***/
		//StudentVo paramVo = new StudentVo();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 3);
		map.put("pageSize", 10);
		
		/***When***/
		List<StudentVo> student = studentDao.getStudentPageList(map);
		
		for (StudentVo vo : student) {
			System.out.println("pageSize : "+vo);
		}
		
		/***Then***/
		assertEquals(5, student.size());
	}
	
	@Test
	public void getStudentTotCnt() {
		/***Given***/

		/***When***/
		int studentCnt = studentDao.getStudentTotCnt();
		
		/***Then***/
		assertEquals(25,studentCnt );
	}
	
}
