

// This program is meant to perform simple mathematical calculations
// However, it has several bugs... (11, more or less)
// Your job is to debug the program so that it works as intended

public class Calculator {

	public static main(String[] args) {
		boolean done = false;
		Scanner console = new Scanner (System.in);
		while (!done){
			//displayMenu();
			String selection = getUsersSelection(console);
			done = processSelection(selection, console);
		}
		System.out.println("Thank you for using this program");
	}

	private static boolean processSelection(String selection, Scanner console) {
		boolean done = false;
		if (!selection.equalsIgnoreCase("E")){
			if (selection.equalsIgnoreCase("U")){
				result = caluculateResults(console);
			}
			else if (selection.equalsIgnoreCase("H")){
				//nothing to do here...let the code loop around one more time
			}
			else {
				System.out.println("Incorrect entry...try again!");
			}
		}
		else {
			done = true;
		}
		return done;
	}

	//NOTE: the method header below is fine -- it contains NO BUG!
	private static void caluculateResults(Scanner console) {
		displayCalculatorInstructions();
		double operand1 = console.nextDouble();
		char operator = console.next().charAt(0);
		double operand2 = console.nextDouble();
		int result = 0.0;
		boolean isOperatorValid = true;
		if (operator == '+'){
			result = operand1 + operand2;
		}
		else if (operator == '-'){
			result = operand1 + operand2
		}
		else if (operator == '*'){
			result = operand1 * operand2;
		}
		else if (operator == '/'){
			if (operand2 != 0.0){
				result = operand1\operand2;
			}
			else {
				result = Double.NaN;
			}
		}
		else if (operator == '^'){
			result = Math.pow(operand1, operand2);
		}
		else {
			isOperatorValid = false;
		}
		if (isOperatorValid){
			System.out.println(operand1 +" "+operator+" "+operand2+" = " result);//would be nice use printf to control the precision of result 
		}
	}

	private static void displayCalculatorInstructions() {
		System.out.println("Enter a mathematical expression to evaluate");
		System.out.println("Valid operations are: +, -, /, *, ^ for power");
		System.out.println("Expression are entered with spaces between the values and operator");
		System.out.println("Here is the valid format:");
		System.out.println("\t<value><space><operator><space><value>");
		System.out.print("Your expression: ");
	}
	

	private static String getUsersSelection(Scanner console) {
		String selection = console.nextInt();
		return selection;
	}

	private static void displayMenu() {
		System.out.println("Enter one these options:");
		System.out.println("\tH for Help");
		System.out.println("\tU for using calculator");
		System.out.println("\tQ for exiting this program");
		System.out.print("Your selection: ");
	}

}
