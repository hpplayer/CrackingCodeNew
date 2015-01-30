package Chapter8_7_sol2;

public class UserStatus {
	private String message;
	private UserStatusType type;
	public UserStatus(String message, UserStatusType type) {
		super();
		this.message = message;
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public UserStatusType getType() {
		return type;
	}
	
	
}
