package crownAndAnchor;

public class Test {

	UserInterface ui = new UserInterface();

	public void run() {
		/*
		// test Dice class
		
		  Dice diceA = new Dice(5); Dice diceB = new Dice();
		  
		  System.out.println("Dice A = "+diceA.getDice());
		  System.out.println("Dice B = "+diceB.getDice());
		 

		// test CADice class
		
		 CADice diceA1 = new CADice(); CADice diceB1 = new CADice();
		  
		 System.out.println("Dice A = "+diceA1.getDice());
		  System.out.println("Dice A Symbol = "+diceA1.getDiceSymbol());
		  System.out.println("Dice B = "+diceB1.getDice());
		  System.out.println("Dice B Symbol = "+diceB1.getDiceSymbol());
		 

		// test Player class
		
		  Player playerA = new Player("Paul", 100);
		  System.out.println("Name: "+playerA.getName()+"\n Stake: "+playerA.getStake()
		  +"\n Banker: "+playerA.getBanker());
		  
		  playerA.decreaseStake(50); playerA.decreaseBank(70);
		  System.out.println("Name: "+playerA.getName()+"\n Stake: "+playerA.getStake()
		  +"\n Banker: "+playerA.getBanker());
		  
		  playerA.increaseStake(7); playerA.increaseBank(23);
		  System.out.println("Name: "+playerA.getName()+"\n Stake: "+playerA.getStake()
		  +"\n Banker: "+playerA.getBanker());
		 

		// test Ordinary
		
		  Ordinary testBet = new Ordinary("Anchor", 5);
		  System.out.println(testBet.displayBet());
		 

		// test DoubleOrNothing
		
		  DoubleOrNothing test2 = new DoubleOrNothing("Heart", 18);
		  System.out.println(test2.displayBet());
		 

		// test AllIn
		
		  AllIn test3 = new AllIn("Spade", 3548);
		  ui.displayMessage(test3.displayBet());
		 

		// test UI
		 */

		//ui.displayMessage("Hello World!");
		//ui.displayMenu();
		//ui.getBetType();
		//ui.getWhatOn();
		//ui.getPlayerName();
		//ui.getDecision("Would you like to continue? Y/N");
		//ui.getPlayerStake();
		ui.getAmount(25, '2', "Crown");

		CADice[] dice = new CADice[3];

		dice[0] = new CADice(2);
		dice[1] = new CADice(3);
		dice[2] = new CADice(3);

		// test Ordinary
		Ordinary testBet1 = new Ordinary("Anchor", 5);
		System.out.println(testBet1.displayBet());
		System.out.println("Should be 10 - " + testBet1.workOutWinnings(dice));

		// test DoubleOrNothing
		DoubleOrNothing test21 = new DoubleOrNothing("Heart", 10);
		System.out.println(test21.displayBet());
		System.out.println("Should be 50 - " + test21.workOutWinnings(dice));
		
		// test AllIn
		AllIn test31 = new AllIn("Spade", 3);
		ui.displayMessage(test31.displayBet());
		System.out.println("Should be 0 - " + test31.workOutWinnings(dice));
		CADice[] diceAll = new CADice[3];
		diceAll[0] = new CADice(5);
		diceAll[1] = new CADice(5);
		diceAll[2] = new CADice(5);
		System.out.println("Should be 30 - " + test31.workOutWinnings(diceAll));

	}
}
