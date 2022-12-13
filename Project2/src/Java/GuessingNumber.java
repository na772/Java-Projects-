package Java;
import java.util.Random;
import java.util.Scanner;
/************************************************************************************************
 * Full Stack Java Project Assignment 2 (Guess the Number game)									*
 * 																								*
 * Guessing Number Class:																		*
 * This class implements methods that are defined within the class								*
 * which is responsible for managing the interactions of users. The system welcomes a user,		*
 * and asks for the name of the user, after which the user is giving a range of numbers to		*
 * guess from. If the user's guess is too high or low, the user is informed about it and 		*
 * given a 	chance to take another guess. The user wins if the user can guess the number 		*
 * within six tries. 																			*
 ************************************************************************************************/
public class GuessingNumber
{
    Scanner scanner = new Scanner (System.in);
    static  int  guessedCount = 0;
    public static void main(String[] args)
    {
        GuessingNumber guessNum = new GuessingNumber();
        guessNum.checkGuessedNumber();
    }
    /************************************************************************************************
     * Accepts no parameter. It is responsible for managing the interactions of users. 				*
     * It welcomes a user, gives the user a range of numbers to guess from, and generates random	*
     * number and compare the numbers. If the numbers are equal, the user wins otherwise,			*
     * the user is given six tries to win.															*
     *************************************************************************************************/
    public void checkGuessedNumber()
    {
        int guessedNumber = 0;
        System.out.println("Hello! What is your name?");
        String name = scanner.next();
        System.out.println("Well, " + name + " I am thinking of a number between 1 and 20");
        Random rand = new Random();
        int randomNumber = rand.nextInt(20) + 1;

        try
        {
            while(true)
            {
                guessedNumber = guessNumber(guessedNumber);
                guessedCount++;

                if(guessedCount > 6)
                {
                    System.out.println("Goodbye, "+ name+" you have exceeded allowable tries.");
                    scanner.close();
                    break;
                }
                if (guessedNumber == randomNumber)
                {
                    System.out.println("Good job, " + name + "! You guessed my number in "+guessedCount +" guesses!");
                    System.out.println("Would you like to play again? (y or n)");
                    String yesNo = scanner.next();

                    if(yesNo.equals("y"))
                    {
                        randomNumber = rand.nextInt(20) + 1;
                        guessedCount = 1;
                    }
                    else
                    {
                        System.out.println("Goodbye, "+ name+"!");
                        scanner.close();
                        break;
                    }
                }
                else if (guessedNumber > randomNumber)
                {
                    System.out.println("Your guess is too high.");
                }
                else
                {
                    System.out.println("Your guess is too low.");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.exit(0);
        }
    }

    /************************************************************************************************
     * Accepts no parameter. It is responsible for determining user's entry and returns the guess	*
     * number to the caller.																		*
     * 																								*
     * @return	guessedNumber																		*
     ************************************************************************************************/
    public int guessNumber( int guessedNumber)
    {
        if (guessedNumber >= 1 && guessedNumber <= 20)
        {
            if (guessedCount == 0)
            {
                return guessedNumber;
            }
        }

        try
        {
            while(true)
            {
                System.out.println("Take a guess");

                guessedNumber = scanner.nextInt();

                if( guessedNumber < 1  ||  guessedNumber > 20)
                {
                    System.out.println("Your guess is out of range");
                    guessedNumber = 0;
                }
                else
                {
                    break;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid guess, start over: " + e);
            System.exit(0);
        }
        return guessedNumber;
    }
}