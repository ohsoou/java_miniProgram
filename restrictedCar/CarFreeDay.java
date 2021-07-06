package miniProgram.restrictedCar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarFreeDay {
	/*
	 * 끝번호
	 * 
	 * 월 1 6
	 * 화 2 7
	 * 수 3 8
	 * 목 4 9
	 * 금 5 0
	 * 공휴일 제외
	 * 특수 조건 차량 제외
	 * 
	 * */
	
	private static Map<DayOfWeek, List<Integer>> carFreeCondition;
	private static List<Integer> availableLastNumberList;
	private static List<String> holiday;
	private Car myCar;
	private LocalDate date;
	
	static {
		carFreeCondition = new HashMap<>();
		carFreeCondition.put(DayOfWeek.MONDAY, new ArrayList<>(Arrays.asList(1,6)));
		carFreeCondition.put(DayOfWeek.TUESDAY, new ArrayList<>(Arrays.asList(2,7)));
		carFreeCondition.put(DayOfWeek.WEDNESDAY, new ArrayList<>(Arrays.asList(3,8)));
		carFreeCondition.put(DayOfWeek.THURSDAY, new ArrayList<>(Arrays.asList(4,9)));
		carFreeCondition.put(DayOfWeek.FRIDAY, new ArrayList<>(Arrays.asList(5,0)));
		
		holiday = new ArrayList<>() {
			{
				add("1.1");
				add("3.1");
				add("5.1");
				add("6.6");
				add("8.15");
				add("10.3");
				add("10.9");
				add("12.25");
			}
		};
	}
	
	public CarFreeDay(LocalDate date, Car myCar) {
		this.myCar = myCar;
		this.date = date;
		availableLastNumberList = carFreeCondition.get(date.getDayOfWeek());
	}
	
	public void isAccessable() {
		
		printDate();
		System.out.println("-- "+myCar+" --");
		if(checkWeekend()) {
			System.out.println(":::출입 가능:::");
			System.out.println("::: 주말이므로 출입 가능합니다.");

		} else if(checkHoliday()) {
			System.out.println(":::출입 가능:::");
			System.out.println("::: 공휴일이므로 출입 가능합니다.");
			
		} else if(checkExceptCondition()) {
			System.out.println(":::출입 가능:::");
			System.out.println("::: 제외차량으로 출입 가능합니다.");
			
		} else if (checkLastNumber()) {
			System.out.println(":::출입 가능:::");
			System.out.println("::: "+date.getDayOfWeek()+"에는 차량 끝번호 "+availableLastNumberList+"가 출입 가능합니다.");
			
		} else {
			System.out.println(":::출입 불가:::");
			System.out.println("::: "+date.getDayOfWeek()+"에는 차량 끝번호 "+availableLastNumberList+"만 출입 가능합니다.");
		}
	}
	
	
	private boolean checkExceptCondition() {
		return myCar.getExceptCondition() == ExceptionCondition.None? false:true;
	}
	
	private boolean checkWeekend() {
		return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY? true:false;
	}
	
	private boolean checkHoliday() {
		return holiday.contains(date.getMonthValue() + "." + date.getDayOfMonth());
	}
	
	private boolean checkLastNumber() {
		return availableLastNumberList.contains(myCar.getlastOflicenseNumber());
	}
	
	private void printDate() {
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("+++ y년 M월 d일\t E요일 +++");
		System.out.println(dateformat.format(date));
	}

}
