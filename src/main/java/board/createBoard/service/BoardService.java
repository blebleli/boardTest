package board.createBoard.service;

import java.util.List;

import board.createBoard.dao.BoardDao;
import board.createBoard.model.BoardVo;
import board.student.dao.StudentDao;
import board.student.dao.StudentDaoInf;

public class BoardService implements BoardServiceInf{

	BoardDao boardDao = new BoardDao();
	
	@Override
	public List<BoardVo> getAllBoards() {
		// TODO Auto-generated method stub
		return boardDao.getAllBoards();
	}

	@Override
	public BoardVo getBoardById(int b_id) {
		// TODO Auto-generated method stub
		return boardDao.getBoardById(b_id);
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return boardDao.updateBoard(boardVo);
	}

	@Override
	public int insertBoard(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return boardDao.insertBoard(boardVo);
	}

}
