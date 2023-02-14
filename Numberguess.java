import java.util.*;
public class Numberguess {
    
	public static void NumberguessGame()
	{
		Scanner sc = new Scanner(System.in);

		int number = 1 + (int)(100* Math.random());

		int T = 5;

		int i, guess;

		System.out.println("A number is chosen"+ " between 1 to 100."+ "Guess the number"+ " within 5 trials.");

		for (i = 0; i < T; i++) {

			System.out.println("Guess the number:");

			guess = sc.nextInt();

			if (number == guess) {
				System.out.println("Congratulations!"+ " You have guessed the right number.");
				break;
			}
			else if (number > guess
					&& i != T - 1) {
				System.out.println("The number is "+ "greater than " + guess);
			}
			else if (number < guess
					&& i != T - 1) {
				System.out.println("The number is"+ " less than " + guess);
			}
		}

		if (i == T) {
			System.out.println("You have exhausted"+ " K trials.");

			System.out.println("The number was " + number);
		}
	}

	public static void main(String arg[])
	{

		NumberguessGame();
	}
}

