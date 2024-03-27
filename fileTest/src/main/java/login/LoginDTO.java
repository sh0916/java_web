package login;

public class LoginDTO {

	String userId;
	String userPass;
	String imgName;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", userPass=" + userPass + ", imgName=" + imgName + "]";
	}
}
