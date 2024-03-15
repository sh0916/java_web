package loginSession;

public class LoginDTO {

	String userId;
	String UserPass;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userPass
	 */
	public String getUserPass() {
		return UserPass;
	}
	/**
	 * @param userPass the userPass to set
	 */
	public void setUserPass(String userPass) {
		UserPass = userPass;
	}
}
