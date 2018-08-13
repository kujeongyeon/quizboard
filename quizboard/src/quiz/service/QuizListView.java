package quiz.service;

import java.util.List;
import quiz.model.Game;

public class QuizListView {

	private int gameTotalCount;
	private int currentPageNumber;
	private List<Game> gameList;
	private int pageTotalCount;
	private int gameCountPerPage;
	private int firstRow;
	private int endRow;
	
	public QuizListView(List<Game> gameList,int gameTotalCount, int currentPageNumber,
			int gameCountPerPage, int firstRow ,int endRow) {
		this.gameList = gameList;
		this.gameTotalCount = gameTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.gameCountPerPage = gameCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;

		calculatePageTotalCount();

	}
	
	private void calculatePageTotalCount() {
		if(gameTotalCount == 0) {
			pageTotalCount = 0;
		}else {
			pageTotalCount = gameTotalCount / gameCountPerPage;
			if(gameTotalCount % gameCountPerPage > 0) {
				pageTotalCount ++;
			}
		}
	}
	
	public int getGameTotalCount() {
		return gameTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<Game> getGameList() {
		return gameList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getGameCountPerPage() {
		return gameCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}
	public boolean isEmpty() {
		return gameTotalCount == 0;
	}

}
