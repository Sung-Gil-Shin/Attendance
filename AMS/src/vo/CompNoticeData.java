package vo;

import com.sun.jmx.snmp.Timestamp;

public class CompNoticeData {
	int compNoticeNum;
	int userNum;
	String compNoticeTitle;
	String compNoticeContent;
	Timestamp compNoticeDate;
	public int getCompNoticeNum() {
		return compNoticeNum;
	}
	public void setCompNoticeNum(int compNoticeNum) {
		this.compNoticeNum = compNoticeNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getCompNoticeTitle() {
		return compNoticeTitle;
	}
	public void setCompNoticeTitle(String compNoticeTitle) {
		this.compNoticeTitle = compNoticeTitle;
	}
	public String getCompNoticeContent() {
		return compNoticeContent;
	}
	public void setCompNoticeContent(String compNoticeContent) {
		this.compNoticeContent = compNoticeContent;
	}
	public Timestamp getCompNoticeDate() {
		return compNoticeDate;
	}
	public void setCompNoticeDate(Timestamp compNoticeDate) {
		this.compNoticeDate = compNoticeDate;
	}
}
