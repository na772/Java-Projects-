package Java;
import java.util.Scanner;
import java.util.Random;
/****************************************************************************************************
 * Full Stack Java Project Assignment 1 (Dragon Cave game)											*
 * 																									*
 * Dragon Cave Class:																				*
 * This class implements three methods that are defined within the class for displaying 			*
 * introduction, choosing a cave, and checking the selected cave, and also responsible for managing *
 * the interactions of users. The system informs a user that the user is in a land full of dragons, *
 * and number of caves. It gives the descriptions of a dragon in the cave. The user is give a 		*
 * chance to choose a cave. If the user's cave has a friendly dragon, it will share his treasure  	*
 * with the user otherwise, a greedy and hungry dragon will eat the user on sight.					*
 ****************************************************************************************************/
public class DragonCave
{
    static int caveNumber = 0;
    Scanner scanner = new Scanner (System. in);

    public static void main(String[] args)
    {
        DragonCave dragoncaves = new DragonCave();

        dragoncaves.displayIntroduction();
        caveNumber = dragoncaves.chooseCave(caveNumber);
        dragoncaves.checkCave(caveNumber);
    }

    /************************************************************************************************
     *                          																	*
     * Accepts no parameter. It is responsible for displaying introduction to users. 				*
     * 																								*
     *************************************************************************************************/
    public  void displayIntroduction()
    {

        System.out.println("You are in a land full of dragons. "
                + "\nIn front of you, you see two caves. \nIn one cave, the dragon is friendly and will share his treasure with you. "
                + "\nThe other dragon is greedy and hungry, and will eat you on sight.");
        System.out.println();
    }

    /************************************************************************************************
     * Accepts no parameter. It is responsible for managing the interactions of users by allowing 	*
     * a user to choose from range of caves, returns the selected cave to the caller. 				*
     * 																								*																								*
     * @return cave																					*
     ************************************************************************************************/
    public int chooseCave(int cave)
    {
        System.out.println("Which cave will you go into? (1 or 2)");
        if (cave >= 1 && cave <= 2)
        {
            return cave;
        }

        while(true)
        {
            try
            {
                 cave = scanner. nextInt ();

                if(cave == 1 || cave == 2)
                {
                    scanner.close();
                    break;
                }
                else
                {
                    System.out.println("Invalid cave number, enter (1 or 2)");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
                scanner.close();
                System.exit(0);
            }
        }
        return cave;
    }

    /************************************************************************************************
     * Accepts selectedCave as a parameter and uses it to determine the type of caves the user 	    *
     * selected by generating a random number and comparing it to the selected cave number.  		*
     * If the numbers are equal, the user is allowed into the cave. 								*
     * 																								*
     * @param selectedCave																			*
     ************************************************************************************************/
    public void checkCave(int selectedCave)
    {
        System.out.println("You approach the cave... \nIt is dark and spooky..."
                + "\nA large dragon jumps out in front of you! He opens his jaws and...");

        Random rand = new Random () ;

        int friendlyCave = rand.nextInt (2) + 1;

        if(friendlyCave == selectedCave)
        {
            System.out.println("Gives you his treasure!");
        }
        else
        {
            System.out.println("Gobbles you down in one bite!");
        }
    }
}