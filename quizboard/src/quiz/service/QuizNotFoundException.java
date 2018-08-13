package quiz.service;

public class QuizNotFoundException extends ServiceException {
	
	public QuizNotFoundException(String game) {
		super(game);
	}
}
