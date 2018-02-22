package org.dselent.course_load_scheduler.client.action;

public class SendRemoveAccountAction extends Action {
	private String accountInfo;
	
	public SendRemoveAccountAction(String accountInfo) {
		this.accountInfo = accountInfo;
	}
	
	public String getAccountInfo() {
		return accountInfo;
	}
	public void setAccountInfo(String accountInfo) {
		this.accountInfo = accountInfo;
	}

	@Override
	public String toString() {
		return "SendRemoveAccountAction [accountInfo=" + accountInfo + "]";
	}
	
}
