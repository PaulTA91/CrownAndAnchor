package crownAndAnchor;

public class AllIn extends Bet {

	public AllIn() {
		super();
		typeOfBet = 'A';
	}

	public AllIn(String whatOn, int amount) {
		super(typeOfBet, whatOn, amount);
		typeOfBet = 'A';
	}

	@Override
	public String displayBet() {
		return ("You have placed an All In bet of " + amount + " on " + whatOn);
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

		if (correct == 3) {
			winnings = amount + amount * 9;
		}

		return winnings;
	}

}
