
public class Date {
	int year;
	int month;
	int day;
	int tempYear;
	int startMonth;
	int startDay;

	// constructor to create new default Date object with given year, month and day
	public Date() {
		this(1753, 1, 1);

	}

	// constructor to create new Date object with given year, month and year
	public Date(int newYear, int newMonth, int newDay) {
		year = newYear;
		month = newMonth;
		day = newDay;
	}

	// accessor method to return this Date year
	public int getYear() {
		return year;
	}

	// accessor method to return this Date month
	public int getMonth() {
		return month;
	}

	// accessor method to return this Date day
	public int getDay() {
		return day;
	}

	// accessor method to return String of this Date object’s field in form
	// Year/Month/Day (2018/2/28).
	public String toString() {
		return year + "/" + month + "/" + day;
	}

	// accessor method to return true if this Date object equals otherDate
	public boolean equals(Date otherDate) {
		int newYear = otherDate.getYear();
		int newMonth = otherDate.getMonth();
		int newDay = otherDate.getDay();
		if (otherDate.toString().matches(Date.this.toString())) {
			return true;
		} else {
			return false;
		}
	}

	// accessor method to return true if this Date object’s year field is leap year
	// (false otherwise)
	public boolean isLeapYear() {
		if ((year % 4) == 0) {
			return true;
		} else if ((year % 100) == 0) {
			if (year % 400 == 0) {
			}
			return true;
		} else {
			return false;
		}
	}

	// check if advance to has leap years inside the for loop
	public boolean isendLeapYear() {
		if ((tempYear % 4) == 0) {
			return true;
		} else if ((tempYear % 100) == 0) {
			if (tempYear % 400 == 0) {
			}
			return true;
		} else {
			return false;
		}
	}

	// mutator method that advances this Date object’s fields to represent the next
	// date
	public void nextDay() {
		if (month == 2) {
			if (isLeapYear() == true) {
				if (day == 28) {
					day++;
				} else if (day == 29) {
					month++;
					day = 1;
				}
			} else if (day == 28) {
				month++;
				day = 1;
			} else {
				day++;
			}
			// done with feb checks
		} else if (month == 12) {
			if (day == 31) {
				year++;
				month = 1;
				day = 1;
			} else {
				day++;
			}
			// done with december check
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day == 30) {
				month++;
				day = 1;
			} else {
				day++;
			}
		} else {
			if (day == 31) {
				month++;
				day = 1;
			} else {
				day++;
			}
		}
	}

	// mutator for advancing to the next day
	public int advanceTo(Date endDate) {
		int endYear = endDate.getYear();
		int endMonth = endDate.getMonth();
		int endDay = endDate.getDay();
		int days = 0;
		int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int mdays = month - 1;
		;

		// amount of days for the day
		// days = days + ((monthDays [(month - 1)]) - day -1);
		// days = days + endDay;

		//amount of days within a same month
		if(year == endYear && month == endMonth) {
			days = days + (endDay - day);
		} else if (year == endYear) {
			days = days + ((monthDays [(month - 1)]) - day);
			days = days + endDay;
			month++;
		} else {
			days = days + ((monthDays [(month - 1)]) - day);
			days = days + endDay;
		}
		
		
		// amount of days for the month
		// if start and end years are the same
		// (because we know that endMonth will never be less than start month)
		if (year == endYear) {
			if (isLeapYear() == true) {
				for (int m = (month - 1); m < (endMonth - 1); m++) {
					if (monthDays[m] == monthDays[1]) {
						days = days + monthDays[1] + 1;
					} else {
						days = days + monthDays[m];
					}
				}
			} else {
				for (int m = (month - 1); m < endMonth - 1; m++) {
					days = days + monthDays[m];
				}
			}
		}

		// otherwise (if end year is greater than start year)
		// and also if endMonth is less than start month
		// we need to count the remaining months until the end of the start year
		// and the beginning months of the end year
		if (year < endYear && month > endMonth) {
			// calculate number of months after start month
			int endWrap = month;
			// calculate number of months before end month
			int begWrap = (endMonth - 1);
			
			for (int i = endWrap; i < monthDays.length; i++) {
				days = days + monthDays[i];
			}
			for (int j = 0; j < begWrap; j++) {
				if (isendLeapYear() == true) {
					if (monthDays[j] == monthDays[1]) {
						days = days + monthDays[1] + 1;
					} else {
						days = days + monthDays[j];
					}
					
				}else {
					days = days + monthDays[j];
				}
			}
			
				
		}
		

		// otherwise, if end year > start year AND end month > start month
		// then use similar logic as if the years were equal.
		// (because we STILL know that endMonth will never be less than start month)
		if ((year < endYear && month < endMonth) || (year < endYear && month == endMonth)) {
			if (isLeapYear() == true) {
				for (int m = (month - 1); m < (endMonth - 1); m++) {
					if (monthDays[m] == monthDays[1]) {
						days = days + monthDays[1] + 1;
					} else {
						days = days + monthDays[m];
					}
				}
			} else {
				for (int m = (month - 1); m < endMonth - 1; m++) {
					days = days + monthDays[m];
				}
			}
			
		}

		for (int y = year + 1; y < endYear; y++) {
			tempYear = y;
			if (isendLeapYear() == true) {
				days = days + 366;
				
			} else {
				days = days + 365;
			}
		}
		// potentially use int array (month.length) to get total number of months, or
		// just use 12

		// if (month < endMonth) {
		// for (int betweenMonths = (endMonth-1); betweenMonths > (endMonth - month -
		// 1); betweenMonths--) {
		// days = days + monthDays[betweenMonths];
		// }
		// }else {
		// for (int betweenMonths = (month + 1); betweenMonths < 0; );
		// }

		// amount of days for the year
//		if(year < endYear) {
//			int d1 = (year * 365) + 31 + 1 + ((year - 1753)/4);
//			int d2 = (endYear * 365) + 31 + 1 + ((endYear - 1753)/4);
//			days = days + (d2 - d1);
//			}
		return days;

	}
	// System.out.println("There are " + days + " between " +
	// this.toString()+ " & " + endDate.toString() +".");

}
