import java.util.Random;
import java.util.Scanner;

public class DiceGame {
	private static String[][] Language;
	private static int lang=0;
	
	public static void main(String[] args) {
		int die1;
		int die2;
		String[] playerChoices;
		Language = initLang(); 
		String langChoice = getInput(Language[lang][10]);
		lang = Integer.parseInt(langChoice);
		die1 = roll();
		die2 = roll();
		String choice;
		choice = getInput(Language[lang][0]);
		choice = choice.toLowerCase();
		int count = 0;
		String playerCount = getInput(Language[lang][1]);
		count = Integer.parseInt(playerCount);
		playerChoices = new String[count];
		while(choice.equals(Language[0][2])) {
			
			for(int c= 0; c < count; c++) {
			playerChoices[c] = getInput(Language[lang][3]+(c+1)+Language[lang][4]);
			
			}
			System.out.println(Language[lang][5]+die1+Language[lang][6]+die2);
			//Start a new loop here.
			for(int c=0; c<count;c++) {
				if(didIWin(die1,die2,playerChoices[c]))
				{
					System.out.println(Language[lang][3]+(c+1)+Language[lang][7]);
				}else
				{
					System.out.println(Language[lang][3]+(c+1)+Language[lang][8]);
				}
			}
			
			choice = getInput(Language[0][9]);
			choice = choice.toLowerCase();
			die1 = roll();
			die2 = roll();
		}
	}
	private static String[][] initLang(){
		String[][] temp = new String[][] {
			{"Do you want to play?\nYes\nNo","How many players are there?","yes",
				"Player ",": [0] Even\n[1] Odd","Die 1: ",
				"\nDie 2: "," wins!"," loses!",
				"Do you want to play again?\nYes\nNo","Enter language: \n[0] English\n[1] Hawaiian Pidgen"},
			{
					"Like try?\nyeesah\nnaaah","How many dakine Braddahs","yessah",
					"Bradda ", ": [0] Even\n[1] Odd","Die 1",
					"\nDie 2: ","Winnah!", "No need win.",
					"Like try again?\nYessah\nNo"
					
			}
		};
			return temp;
	}
	private static boolean didIWin(int die1, int die2, String choice)
	{
		
		return false;
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
