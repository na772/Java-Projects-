package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/****************************************************************************************************
 * Full Stack Java Project Assignment 5 (Hangman)													*
 * 																									*
 * Hangman Class:																					*
 * This class implements four methods that are defined within the class for interacting with		*
 * users and displaying introduction, getting user guessed letters, printing random secret Word,	*
 * and printing HangMan. The system welcomes a user, draws a blank line of a secret word and asks	*
 * the user to guess a letter. While the user guessing letters, the system prints out  both the		*
 * guessed letters and the and missed letters on separate lines. The user is given a chance to 		*
 * take another guess. The user wins if the user can guess the word within ten tries. 				*
 ****************************************************************************************************/
public class Hangman
{
    static String [] secretWords = {"book", "paper", "letter", "dog", "cat","goat", "sheep",
            "today","yesterday", "tomorrow", "java", "truck", "opportunity","difficulty",
            "fish", "vehicle", "transportation", "bottom", "apple", "cake","eat","food",
            "remote", "jump", "terminology", "arm", "leg", "secret", "tool","sleep","walk",
            "technology", "spoon", "watermelon", "laptop", "computer", "good", "bad","best",
            "fundamental", "capitol", "display", "anticipate", "package","parcel","box"};

    static Scanner scanner = new Scanner (System. in);
    static String missedLetter = "";
    static String alredyGuessedLetters = "";
    static String guessedLetter = "";
    static int wrongGuessCount = 0;
    public static void main(String[] args)
    {
        displayHangMan();

        List<String> words = new ArrayList<> () ;

        for(String str : secretWords)
        {
            words.add(str);
        }

        Random rand = new Random ();
        String word = words.get (rand.nextInt(words.size())) ;

        List<Character> guessedWord = new ArrayList<> ();

        printSecretWord(word, guessedWord);

        try
        {
            while(true)
            {
                if (wrongGuessCount >= 10)
                {
                    System.out.println("No! The secret word is "+ word + "! You hava lost!");
                    break;
                }

                boolean isGuessedLetter = getGuessedLetter(word, guessedWord);

                if (!isGuessedLetter)
                {

                    wrongGuessCount++;
                    missedLetter += guessedLetter;
                }

                if(alredyGuessedLetters.contains(guessedLetter))
                {
                    System.out.println("You have already guessed that letter. Choose again.");
                }
                else
                {
                    alredyGuessedLetters += guessedLetter;
                }

                if (printSecretWord(word, guessedWord))
                {
                    System.out.println("Yes! The secret word is "+ word + "! You hava won!");

                    System.out.println("Do you want to play again? (y or n)");

                    Scanner ynScanner = new Scanner (System. in);
                    String yesNo = ynScanner.next();

                    if(yesNo.equals("y"))
                    {
                        word = "";
                        alredyGuessedLetters = "";
                        missedLetter = "";
                        guessedLetter = "";
                        wrongGuessCount = 0;
                        guessedWord.clear();
                        word = words.get (rand.nextInt(words.size()));
                        printSecretWord(word, guessedWord);
                    }
                    else
                    {
                        System.out.println("Goodbye!");
                        ynScanner.close();
                        scanner.close();
                        break;
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Goodbye! "+ e);
            scanner.close();
            System.exit(0);
        }
    }

    /************************************************************************************
     * Accepts no parameter. It is responsible for displaying introduction to users.    *
     * 																					*
     ************************************************************************************/

    private static void displayHangMan()
    {
        System.out.println("H A N G M A N");
        System.out .println("");
        System.out.println("+----+");
        System.out.println("      ");
        System.out.println("     |");
        System.out.println("      ");
        System.out.println("     |");
        System.out.println("      ");
        System.out.println("     |");
        System.out.println("      ");
        System.out.println("    ===");
        System.out.println("      ");
        System.out.println("      ");

    }

    /************************************************************************************************
     * Accepts word and guessedWord as parameters and use it to get the guessed letter from a user.	*
     * 																								*
     * @param word, 	guessedWord																	*
     ************************************************************************************************/

    public static boolean getGuessedLetter (String word, List<Character> guessedWord)
    {
        try
        {
            System.out.println("");
            System.out.println("");
            System.out.println("Guess a letter:");

            String guessingLetter = scanner.nextLine() ;

            guessedWord.add(guessingLetter.charAt(0));
            guessedLetter = String.valueOf(guessingLetter.charAt(0));

            return word.contains(guessingLetter);
        }
        catch(Exception e)
        {
            System.out.println("Goodbye! "+ e);
            scanner.close();
            System.exit(0);
        }
        return false;
    }

    /****************************************************************************************
     * Accepts word and guessedWord as parameters and use it to print the secret Word.		*
     * 																						*
     * @param word, 	guessedWord															*
     ****************************************************************************************/
    public static boolean printSecretWord(String word, List<Character> guessedWord)
    {
        printHangMan(wrongGuessCount);

        int correctCharCount = 0;

        System.out.println();
        System.out.println("Missed letters:" + missedLetter);
        System.out.println();

        for (int i = 0; i < word.length(); i++)
        {
            if (guessedWord.contains(word.charAt (i)))
            {
                System.out.print(word.charAt (i)) ;
                correctCharCount++;
            }
            else
            {
                System.out.print("_");
            }
        }
        System.out.println() ;

        return (word.length() == correctCharCount) ;
    }

    /****************************************************************************************
     * Accepts wrongGuessCount as parameter and use it to print the Hangman.				*
     * 																						*
     * @param wrongGuessCount																*
     ****************************************************************************************/
    private static void printHangMan(Integer wrongGuessCount)
    {
        if(wrongGuessCount == 1 )
        {
            System.out.println("");
            System.out.println("+----+");
            System.out.println("");
            System.out.println("O    |");
            System.out.println("");
            System.out.println("     |");
            System.out.println("");
            System.out.println("     |");
            System.out.println("");
            System.out.println("    ===");
        }

        if (wrongGuessCount == 2)
        {
            System.out.println("");
            System.out.println("+----+");
            System.out.println("");
            System.out.println("O    |");
            System.out.println("");
            System.out.println("|    |");
            System.out.println("");
            System.out.println("     |");
            System.out.println("");
            System.out.println("    ===");
        }

        if (wrongGuessCount >= 3)
        {
            System.out.println("");
            System.out.println("+----+");
            System.out.println("");
            System.out.println("O    |");
            System.out.println("");
            System.out.println("|    |");
            System.out.println("");
            System.out.println("|    |");
            System.out.println("");
            System.out.println("    ===");
        }
    }
}
