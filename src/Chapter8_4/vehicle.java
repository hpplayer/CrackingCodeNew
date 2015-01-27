package Chapter8_4;

public class vehicle {
	int LicencePlate;
	double length;
	double width;
	vehicleType type;
	
	public int getLicencePlate() {
		return LicencePlate;
	}
	public void setLicencePlate(int licencePlate) {
		LicencePlate = licencePlate;
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
	public vehicleType getType() {
		return type;
	}
	public void setType(vehicleType type) {
		this.type = type;
	}
}
