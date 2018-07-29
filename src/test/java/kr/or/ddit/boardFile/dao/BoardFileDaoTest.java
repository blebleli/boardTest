package kr.or.ddit.boardFile.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import board.boardFile.dao.BoardFileDaoInf;
import board.boardFile.model.BoardFileVo;
import board.student.dao.StudentDao;

class BoardFileDaoTest {

		private BoardFileDaoInf boardFileDao;
	//@before - test - after
		@Before
		public void setup(){
			 studentDao = new StudentDao();
			
		}
	
	
	@Test
	public List<BoardFileVo> getAllFiles(int w_id) {
	
	}

	@Override
	public int countFile(int w_id) {

	}

	@Override
	public BoardFileVo getFileById(int f_id) {
	
	}

	@Override
	public int updateFile(BoardFileVo boardFileVo) {

	}

	@Override
	public int insertFile(BoardFileVo boardFileVo) {

	}


}
