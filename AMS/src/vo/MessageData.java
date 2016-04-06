package vo;

import com.sun.jmx.snmp.Timestamp;

public class MessageData {
	int messageNum;
	int senderUserNum;
	int receiverUserNum;
	String messageContent;
	Timestamp messageDate;
	public int getMessageNum() {
		return messageNum;
	}
	public void setMessageNum(int messageNum) {
		this.messageNum = messageNum;
	}
	public int getSenderUserNum() {
		return senderUserNum;
	}
	public void setSenderUserNum(int senderUserNum) {
		this.senderUserNum = senderUserNum;
	}
	public int getReceiverUserNum() {
		return receiverUserNum;
	}
	public void setReceiverUserNum(int receiverUserNum) {
		this.receiverUserNum = receiverUserNum;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Timestamp getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Timestamp messageDate) {
		this.messageDate = messageDate;
	}
}
