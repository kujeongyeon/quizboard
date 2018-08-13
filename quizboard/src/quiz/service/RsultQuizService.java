package quiz.service;

import java.sql.*;
import quiz.dao.*;
import quiz.model.*;
import jdbc.JdbcUtil;
import jdbc.ConnectionProvider;

public class RsultQuizService {

	private static RsultQuizService instance = new RsultQuizService();
	
	public static RsultQuizService getInstance () {
		return instance;
	}

	private RsultQuizService() {}
	
	public void rsult(int quizId, String answer) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
	
			GameDao gameDao = GameDao.getInstance();
			Game game = gameDao.select(conn, quizId);
			if(game == null) {
				throw new QuizNotFoundException("메시지 없음");
			}
			if(!game.matchAnswer(answer)) {
				throw new InvalidException("틀렸습니다!");
			}
			
		} finally {
		JdbcUtil.close(conn);
		}
	}
}
