//jgame

import java.util.*;

public class TICTACTOE {

	static void begin() {		//method for heading 
		System.out.println("]|>++++++++<||>----      TIC TAC TOE       ----<||>++++++++<|[ \n -by SELVIN DESOUZA					[:]--20bmiit039@gmail.com \n \n ============================================================ \n Select Positions Based on the Below given numbers :");
		System.out.println("  | 1 | 2 | 3 |   <|>   | X | O | X | \n  | 4 | 5 | 6 |   <|>   | X | X | O | \n  | 7 | 8 | 9 |   <|>   | O | X | O |");
		System.out.println("\n============================================================ \n Patterns for both players are : \n|~~~~|>  PLAYER 1 : \"X\"    ||    PLAYER 2 : \"O\"  <|~~~~| \n============================================================");
	}
	
	static void printmatrix(int [] matrix){	//print matrix
		System.out.println("============================================================");
		ArrayList<String> displaylist = new ArrayList<String>();
		int i = 0, size = 9, P1 = 8, P2 = 1;
		while(i<size) {
			if(matrix[i]==P1){
				displaylist.add("X");
			}else if(matrix[i]==P2){
				displaylist.add("O");				
			}else{
				displaylist.add("~");
			}
			i=i+1;
		}
		String[] M = new String[displaylist.size()];
		M=displaylist.toArray(M);
		System.out.println("  | 1 | 2 | 3 |   <|>   | "+  M[0]  +" | "+  M[1]  +" | "+  M[2]  +" |");
		System.out.println("  | 4 | 5 | 6 |   <|>   | "+  M[3]  +" | "+  M[4]  +" | "+  M[5]  +" |");
		System.out.println("  | 7 | 8 | 9 |   <|>   | "+  M[6]  +" | "+  M[7]  +" | "+  M[8]  +" |");
	}
	static void p1win() {		//method for p1win 
		System.out.println("       ================================= \n       ||       PLAYER 1 WIN!!.       || \n       =================================");
	}
	static void p2win() {		//method for p2win 
		System.out.println("       ================================= \n       ||       PLAYER 2 WIN!!.       || \n       =================================");
	}
	private static int wincheck(int [] matrix, int PTN) {	//check if player win
		if((matrix[0] == matrix[1] && matrix[0] == matrix[2] && matrix[0] == PTN) || (matrix[3] == matrix[4] && matrix[3] == matrix[5] && matrix[3] == PTN) || (matrix[6] == matrix[7] && matrix[6] == matrix[8] && matrix[6] == PTN)){
	        int HIT = 1; //horizontal check
        return HIT;
		}else if((matrix[0] == matrix[3] && matrix[0] == matrix[6] && matrix[0] == PTN) || (matrix[1] == matrix[4] && matrix[1] == matrix[7] && matrix[1] == PTN) || (matrix[2] == matrix[5] && matrix[2] == matrix[8] && matrix[2] == PTN)){
	        int HIT = 1; //horizontal check
        return HIT;
		}else if((matrix[0] == matrix[4] && matrix[0] == matrix[8] && matrix[0] == PTN) || (matrix[2] == matrix[4] && matrix[2] == matrix[6] && matrix[2] == PTN)){
	        int HIT = 1; //horizontal check
        return HIT;
		}else{
			int HIT=0;
		return HIT;			
		}
	}
	
	
	public static void main(String[] atgs) {
		//declre variables
		int i=0,size=9,P1=8,P2=1,HIT=0,PTN=0,N,N2;
		int matrix[]={0,0,0,0,0,0,0,0,0};
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		begin();
		while(i<size){
			if(i%2==0){
				System.out.println("Player 1 (>(>(>");
				System.out.print("Enter the Position : ");
				if(sc.hasNextInt()){
					N = sc.nextInt();
				}else{
					sc.next();
					N = 193293391;
				}
					while(N<1||N>9 ||list.contains(N)==true || N==193293391) {
						if(N<1 || N>9 && N!=193293391){	
							System.out.println("Position out of range");
						}else if (list.contains(N)==true && N!=193293391){
							System.out.println("Position already taken by Player");
						}
						else if(N==193293391){
							System.out.println("Invalid input. Please enter a valid position.");
						}
						System.out.println("Re-Enter the Position : ");
						try{
							N = sc.nextInt();
						} catch (InputMismatchException e) {
							sc.nextLine(); // Clear the input buffer
						}
					}
				N2=N-1;
				matrix[N2]=P1;
				list.add(N);
				printmatrix(matrix);
				PTN=P1;
				if(i>2){
					HIT = wincheck(matrix,PTN);
					if(HIT > 0){
						p1win();
						break;
					}
				}
			}else{
				System.out.println("Player 2 [>[>[>");
				System.out.print("Enter the Position : ");
				if(sc.hasNextInt()){
					N = sc.nextInt();
				}else{
					sc.next();
					N = 193293391;
				}
					while(N<1 || N>9 ||list.contains(N)==true || N==193293391) {
						if(N<1 || N>9 && N!=193293391){	
							System.out.println("Position out of range");
						}else if (list.contains(N)==true && N!=193293391){
							System.out.println("Position already taken by Player");
						}
						else if(N==193293391){
							System.out.println("Invalid input. Please enter a valid position.");
						}
						System.out.println("Re-Enter the Position : ");
						try{
							N = sc.nextInt();
						} catch (InputMismatchException e) {
							sc.nextLine(); // Clear the input buffer
						}
					}
				N2=N-1;
				matrix[N2]=P2;
				list.add(N);
				printmatrix(matrix);
				PTN=P2;
				if(i>2){
					HIT = wincheck(matrix,PTN);
					if(HIT > 0){
						p2win();
						break;
					}
				}
			}
			i=i+1;
		}
		if(i==size) {
			System.out.println("\n||-[]-||>    IT IS A TIE.    <|>    PLAY AGAIN.    <||-[]-||");
		}
	}
}
