package crownAndAnchor;

public abstract class Bet {
	protected static char typeOfBet;
	protected String whatOn;
	protected int amount;

	public Bet() {
		typeOfBet = ' ';
		whatOn = "";
		amount = 0;
	}

	public Bet(char typeOfBet, String whatOn, int amount) {
		Bet.typeOfBet = typeOfBet;
		this.whatOn = whatOn;
		this.amount = amount;
	}

	public abstract String displayBet();

	public abstract int workOutWinnings(CADice[] dice);

}
