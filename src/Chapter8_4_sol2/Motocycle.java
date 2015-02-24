package Chapter8_4_sol2;

public class Motocycle extends Vehicle{
	public Motocycle(){
		spotsNeeded = 1;
		size = VehicleSize.Motorcycle;
	}
	
	public boolean canFitInSpot(ParkingSpot spot){
		return true;//can park any spot
	}
	
}
