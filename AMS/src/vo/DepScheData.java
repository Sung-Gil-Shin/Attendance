package vo;

import com.sun.jmx.snmp.Timestamp;

public class DepScheData {
	int depScheNum;
	int depNum;
	int userNum;
	String depScheContent;
	Timestamp depScheDate;
	public int getDepScheNum() {
		return depScheNum;
	}
	public void setDepScheNum(int depScheNum) {
		this.depScheNum = depScheNum;
	}
	public int getDepNum() {
		return depNum;
	}
	public void setDepNum(int depNum) {
		this.depNum = depNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getDepScheContent() {
		return depScheContent;
	}
	public void setDepScheContent(String depScheContent) {
		this.depScheContent = depScheContent;
	}
	public Timestamp getDepScheDate() {
		return depScheDate;
	}
	public void setDepScheDate(Timestamp depScheDate) {
		this.depScheDate = depScheDate;
	}
	
}
