package Chapter8_4;

public enum vehicleType {

	disabled(2), emergency(1), general(0);
	
	private int value;

	private vehicleType(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}


}
