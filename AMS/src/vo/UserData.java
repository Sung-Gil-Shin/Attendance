package vo;

public class UserData {
	int userNum;
	String name;
	int socialNumPre;
	int socialNumPost;
	String id;
	String passwd;
	int phoneNum;
	String email;
	int depNum;
	int permission;
	boolean loginFlag;
	boolean currentStatus;
	public UserData(){
		
	}
	
	public UserData(String id,String passwd){
		this.id = id;
		this.passwd = passwd;
	}
	public UserData(String id,String passwd,String name,int socialNumPre,
			int socialNumPost,String email,int phoneNum){
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.socialNumPre = socialNumPre;
		this.socialNumPost = socialNumPost;
		this.email = email;
		this.phoneNum = phoneNum;
	}
	
	
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDepNum() {
		return depNum;
	}
	public void setDepNum(int depNum) {
		this.depNum = depNum;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public boolean isLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(boolean loginFlag) {
		this.loginFlag = loginFlag;
	}
	public boolean isCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(boolean currentStatus) {
		this.currentStatus = currentStatus;
	}
	public int getSocialNumPre() {
		return socialNumPre;
	}
	public void setSocialNumPre(int socialNumPre) {
		this.socialNumPre = socialNumPre;
	}
	public int getSocialNumPost() {
		return socialNumPost;
	}
	public void setSocialNumPost(int socialNumPost) {
		this.socialNumPost = socialNumPost;
	}
}
