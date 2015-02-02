package Chapter8_9;

public enum Rank {
	MostRecent(3), MidRecent(2), LeastRecent(1);
	private int value;

	public int getValue() {
		return value;
	}

	 Rank(int value) {
		this.value = value;
	}

	
}
