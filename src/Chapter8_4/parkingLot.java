package Chapter8_4;

import java.util.ArrayList;

public class parkingLot {
	//remember add final !!!!!!!!!!!!!!!!!
	final int numOfslots = 100;
	final int numOfdiabledSlot = 10;
	final int numOfemergSlot = 5;
	final int numOfgeneralSlot = (numOfslots - numOfdiabledSlot - numOfemergSlot);

	/*
	 * use a matrix arraylist to store different parking slots
	 */
	ArrayList<ArrayList<slot>> slots;
	ArrayList<slot> generalslots;
	ArrayList<slot> emergencySlots;
	ArrayList<slot> disabledSlots;

	public parkingLot() {
		slots = new ArrayList<ArrayList<slot>>(numOfslots);
		generalslots = new ArrayList<slot>(numOfdiabledSlot);
		emergencySlots = new ArrayList<slot>(numOfemergSlot);
		disabledSlots = new ArrayList<slot>(numOfgeneralSlot);
		slots.add(vehicleType.general.getValue(), generalslots);
		slots.add(vehicleType.emergency.getValue(), emergencySlots);
		slots.add(vehicleType.disabled.getValue(), disabledSlots);
	}

	boolean clearSlot(slot s){
		if(s.getCurrentVehicle() == null) return false;
		vehicleType vt= s.getCurrentVehicle().getType();
		slots.get(vt.getValue()).get(s.getId()).setCurrentVehicle(null);
		return true;
	}
	
	boolean assignGeneralSlot(vehicle v) {
		for (slot s : slots.get(vehicleType.general.getValue())) {
			if (s.isFree()) {
				s.setCurrentVehicle(v);
				return true;
			}
		}
		return false;
	}
	
	boolean assignEmergSlot(vehicle v) {
		if(v.getType() != vehicleType.emergency) return false;
		
		for (slot s : slots.get(vehicleType.emergency.getValue())) {
			if (s.isFree()) {
				s.setCurrentVehicle(v);
				return true;
			}
		}
		return false;
	}
	
	boolean assignDisabledSlot(vehicle v) {
		for (slot s : slots.get(vehicleType.disabled.getValue())) {
			if (s.isFree()) {
				s.setCurrentVehicle(v);
				return true;
			}
		}
		return false;
	}

}
