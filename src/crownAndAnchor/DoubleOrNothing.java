package crownAndAnchor;

public class DoubleOrNothing extends Bet {

	public DoubleOrNothing() {
		super();
		typeOfBet = 'D';
	}

	public DoubleOrNothing(String whatOn, int amount) {
		super(typeOfBet, whatOn, amount);
		typeOfBet = 'D';
	}

	@Override
	public String displayBet() {
		return ("You have placed a Double or Nothing bet of " + amount + " on " + whatOn);
	}

	@Override
	public int workOutWinnings(CADice[] dice) {
		int winnings = 0;
		int correct = 0;

		for (int i = 0; i < 3; i++) {
			if (whatOn.equalsIgnoreCase(dice[i].getDiceSymbol())) {
				correct++;
			}
		}

		if (correct >= 2) {
			winnings = amount + (amount * 4);
		}

		return winnings;
	}

}
