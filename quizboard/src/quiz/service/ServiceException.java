package quiz.service;

public class ServiceException extends RuntimeException{

	public ServiceException(String game,Exception cause) {
		super(game,cause);
	}
	public ServiceException(String game) {
		super(game);
	}
}
