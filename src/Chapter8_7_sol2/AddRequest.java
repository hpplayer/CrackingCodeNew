package Chapter8_7_sol2;

import java.util.Date;

public class AddRequest {
	private User fromUser;
	private User toUser;
	private Date date;
	RequestStatus status;
	
	public AddRequest(User from, User to, Date date){
		fromUser = from;
		toUser = to;
		this.date = date;
		status = RequestStatus.unread;
	}

	public User getFromUser() {
		return fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public Date getDate() {
		return date;
	}

	public RequestStatus getStatus() {
		return status;
	}
	

}
