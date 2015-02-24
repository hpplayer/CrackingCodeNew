package Chapter8_4_sol2;

public class Level {
	private int availableSpots = 0;
	private int floor;
	private ParkingSpot[] spots;
	private static final int SPOTS_PER_ROW = 10;

	public Level(int flr, int numberSpots) {
		floor = flr;
		spots = new ParkingSpot[numberSpots];
		int largeSpots = numberSpots / 4;
		int bikeSpots = numberSpots / 4;
		int compactSpots = numberSpots - largeSpots - bikeSpots;// similar idea
																// like mine,
																// yeah!!
		for (int i = 0; i < numberSpots; i++) {
			VehicleSize sz = VehicleSize.Motorcycle;// spot for Motorcycle
			if (i < largeSpots) {
				sz = VehicleSize.Large;// spot for larger
			} else if (i < largeSpots + compactSpots) {
				sz = VehicleSize.Compact;// spot for Compact
			}

			int row = i / SPOTS_PER_ROW;
			spots[i] = new ParkingSpot(sz, row, i, this);
		}
		availableSpots = numberSpots;
	}

	public int availableSpots() {
		return availableSpots;
	}

	public boolean parkVehicle(Vehicle vehicle){
		if(availableSpots() < vehicle.getSpotsNeeded()){
			return false;
		}
		int spotNumber = findAvailableSpots(vehicle);
		if(spotNumber < 0){
			return false;
		}
		return parkStartingAtSpot(spotNumber, vehicle);
	}
	private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle){
		vehicle.clearSpots();
		boolean success = true;
		for(int i = spotNumber; i < spotNumber + vehicle.spotsNeeded; i++){
			success &= spots[i].park(vehicle);//if cant fit car, success = false
		}
		availableSpots -= vehicle.spotsNeeded;
		return success;
	}
	private int findAvailableSpots(Vehicle vehicle) {
		int spotsNeeded = vehicle.getSpotsNeeded();
		int lastRow = -1;
		int spotsFound = 0;
		for (int i = 0; i < spots.length; i++) {
			ParkingSpot spot = spots[i];
			if (lastRow != spot.getRow()) {
				spotsFound = 0;
				lastRow = spot.getRow();
			}
			if (spot.canFitVehicle(vehicle)) {
				spotsFound++;
			} else {
				spotsFound = 0;
			}
			if (spotsFound == spotsNeeded) {
				return i - (spotsNeeded - 1);
			}
		}
		return -1;
	}

	public void spotFeed() {
		availableSpots++;
	}
}
