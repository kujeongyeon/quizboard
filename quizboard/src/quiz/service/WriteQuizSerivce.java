package quiz.service;

import java.sql.*;
import quiz.dao.*;
import quiz.model.*;
import jdbc.JdbcUtil;
import jdbc.ConnectionProvider;

public class WriteQuizSerivce {

	private static WriteQuizSerivce instance = new WriteQuizSerivce();
	
	public static WriteQuizSerivce getInstance() {
		return instance;
	}
	private WriteQuizSerivce() {
	}
	
	public void write(Game game) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			GameDao gameDao = GameDao.getInstance();
			gameDao.insert(conn, game);
		}catch(SQLException e){
			throw new ServiceException("메시지 등록 실패:"+e.getMessage(), e);
		}finally {
			JdbcUtil.close(conn);
		}
	}
}
