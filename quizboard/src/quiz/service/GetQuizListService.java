package quiz.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import quiz.dao.*;
import quiz.model.*;
import jdbc.JdbcUtil;
import jdbc.ConnectionProvider;
public class GetQuizListService {
	private static GetQuizListService instance = new GetQuizListService();
	
	public static GetQuizListService getInstance() {
		return instance;
	}
	private GetQuizListService() {}
	
	private static final int GAME_COUNT_PER_PAGE = 3;
	
	public QuizListView getQuizList(int pageNumber) {
		Connection conn = null;
		int currentPageNumber = pageNumber;
		try {
			conn = ConnectionProvider.getConnection();
			GameDao gameDao = GameDao.getInstance();
			
			int gameTotalCount = gameDao.selectCount(conn);
			
			List<Game> gameList = null;
			int firstRow = 0;
			int endRow = 0;
			if (gameTotalCount > 0) {
				firstRow =
						(pageNumber -1)*GAME_COUNT_PER_PAGE + 1;
				endRow = firstRow + GAME_COUNT_PER_PAGE - 1;
				gameList = gameDao.selectList(conn, firstRow, endRow);
			}else {
				currentPageNumber = 0;
				gameList = Collections.emptyList();
			}
			return new QuizListView(gameList,gameTotalCount,currentPageNumber,
					GAME_COUNT_PER_PAGE,firstRow,endRow);
		} catch (SQLException e) {
			throw new ServiceException("목록 구하기 실패:" + e.getMessage(), e);
		}finally {
			JdbcUtil.close(conn);
		}
	}

	
}
