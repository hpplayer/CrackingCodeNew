package Chapter8_4_sol2;

import java.util.ArrayList;

public abstract class Vehicle {
	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	protected int spotsNeeded;//how many spots needed for this vehicle
	protected VehicleSize size;
	
	public VehicleSize getSize(){
		return size;
	}
	public abstract boolean canFitInSpot(ParkingSpot spot);
	
	public int getSpotsNeeded(){
		return spotsNeeded;
	}
	
	public void parkInSpot(ParkingSpot spot){
		parkingSpots.add(spot);
	}
	
	public void clearSpots(){
		for(int i = 0; i < parkingSpots.size(); i++){
			parkingSpots.get(i).removeVehicle();
		}
		parkingSpots.clear();
	}
}
