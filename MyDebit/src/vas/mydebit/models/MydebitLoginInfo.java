package vas.mydebit.models;

public class MydebitLoginInfo {
	
	private int userId;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	private String  userName;
	private String  password;
	private int securityIndex;
	private String securityAnswer;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSecurityIndex() {
		return securityIndex;
	}
	public void setSecurityIndex(int securityIndex) {
		this.securityIndex = securityIndex;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	
	
	

}
