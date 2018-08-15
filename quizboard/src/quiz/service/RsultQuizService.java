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
	
	public void rsult(int quizId, String answer) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			GameDao gameDao = GameDao.getInstance();
			Game game = gameDao.select(conn, quizId);
			if(game == null) {
				throw new QuizNotFoundException("메세지없음");
			}
			if(!game.matchAnswer(answer)) {
				throw new InvalidException ("bad password");
			}
		}catch(SQLException e){
				throw new ServiceException("실패:"+e.getMessage(), e);
			} finally {
		JdbcUtil.close(conn);
		}
	}

}
	