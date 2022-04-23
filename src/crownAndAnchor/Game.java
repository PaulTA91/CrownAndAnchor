package crownAndAnchor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Game {

	private CADice[] dice;
	private ArrayList<Bet> bets;
	private Player aPlayer = new Player();
	private UserInterface ui = new UserInterface();

	public void play() throws ClassNotFoundException, IOException {

		aPlayer = restartGame();
		boolean cont = false;
		char result;

		do {
			placeBets();
			rollDice();

			ui.displayMessage("First Dice is: " + dice[0].getDiceSymbol());
			ui.displayMessage("Second Dice is: " + dice[1].getDiceSymbol());
			ui.displayMessage("Third Dice is: " + dice[2].getDiceSymbol() + "\n");

			int winnings = workOutWinnings(dice);

			updatePlayerStake(0, winnings);

			ui.displayMessage("You won: " + winnings);
			ui.displayMessage("Your stake is now: " + aPlayer.getStake());
			ui.displayMessage("Banker has: " + aPlayer.getBanker() + "\n");

			result = getEndRoundOption();


			if (result == 'c' && ui.getDecision("Keep playing? (Y/N)") == 'y') {
				cont = true;
			} else {
				cont = false;
			}
		} while (cont);

		if (result == 'c') {
			saveGame(aPlayer);
		}
	}

	private void saveGame(Player aPlayer) 
	{	
	    if (ui.getDecision("Save before quitting? (Y/N)") == 'y') 
	    {
	    	try 
	    	{
	    		FileOutputStream fileOut = new FileOutputStream(aPlayer.getName().toLowerCase() + ".ser");
	    		ObjectOutputStream outPlayer = new ObjectOutputStream(fileOut);
	    		outPlayer.writeObject(aPlayer);
	    		outPlayer.close();
	    		fileOut.close();
	    	}
	    	catch (IOException e) 
	    	{
	      		e.printStackTrace();
	      	}
	    	ui.displayMessage("Game Saved");
	    }
	    else 
	    {
	    	return;
	    }
	
	}

	public Player restartGame() throws IOException, ClassNotFoundException {
		
		String name = ui.getPlayerName();
		
		try {
			FileInputStream inFile = new FileInputStream(name+".ser");
			ObjectInputStream inPlayer = new ObjectInputStream(inFile);
			aPlayer = (Player) inPlayer.readObject();
			inPlayer.close();
			inFile.close();
			ui.displayMessage("You have a saved game with\nStake: "+aPlayer.getStake()+"\nBank: "+aPlayer.getBanker());
			
			if (ui.getDecision("Load game? (Y/N)") == 'n') {
				aPlayer = new Player(name, ui.getPlayerStake());
			}
			else {
				ui.displayMessage("Game Loaded.");
			}
		}
		catch (FileNotFoundException e) {
			ui.displayMessage("No game found, creating new save file.");
			aPlayer = new Player(name, ui.getPlayerStake());
		}
		catch (ClassNotFoundException e) {
			ui.displayMessage("No game found, creating new save file.");
			aPlayer = new Player(name, ui.getPlayerStake());
		}
		catch (IOException e) {
			ui.displayMessage("No game found, creating new save file.");
			aPlayer = new Player(name, ui.getPlayerStake());
		}
		return aPlayer;
	}

	public void placeBets() {
		bets = new ArrayList<Bet>();
		char proceed = 'y';

		do {
			char betType = ui.getBetType();
			String whatOn = ui.getWhatOn();
			int amount = ui.getAmount(aPlayer.getStake(), betType, whatOn);

			switch (betType) {
			case '1':
				Ordinary ordinaryBet = new Ordinary(whatOn, amount);
				bets.add(ordinaryBet);
				updatePlayerStake(amount, 0);
				ui.displayMessage(ordinaryBet.displayBet());
				break;
			case '2':
				DoubleOrNothing dubOrNoth = new DoubleOrNothing(whatOn, amount);
				bets.add(dubOrNoth);
				updatePlayerStake(amount, 0);
				ui.displayMessage(dubOrNoth.displayBet());
				break;
			case '3':
				AllIn allIn = new AllIn(whatOn, amount);
				bets.add(allIn);
				updatePlayerStake(amount, 0);
				ui.displayMessage(allIn.displayBet());
				break;
			}
			ui.displayMessage("Stake now at: "+aPlayer.getStake());
			proceed = ui.getDecision("Place more bets? (Y/N)");
		} while (proceed == 'y');

	}

	public CADice[] rollDice() {

		dice = new CADice[3];

		for (int i = 0; i < dice.length; i++) {
			dice[i] = new CADice();
			dice[i].throwDice();
			dice[i].getDiceSymbol();
		}
		return dice;
	}

	public int workOutWinnings(CADice[] dice) {

		int winnings = 0;

		for (int i = 0; i < bets.size(); i++) {
			Bet temp = bets.get(i);
			winnings += temp.workOutWinnings(dice);
		}
		return winnings;
	}

	public char getEndRoundOption() {

		int stake = aPlayer.getStake();
		int bank = aPlayer.getBanker();
		char result;

		if (stake <= 0) {
			ui.displayMessage("Your stake is now " + stake + " You are bankrupt. \nGame Over\n");
			result = 'l';
		} else if (bank <= 0) {
			ui.displayMessage("The bank is now at 0, You win the game! \nGame Over\n");
			result = 'w';
		} else {
			ui.displayMessage("Round over.");
			result = 'c';
		}
		return result;
	}

	private void updatePlayerStake(int amt, int winnings) //edits bet/winnings from player stake and banker
	{
		
		if (aPlayer.getBanker() - winnings <=0) //banker can't pay out more than available
		{
			aPlayer.increaseStake(aPlayer.getBanker());
			aPlayer.decreaseBank(aPlayer.getBanker());
		}
		else 
		{
			aPlayer.decreaseStake(amt);
			aPlayer.increaseBank(amt);
			aPlayer.increaseStake(winnings);
			aPlayer.decreaseBank(winnings);	
		}
	}
}
