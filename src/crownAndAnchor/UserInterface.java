package crownAndAnchor;

import java.util.Scanner;

public class UserInterface {
	Scanner sc = new Scanner(System.in);

	public void displayMessage(String msg) {
		System.out.println(msg);
	}

	public String getPlayerName() // get player name and ensure that it's valid
	{
		String name = null;

		do {
			System.out.print("Please enter your name:- ");
			if (sc.hasNext()) {
				name = sc.next().toLowerCase();
				sc.nextLine();
			} else {
				System.out.println("That is not a valid input!.");
			}
		} while (name.length() < 1);

		return name;
	}

	public char getDecision(String msg) {

		displayMessage(msg);

		while (!sc.hasNext("[YyNn]")) {
			System.out.println("That's not a valid choice!");
			sc.next();
		}

		return sc.next().toLowerCase().charAt(0);
	}

	public int getPlayerStake() {
		int stake = 0;
		boolean valid;

		do {
			valid = true;
			displayMessage("Please enter your stake. Minimum amount is 3:");

			if (sc.hasNextInt()) {
				stake = sc.nextInt();
				sc.nextLine();

				if (stake < 3) {
					displayMessage("Amount is too low, try again: ");
					valid = false;
				}
			} else {
				displayMessage("Input not recognized. Try again.");
				valid = false;
				sc.next();
			}
		} while (!valid);

		return stake;
	}

	/*
	 * //public void displayMenu() { System.out.println("\tCrown and Anchor");
	 * System.out.println("\t=================");
	 * System.out.println("\t1. Play Game"); System.out.println("\tQ. Quit\n\n");
	 * System.out.print("Please enter an option: ");
	 * 
	 * }
	 */

	public char getOption() {
		System.out.println("Please enter an appropriate value of either 1, q or Q");
		while (!sc.hasNext("[1qQ]")) {
			System.out.println("That's not a value");
			sc.next();
		}
		return sc.next().toLowerCase().charAt(0);

	}

	public char getBetType() {

		displayMessage("Please choose which type of bet you'd like to make: ");
		displayMessage("1: Ordinary\n2: Double or Nothing\n3: All In");

		while (!sc.hasNext("[1-3]")) {
			displayMessage("That is not a valid choice! Try again: ");
			sc.next();
		}

		return sc.next().toLowerCase().charAt(0);
	}

	public String getWhatOn() {

		String whatOn = null;
		int selection;

		do {
			displayMessage("Please pick which suit you'd like to bet on: ");
			displayMessage("---------");
			displayMessage("1: Crown");
			displayMessage("2: Anchor");
			displayMessage("3: Heart");
			displayMessage("4: Club");
			displayMessage("5: Spade");
			displayMessage("6: Diamond");

			while (!sc.hasNext("[1-6]")) {
				System.out.println("That's not a correct value! Try again: ");
				sc.next();
			}
			selection = sc.next().toLowerCase().charAt(0);
		} while (false);

		switch (selection) {
		case '1':
			whatOn = "Crown";
			break;
		case '2':
			whatOn = "Anchor";
			break;
		case '3':
			whatOn = "Heart";
			break;
		case '4':
			whatOn = "Club";
			break;
		case '5':
			whatOn = "Spade";
			break;
		case '6':
			whatOn = "Diamond";
			break;
		}

		return whatOn;

	}

	public int getAmount(int stake, char betType, String whatOn) {

		int amount;
		int minimumBet = 0;
		boolean valid = true;

		switch (betType) {
		case '1':
			minimumBet = 1;
			break;
		case '2':
			minimumBet = 2;
			break;
		case '3':
			minimumBet = 3;
			break;
		}

		do {

			valid = true;
			amount = 0;

			displayMessage("You are betting on " + whatOn + " the minimum bet is " + minimumBet);
			displayMessage("Please enter your betting amount: ");

			if (sc.hasNextInt()) {
				amount = sc.nextInt();

				if (amount >= minimumBet) {
					{
						if ((amount - stake) > 0) {
							displayMessage("You do not have enough credits!");
							valid = false;
						}
					}

				} else {
					displayMessage("This is too low for this bet type, please enter another amount: ");
					valid = false;

				}
			} else {
				displayMessage("Invalid input, try again: ");
				valid = false;
				sc.next();
			}
		} while (!valid);

		return amount;
	}
}
