package Chapter8_4_sol2;

public class ParkingSpot {
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;
	
	public ParkingSpot(VehicleSize spotSize, int row,
			int spotNumber, Level level) {
		this.spotSize = spotSize;
		this.row = row;
		this.spotNumber = spotNumber;
		this.level = level;
	}
	
	public boolean isFree(){
		return vehicle == null;
	}
	
	public boolean canFitVehicle(Vehicle v){
		return isFree() && v.canFitInSpot(this);
	}
	
	public boolean park(Vehicle v){
		if(!canFitVehicle(v)){
			return false;
		}
		
		vehicle = v;
		vehicle.parkInSpot(this);
		return true;
	}

	public VehicleSize getSpotSize() {
		return spotSize;
	}

	public int getRow() {
		return row;
	}

	public int getSpotNumber() {
		return spotNumber;
	}
	
	public void removeVehicle(){
		level.spotFeed();
		vehicle = null;
	}
}
