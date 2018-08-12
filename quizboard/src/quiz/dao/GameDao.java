package quiz.dao;

import quiz.model.*;
import sun.invoke.empty.Empty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jdbc.JdbcUtil;

public class GameDao {
	
	private static GameDao gamedao = new GameDao();
	public static GameDao getInstance() {
		return gamedao;
	}

	private GameDao() {}
	
	public int insert(Connection conn, Game game) throws SQLException{
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"insert into quizboard_collection "+
					"(quiz,answer,password) values(?,?,?)");
			pstmt.setString(1,game.getQuiz());
			pstmt.setString(2, game.getAnswer());
			pstmt.setString(3,game.getPassword());
			
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public Game select (Connection conn, int quizId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from quizboard_collection where quiz_id = ?");
			pstmt.setInt(1, quizId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return makeQuizFromResultSet(rs);
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
	}

	private Game makeQuizFromResultSet(ResultSet rs) throws SQLException{
		Game game = new Game();
		game.setId(rs.getInt("quiz_id"));
		game.setQuiz(rs.getString("quiz"));
		game.setAnswer(rs.getString("answer"));
		game.setPassword(rs.getString("password"));
		return game;
	}
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select count(*) from quizboard_collection");
			rs.next();
			return rs.getInt(1);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public List<Game> selectList(Connection conn, int firstRow, int endRow) throws SQLException{
	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(
					"select * from quizboard_collection order by quiz_id desc limit ?,?)");
			pstmt.setInt(1, firstRow - 1);
			pstmt.setInt(2, endRow - firstRow + 1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				List<Game> gameList = new ArrayList<Game>();
				do {
					gameList.add(makeQuizFromResultSet(rs));
				} while (rs.next());
				return Collections.emptyList();
			}
		}
		
	}
}
