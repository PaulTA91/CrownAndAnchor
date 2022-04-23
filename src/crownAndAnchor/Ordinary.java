package crownAndAnchor;

public class Ordinary extends Bet {

	public Ordinary() {
		super();
		typeOfBet = 'O';
	}

	public Ordinary(String whatOn, int amount) {
		super(typeOfBet, whatOn, amount);
		typeOfBet = 'O';
	}

	@Override
	public String displayBet() {
		return ("You have placed an ordinary bet of " + amount + " on " + whatOn);
	}

	@Override
	public int workOutWinnings(CADice[] dice) {

		int winnings = 0;
		int correct = 0;

		for (int i = 0; i < 3; i++) {
			if (whatOn.equalsIgnoreCase(dice[i].getDiceSymbol()))

			{
				correct++;
			}
		}

		if (correct == 1) {
			winnings = amount+amount;
		} else if (correct == 2) {
			winnings = amount + amount * 2;
		} else if (correct == 3) {
			winnings = amount + amount * 3;
		}

		return winnings;
	}

}
