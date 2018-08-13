package quiz.service;

public class InvalidException extends ServiceException {

	public InvalidException(String game) {
		super(game);
	}
}
