// Jeanmarco Allain || CSIS-1400 || April 22, 2020

import java.util.Random;
import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		boolean quit = false;
		int choice = 0;
		do {
				displayMenu();
				choice = 0;
				choice = reader.nextInt();
				switch(choice) {
				case 1:
					runDiceGame();
					break;
				case 2:
					runNumberGame();
					break;
				case 0:
					//System.out.println("Entered 0");
					quit = true;
					break;
				default: 
					System.out.println("Sorry, that's not an option.");	
			}
		} while(!quit);
		System.out.println("You have exited the game.");
		reader.close();
		
	}
	private static void displayMenu() {
		System.out.println("---------------------------------------------");
		System.out.println("WELCOME TO THE 2-PLAYER ARCADE");
		System.out.println("---------------------------------------------");
		System.out.println("Please select a game to play!");
		System.out.println("");
		System.out.println("1. Dice Roll Game");
		System.out.println("2. Number Guessing Game");
		System.out.println("0. Exit Arcade");
		System.out.println("");
		System.out.println("---------------------------------------------");
		System.out.printf("Enter a number to make your choice:\n");
	}
	
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------- DICE GAME -----------------------------------------------------------------------------------
	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	private static void runDiceGame() {
		int userNum;
		Scanner diceReader = new Scanner(System.in);
		System.out.println("Welcome to the Dice Game!");
		System.out.println("---------------------------------------------");
        System.out.println("We'll do 10 rolls each. Highest total wins");
        System.out.println("So what sided die would you like to use?");
        System.out.println("---------------------------------------------");
        System.out.println("4-sided");
        System.out.println("6-sided");
        System.out.println("8-sided");
		userNum = diceReader.nextInt();
		//diceReader.close();
	     
		if(userNum == 4 || userNum == 6 || userNum == 8){
	          rollDice(userNum);
	    }
	    else{
	          displayDiceError();
	    }	
	}
	private static void displayDiceError(){
		      System.out.println("Error! Please Try again");
		      runDiceGame();
	}
	private static void rollDice(int userNum){
	      int result;
	      int[][] dieScore = new int[2][10];
	      int player = 1; //First player, is added later to show player 2.
	      int playerTotal = 0;
	      int player1Total = 0;
	      int player2Total = 0;
	      Random rand = new Random();
	      for(int x = 0; x < 2; x++) { // For loop in for loop. To write to the 2-dimensional array that holds the scores. I decided to use "for loops" here because they are an excellent way to traverse the entire array and write where needed.
	    	  for(int j = 0; j < 10; j++) {
			      result = rand.nextInt(userNum) + 1;
			      //System.out.println(player + ": Rolled your " + userNum + "-sided die ... you rolled a " + result);
			      dieScore[x][j] = result;
			    //  System.out.print(dieScore[x][j] + " ");
			      if(x == 0) { //Adds up row total for each player
			    	  player1Total = player1Total + result;
			      }	
			      else {
			    	  player2Total = player2Total + result;
			      }
	    	  }
	    	 // System.out.println();
	      }
	      // PRINT VICTORY SCREEN HERE!
	   //   System.out.println("player 1 total: " + player1Total + ". Player 2 Total: " + player2Total);
	      
	      System.out.println("-----------------------------------------------------------------");
	      System.out.println(userNum + "-sided dice rolling scoreboard");
	      System.out.println("-----------------------------------------------------------------");
	      System.out.println("Player\t\tDice Rolls\t\tTotal");
	      System.out.println("-----------------------------------------------------------------");
	      for(int i = 0; i<dieScore.length; i++){
	    	  for (int j = 0; j<10;j++) {
	    		 if(j==0){
	    			 System.out.print("Player " + player + "\t");
	    			 System.out.print(dieScore[i][j] + " ");
	    			 player++;
	    			 playerTotal = playerTotal+dieScore[i][j]; 
	    		 }
	    		 else {
	    			 System.out.print(dieScore[i][j] + " ");
	    			 playerTotal = playerTotal+dieScore[i][j]; 
	    		 }
	    	  }
	    	  System.out.print("\t" + playerTotal);
	    	  playerTotal = 0;
	    	  System.out.println();
	      }
	      System.out.println("-----------------------------------------------------------------");
	      if (player1Total > player2Total) {
		      System.out.println("Player 1 wins with a grand total of " + player1Total + " points!");
	      }
	      else if (player2Total > player1Total) {
	    	  System.out.println("Player 2 wins with a grand total of " + player2Total + " points!");
	      }
	      else {
	    	  System.out.println("Wow. That's a tie at " + player1Total + " points. Holy crap that's insanely lucky!");
	      }
	      System.out.println("-----------------------------------------------------------------");
	}
	
	
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------- NUMBER GAME -----------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	private static void runNumberGame() {
		int uChoice;
		Scanner nGameReader = new Scanner(System.in);
		
		System.out.println("Welcome to the Number Game!");
		System.out.println("---------------------------------------------");
        System.out.println("You'll want to guess the right number in ");
        System.out.println("the least amount of guesses to win!");
        System.out.println("Pick the range below!");
        System.out.println("(Enter the number corresponding the range)");
        System.out.println("---------------------------------------------");
        System.out.println("1.) Between 1 - 10");
        System.out.println("2.) Between 1 - 50");
        System.out.println("3.) Between 1 - 100");
        
        uChoice = nGameReader.nextInt();
       // nGameReader.close();
        
		if(uChoice == 1 || uChoice == 2 || uChoice == 3){
	          startNumber(uChoice);      
	    }
	    else{
	          displayNumberError();
	    }
	}
	private static void startNumber(int uChoice) {
		int gameChoice = uChoice;
		int maxVal = 0;
		switch(gameChoice) {
			case 1:
				maxVal = 10;
				break;
			case 2:
				maxVal = 50;
				break;
			case 3:
				maxVal = 100;
				break;
			default:
				System.out.println("Error Encounted! Sorry!");
		}	
		int theNumber;
		int theNumber2;
		int amntGuess = 1;
		int uGuess = -2;
		int firstScore = 0;
		int maxTry = 10;
		int secondScore = 0;
		boolean rightGuess = false;
		Scanner numGuess = new Scanner(System.in);
		Random numRand = new Random();
		theNumber = numRand.nextInt(maxVal) + 1;
		theNumber2 = numRand.nextInt(maxVal) + 1;
		
		int player =  1;
		System.out.println("Okay Player "+player+", guess the number between 1 and " + maxVal + "! You get 10 guesses, so you'll want to be as quick as you can!");
		//System.out.println(theNumber + " is the rand value for player 1");	// REMOVE THIS WHEN DONE TESTING	
		
		uGuess = numGuess.nextInt();
		
		do{
			if(uGuess == theNumber && uGuess != -2) {
				amntGuess++;
				
				System.out.printf("Ding! That's correct! It took you ");
				System.out.print(amntGuess);
				if(amntGuess == 1) {
					System.out.printf(" guess");
				}
				else {
					System.out.printf(" guesses");
				}
				System.out.printf(" to get this right!\n");
				rightGuess = true;
				//System.out.println(amntGuess);
			}
			else if(uGuess < theNumber && uGuess != -2) {
				amntGuess++;
				//System.out.println(amntGuess);
				System.out.println("Guess Higher! Guess: " + amntGuess + "/10");
				uGuess = numGuess.nextInt();
			}
			else if(uGuess > theNumber && uGuess != -2) {
				amntGuess++;
				//System.out.println(amntGuess);
				System.out.println("Guess Lower! Guess: "+ amntGuess +"/10");
				uGuess = numGuess.nextInt();	
			}
			else if(amntGuess == 10 && uGuess == theNumber) {
				System.out.println("Ding! On your last guess too!");
			}
		}while(!rightGuess && amntGuess < maxTry);
		
		if(uGuess == theNumber) {
			System.out.println("Congrats on getting this correct, The number was indeed " + theNumber);
			
		}
		else {
			System.out.println("Sorry! You're out of guesses! The number was " + theNumber);
		}
		firstScore = amntGuess;
		System.out.println("Moving on, it's Player 2's turn");
		System.out.println("Remember that you also get 10 turns to guess the number between 1 and "+maxVal+". Good luck, you may begin:");
		
		// -------------------------------------------------------------------------------------------------------------------------------------------
		// ---------------------------------------------------Player Change (num game)----------------------------------------------------------------
		// -------------------------------------------------------------------------------------------------------------------------------------------
		uGuess = -2;
		int amntGuess2 = 1;
		rightGuess = false;
		uGuess = numGuess.nextInt();
		//System.out.println(theNumber2 + " is the rand value for player 2");	// REMOVE THIS WHEN DONE TESTING
		do{
			if(uGuess == theNumber2 && uGuess != -2) {
				amntGuess2++;
				
				System.out.printf("Ding! That's correct! It took you ");
				System.out.print(amntGuess2);
				if(amntGuess2 == 1) {
					System.out.printf(" guess");
				}
				else {
					System.out.printf(" guesses");
				}
				System.out.printf(" to get this right!\n");
				rightGuess = true;
				//System.out.println(amntGuess);
			}
			else if(uGuess < theNumber2 && uGuess != -2) {
				amntGuess2++;
				//System.out.println(amntGuess);
				System.out.println("Guess Higher! Guess: " + amntGuess2 + "/10");
				uGuess = numGuess.nextInt();
			}
			else if(uGuess > theNumber2 && uGuess != -2) {
				amntGuess2++;
				//System.out.println(amntGuess);
				System.out.println("Guess Lower! Guess: "+ amntGuess2 +"/10");
				uGuess = numGuess.nextInt();	
			}
			else if(amntGuess2 == 10 && uGuess == theNumber2) {
				System.out.println("Ding! On your last guess too!");
			}
		}while(!rightGuess && amntGuess2 < maxTry);
		
		if(uGuess == theNumber2) {
			System.out.println("Congrats on getting this correct, The number was indeed " + theNumber2);
		}
		else {
			System.out.println("Sorry! You're out of guesses! The number was " + theNumber2);
		}
		secondScore = amntGuess2;
		if(firstScore > secondScore) {
			System.out.println("\n\nPlayer 2 wins!");
		}
		else if(secondScore > firstScore) {
			System.out.println("\n\nPlayer 1 wins!");
		}
		else {
			System.out.println("\n\nBoth players tied!");
		}
		System.out.println("Remember that the player with the LEAST amount of guesses wins!");
		System.out.println("Player 1's score: " + firstScore);
		System.out.println("Player 2's score: " + secondScore);
		
	}
	private static void displayNumberError() {
	      System.out.println("Error! Please Try again");
	      runNumberGame();	
	}
}
