package crownAndAnchor;

public class CADice extends Dice {
	
    public CADice() {

        super();

  }

  public CADice(int i) {

        super(i);

  }
	
	public String getDiceSymbol() {
		
		String diceSymbol = "";
		
		switch(getDice()) {
		
		case 1:
			diceSymbol = "Crown";
			break;
		case 2:
			diceSymbol = "Anchor";
			break;
		case 3:
			diceSymbol = "Heart";
			break;
		case 4:
			diceSymbol = "Club";
			break;
		case 5:
			diceSymbol = "Spade";
			break;
		case 6:
			diceSymbol = "Diamond";
			break;
		}
		return diceSymbol;
	}
}
