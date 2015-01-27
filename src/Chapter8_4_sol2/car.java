package Chapter8_4_sol2;

public class car extends Vehicle{
	public car(){
		spotsNeeded = 1;
		size = VehicleSize.Compact;
	}
	
	public boolean canFitInSpot(ParkingSpot spot){
		return spot.getSpotSize() == VehicleSize.Compact || spot.getSpotSize() ==VehicleSize.Large;
	}
}
