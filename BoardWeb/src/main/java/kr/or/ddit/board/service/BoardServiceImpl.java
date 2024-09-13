package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.mybatis.MyBatisDao;

public class BoardServiceImpl implements IBoardService {

	private static BoardServiceImpl instance;

	private BoardServiceImpl() {

	}

	public static BoardServiceImpl getInstacne() {
		if (instance == null) {
			instance = new BoardServiceImpl();
		}
		return instance;
	}

	IBoardDao boardDao = BoardDaoImpl.getInstacne();
	
	@Override
	public List<BoardVo> cateList() {
		return boardDao.cateList();
	}

	@Override
	public List<BoardVo> boardList(BoardVo board) {
		return boardDao.boardList(board);
	}

}
