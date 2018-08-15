package quiz.service;

import java.sql.Connection;
import java.sql.SQLException;
import quiz.dao.*;
import quiz.model.*;
import jdbc.JdbcUtil;
import jdbc.ConnectionProvider;

public class DeleteQuizService {

	private static DeleteQuizService instance = new DeleteQuizService();
	
	public static DeleteQuizService getInstance() {
		return instance;
	}
	private DeleteQuizService() {}
	
	public void delete(int quizId,String password) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			GameDao gameDao = GameDao.getInstance();
			Game game = gameDao.select(conn, quizId);
			if(game == null) {
				throw new QuizNotFoundException("메세지없음");
			}
			if(!game.matchPassword(password)) {
				throw new InvalidException ("bad password");
			}
			gameDao.delete(conn, quizId);
			conn.commit();
		}catch(SQLException ex) {
			JdbcUtil.rollback(conn);
		}finally {
			JdbcUtil.close(conn);
		}
	}
}
