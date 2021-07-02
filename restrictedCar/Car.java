package miniProgram.restrictedCar;



public class Car {
	private String licenseNumOfCar;
	private int maxPeople;
	private ExceptionCondition except;
	
	public Car(String licenseNumOfCar) {
		this.licenseNumOfCar = licenseNumOfCar;
		this.except = ExceptionCondition.None;
	}
	public Car(String licenseNumOfCar, ExceptionCondition except) {
		this.licenseNumOfCar = licenseNumOfCar;
		this.except = except;
	}
	public Car(String licenseNumOfCar, int maxPeople, ExceptionCondition except) {
		this.licenseNumOfCar = licenseNumOfCar;
		this.maxPeople = maxPeople;
		this.except = except;
	}
	
	public int getlastOflicenseNumber() {
		return Integer.parseInt(""+licenseNumOfCar.charAt(licenseNumOfCar.length() - 1));
	}
	
	public ExceptionCondition getExceptCondition() {
		return except;
	}
	
	@Override
	public String toString() {
		return "차량번호 ["+licenseNumOfCar+"], 제외조건 ["+except+"]";
	}

}
