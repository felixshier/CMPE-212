
import java.util.Scanner;

public class gameOfPig {
	
	public static int dice1Roll() {
		int dice1 = Math.round((float)(Math.random()*5) + 1);
		return dice1;
	}
	public static int dice2Roll() {
		int dice2 = Math.round((float)(Math.random()*5) + 1);
		return dice2;
	}
	public static int sumOfDice(int dice1, int dice2) {
		int sum = dice1 + dice2;
		return sum;
	}
	public static int computerTurn() {
		int computerTurnSum = 0;
		boolean computersTurn = true;
		while (computersTurn) {
			int dice1 = dice1Roll();
			int dice2 = dice2Roll();
			System.out.println("The computer rolled a " + dice1 + " and a " + dice2 + " for a sum of " + (dice1+dice2) + ".\n");
			if (dice1 == 1 && dice2 == 1) {
				computerTurnSum += 25;
				System.out.println("Snake eyes! The computers score has been increased by 25! The computers turn score is " + computerTurnSum + ".\n");
			} else if (dice1 == 1 || dice2 ==1) {
				computerTurnSum = 0;
				System.out.println("The computers turn sum has been reset to zero. It is now your turn.\n");
				computersTurn = false;
			}   else if (dice1 == dice2) {
				computerTurnSum += 2*(dice1+dice2);
				System.out.println("Doubles! The computers turn score is now  " + computerTurnSum + ".\n");
			}	else {
				computerTurnSum += (dice1+dice2);

				System.out.println("The computers turn sum is " + computerTurnSum + "\n");

				} if (computerTurnSum >= 40) {
					System.out.println("The computer has ended its turn\n");
					computersTurn = false;		
			}
		}
			return computerTurnSum;
	}

	public static int userTurn() {
		boolean usersTurn = true;
		int userInput;
		int userTurnSum = 0;
		Scanner sc = new Scanner(System.in);
		while (usersTurn) {
			int dice1 = dice1Roll();
			int dice2 = dice2Roll();
			System.out.println("You rolled a " + dice1 + " and a " + dice2 + " for a sum of " + (dice1+dice2));
			if (dice1 == 1 && dice2 == 1) {
				userTurnSum += 25;
				System.out.println("Snake eyes! your score has been increased by 25! Your turn sum is now " + userTurnSum + "\nPlease roll again.\n");
			} else if (dice1 == 1 || dice2 ==1) {
				userTurnSum = 0;
				System.out.println("Your turn score has been reset to zero. It is now the computers turn.\n");
				usersTurn = false;
			} else if (dice1 == dice2) {
				userTurnSum += 2*(dice1+dice2);
				System.out.println("Doubles! your roll was doubled! Your turn score is now " + userTurnSum + "\nPlease roll again.\n");
			} else {
				userTurnSum += (dice1 + dice2);
				System.out.println("Your turn sum is " + userTurnSum + "\n");
				System.out.println("Do you wish to roll again?\npress 1 for yes\npress 2 for no");
				userInput = sc.nextInt();
				if (userInput == 2) {
						usersTurn = false;
				}
			} 
		}	
	return userTurnSum;
	}
	
	public static int computerTotal(int computerTotal, int computerTurnSum) {
		computerTotal += computerTurnSum;
		return computerTotal;
	}
	public static int userTotal(int userTotal, int userTurnSum) {
		userTotal += userTurnSum;
		return userTotal;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int userTotal = 0;
		int computerTotal = 0;
		while (userTotal < 100 && computerTotal < 100) {
			userTotal += userTurn();
			if (userTotal >= 100) {
				System.out.println("You win!");
				break;
			}
			System.out.println("\n\nUser: " + userTotal + " Computer: " + computerTotal + "\n\n");
			computerTotal += computerTurn();
			if (computerTotal >= 100) {
				System.out.println("Computer wins!");
				break;
			}
			System.out.println("\n\nUser: " + userTotal + " Computer: " + computerTotal + "\n\n");
		}
	}
}
