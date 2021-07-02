package miniProgram;

import java.time.LocalDate;

import miniProgram.restrictedCar.Car;
import miniProgram.restrictedCar.CarFreeDay;
import miniProgram.restrictedCar.ExceptionCondition;

public class RunRestrictedCar {
	public static void main(String[] args) {
		String licenseNumOfCar = "00°¡1234";
		ExceptionCondition except = ExceptionCondition.disability;
		
		Car myCar = new Car(licenseNumOfCar);
		
		LocalDate date = LocalDate.of(2031,7,3);
		CarFreeDay free = new CarFreeDay(date, myCar);
		
		free.isAccessable();
	}

}
