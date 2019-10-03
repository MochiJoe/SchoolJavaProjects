
public class SpaceNeedle {

	public static void main(String[] args) {
		skinnyMid() ;
		observatory();
		observatoryBase();
		skinnyMid();
		midPiece();
		observatory();
	}
	
	    // this is the small tip at the top of the needle also use in the middle 
		//    character			expression			comment
		// <space> - 12			12
		// ||      - 2			2
	
		public static void skinnyMid () {
			for (int row = 1; row <= 4; row++) {
				
				for (int space = 1; space <= 12; space++) {
					System.out.print(" ");
				}
				for (int line = 1; line <= 2; line++) {
					System.out.print("|");
				}
				System.out.println();
			}			
		}
		
		//this is the observatory at the top and bottom of the needle 
		//    	character			expression				comment
		// < space > - 9,6,3,0		9 - (3 * row -3)
		// < __/ > - 1										I realized this could be on 1 line.
		// < : > - 0,3,6,9			(3 * row -3 ) - 9
		// < || >- 2
		// < ; > - 0,3,6,9			(3 * row - 3) - 9
		// < \__ > - 1
		// < " > - 24
		public static void observatory () {
			for (int row = 1; row <= 4; row++) {
							
				for (int space = 1; space <= 9 - (3 * row -3); space++) {
					System.out.print(" ");
				}
				for (int fwddash = 1; fwddash <= 1; fwddash ++) {
					System.out.print("__/");
				}				
				for (int semi = 1; semi <= (3 * row +6) - 9; semi++) {
					System.out.print(":");
				}
				for (int line = 1; line <= 2; line++) {
					System.out.print("|");
				}
				for (int semi = 1; semi <= (3 * row +6) - 9; semi++) {
					System.out.print(":");
				}
				for (int bwddash = 1; bwddash <= 1; bwddash ++) {
					System.out.print("\\__");
				}				
				System.out.println();
			}
			for (int fwd = 1; fwd <= 1; fwd++) {
				System.out.print("|");
			}
			for (int quote = 1; quote <= 24; quote++) {
				System.out.print("\"");
			}
			for (int fwd = 1; fwd <= 1; fwd++) {
				System.out.println("|");
			}
		}
		
		 // this is the observatory base at the top of the needle
		//     character				expression			comment
		// < space > - 0,2,4,6		(row * 2 - 10) +8
		// < \_ > - 1
		// < /\ > - 11,9,7,5			13 - (row * 2)
		// < _/ > - 1
		public static void observatoryBase() {
			for (int row = 1; row <= 4; row++) {
				for (int space = 1; space <= (row  * 2- 10) +8; space++) {
					System.out.print(" ");
				}
				for (int leftBase = 1; leftBase <= 1; leftBase++) {
					System.out.print("\\_");
				}
				for (int centerBase = 1; centerBase <= 13 - (row * 2); centerBase++) {
					System.out.print("/\\");					
				}
				for (int leftBase = 1; leftBase <= 1; leftBase++) {
					System.out.print("_/");
				}
				System.out.println();
			}
		}
		
		//this is the thicker mid section of the space needle
	    //		character			expression			comment
		// < space > - 9
		// < |%%||%%| > - 1
		public static void midPiece() {
			for (int row = 1; row <= 16; row++) {
				for (int space = 1; space <= 9; space++) {
					System.out.print(" ");					
				}
				for (int middle = 1; middle <= 1; middle++) {
					System.out.print("|%%||%%|");
				}
				System.out.println();
			}
		}	
}