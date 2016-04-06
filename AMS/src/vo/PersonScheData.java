package vo;

import com.sun.jmx.snmp.Timestamp;

public class PersonScheData {
	int userScheNum;
	int userNum;
	String userScheContent;
	Timestamp userScheDate;
	public int getUserScheNum() {
		return userScheNum;
	}
	public void setUserScheNum(int userScheNum) {
		this.userScheNum = userScheNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getUserScheContent() {
		return userScheContent;
	}
	public void setUserScheContent(String userScheContent) {
		this.userScheContent = userScheContent;
	}
	public Timestamp getUserScheDate() {
		return userScheDate;
	}
	public void setUserScheDate(Timestamp userScheDate) {
		this.userScheDate = userScheDate;
	}
}
