package vo;

import com.sun.jmx.snmp.Timestamp;

public class CompScheData {
	int compScheNum;
	int userNum;
	String compScheContent;
	Timestamp compScheDate;
	public int getCompScheNum() {
		return compScheNum;
	}
	public void setCompScheNum(int compScheNum) {
		this.compScheNum = compScheNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getCompScheContent() {
		return compScheContent;
	}
	public void setCompScheContent(String compScheContent) {
		this.compScheContent = compScheContent;
	}
	public Timestamp getCompScheDate() {
		return compScheDate;
	}
	public void setCompScheDate(Timestamp compScheDate) {
		this.compScheDate = compScheDate;
	}
	
}
