package Chapter8_4_sol2;

public class Bus extends Vehicle{
	public Bus(){
		spotsNeeded = 5;
		size = VehicleSize.Large;
	}
	
	public boolean canFitInSpot(ParkingSpot spot){
		return spot.getSpotSize() == VehicleSize.Large;
	}
	
}
