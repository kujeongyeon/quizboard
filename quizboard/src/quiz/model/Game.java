package quiz.model;

public class Game {
	
	private int id;
	private String quiz;
	private String answer;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuiz() {
		return quiz;
	}
	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean hasPassword() {
		return password !=null && !password.isEmpty();
	}
	
	public boolean hasAnswer() {
		return answer !=null && !answer.isEmpty();
	}
	public boolean matchPassword(String pwd) {
		return password != null & password.equals(pwd);
	}
	public boolean matchAnswer(String ans) {
		return ans != null & answer.equals(ans);
	}
	

}
