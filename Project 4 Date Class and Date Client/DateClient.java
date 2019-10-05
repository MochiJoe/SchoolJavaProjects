
public class DateClient {

	public static void main(String[] args) {
		Date d1 = new Date(2003, 2, 1);
		//System.out.println(d1.toString());
		Date d2 = new Date(2005, 2, 28);
		//System.out.println(d2.toString());
		//System.out.println(d1.toString().equals(d2.toString()));
		//d1.nextDay();
		//System.out.println(d1.isLeapYear());

		System.out.println(d1.advanceTo(d2));

	}

}
