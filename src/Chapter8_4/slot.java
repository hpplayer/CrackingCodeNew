package Chapter8_4;

public abstract class slot {
	int id;
	double length;
	double width;
	vehicle currentVehicle;
	
	boolean isFree(){
			return currentVehicle == null;
	}
	
	public int getId() {
		return id;
	}
	public vehicle getCurrentVehicle() {
		return currentVehicle;
	}

	public void setCurrentVehicle(vehicle currentVehicle) {
		this.currentVehicle = currentVehicle;
	}

	public void setId(int id) {
		this.id = id;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
	
}
