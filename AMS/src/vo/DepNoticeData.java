package vo;

import com.sun.jmx.snmp.Timestamp;

public class DepNoticeData {
	int depNoticeNum;
	int depNum;
	int userNum;
	String depNoticeTitle;
	String depNoticeContent;
	Timestamp depNoticeDate;
	public int getDepNoticeNum() {
		return depNoticeNum;
	}
	public void setDepNoticeNum(int depNoticeNum) {
		this.depNoticeNum = depNoticeNum;
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
	public String getDepNoticeTitle() {
		return depNoticeTitle;
	}
	public void setDepNoticeTitle(String depNoticeTitle) {
		this.depNoticeTitle = depNoticeTitle;
	}
	public String getDepNoticeContent() {
		return depNoticeContent;
	}
	public void setDepNoticeContent(String depNoticeContent) {
		this.depNoticeContent = depNoticeContent;
	}
	public Timestamp getDepNoticeDate() {
		return depNoticeDate;
	}
	public void setDepNoticeDate(Timestamp depNoticeDate) {
		this.depNoticeDate = depNoticeDate;
	}
}
