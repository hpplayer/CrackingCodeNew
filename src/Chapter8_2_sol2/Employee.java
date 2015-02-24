package Chapter8_2_sol2;

abstract class Employee {
	private Call currentCall = null;
	protected Rank rank;

	public Employee() {
	}

	public void receiveCall(Call call) {
		currentCall = call;
	}

	// both callCompleted and escalateAndReassign will trigger assignNewCall()
	public void callCompleted() {
		if (currentCall != null) {
			currentCall.disconnect();
			currentCall = null;
		}

		assignNewCall();
	}

	public void escalateAndReassign() {
		if (currentCall != null) {
			currentCall.incrementRank();
			CallHandler.getInstance().dispatchCall(currentCall); // start with
																	// call not
																	// caller?

			currentCall = null;
		}

		assignNewCall();
	}

	public boolean assignNewCall() {
		if (!isFree()) {
			return false;
		}
		return CallHandler.getInstance().assignCall(this);
	}

	public boolean isFree() {
		return currentCall == null;
	}

	public Rank getRank() {
		return rank;
	}
}
