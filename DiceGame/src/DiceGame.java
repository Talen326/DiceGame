import java.util.Random;
import java.util.Scanner;

public class DiceGame {

	public static void main(String[] args) {
		int die1;
		int die2;
		String[] playerChoices;
		die1 = roll();
		die2 = roll();
		String choice;
		choice = getInput("Do you want to play?\nYes\nNo");
		choice = choice.toLowerCase();
		int count = 0;
		String playerCount = getInput("How many players are there?");
		count = Integer.parseInt(playerCount);
		playerChoices = new String[count];
		while(choice.equals("yes")) {
			
			for(int c= 0; c < count; c++) {
			playerChoices[c] = getInput("Player "+(c+1)+": [0] Even\n[1] Odd");
			
			}
			System.out.println("Die 1: "+die1+"\nDie 2: "+die2);
			//Start a new loop here.
			for(int c=0; c<count;c++) {
				if(didIWin(die1,die2,playerChoices[c]))
				{
					System.out.println("Player "+(c+1)+" wins!");
				}else
				{
					System.out.println("Player "+(c+1)+" loses!");
				}
			}
			
			choice = getInput("Do you want to play?\nYes\nNo");
			choice = choice.toLowerCase();
			die1 = roll();
			die2 = roll();
		}
	}
	private static boolean didIWin(int die1, int die2, String choice)
	{
		
		if((die1+die2%2 == 0 && Integer.parseInt(choice) == 0) || (die1+die2%2 == 1 && Integer.parseInt(choice) == 1)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	private static int roll()
	{
		return roll(6,1);
	}
	private static int roll(int sides,int start) {
		Random roller = new Random();
		return roller.nextInt(sides)+start;
	}
	private static String getInput(String text) {
		Scanner input = new Scanner(System.in);
		String choice = "";
		try 
		{
			System.out.println(text);
			choice = input.nextLine();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return choice;
	}
	
	private static boolean isInputInteger(String input) {
		boolean isAnInteger = true;
		for(int c = 0; c < input.length();c++) {
			char letter = input.charAt(c);
			//'-' is 45 '0 - 9' 48 - 57
			if(c!=0 &&!(letter >= 48 && letter<= 57))
			{
				isAnInteger = false;
			}else if(letter != 45 && !(letter >= 48 && letter <= 57))
			{
				isAnInteger = false;
			}
		}
		return isAnInteger;
	}
}
