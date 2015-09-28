import java.util.*;
import java.io.*;

public class Assig3
{
    private Integer[] startX = new Integer[50];
    private Integer[] startY = new Integer[50];
    private Integer[] endX = new Integer[50];
    private Integer[] endY = new Integer[50];

    private Integer ex;
    private Integer ey;

    public static void main(String []args)
    {
        new Assig3();
    }
    public Assig3()
    {

        Scanner inScan = new Scanner(System.in);
        Scanner fReader;
        File fName;
        String fString = "";
        String phrase = "";
        String aPhrase [];

        // Make sure the file name is valid
        while (true)
        {
            try
            {
                System.out.println("Please enter grid filename:");
                fString = inScan.nextLine();
                fName = new File(fString);
                fReader = new Scanner(fName);

                break;
            }
            catch (IOException e)
            {
                System.out.println("File not found, did you forget the .txt?");
            }
        }

        // Parse input file to create 2-d grid of characters
        String [] dims = (fReader.nextLine()).split(" ");
        int rows = Integer.parseInt(dims[0]);
        int cols = Integer.parseInt(dims[1]);

        char [][] theBoard = new char[rows][cols];

        for (int i = 0; i < rows; i++)
        {
            String rowString = fReader.nextLine();
            for (int j = 0; j < rowString.length(); j++)
            {
                theBoard[i][j] = Character.toLowerCase(rowString.charAt(j));
            }
        }

        // Show user the grid
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(theBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.print("Please enter phrase to search for (separated by single spaces):");
        phrase = inScan.nextLine().toLowerCase();


        while(!(phrase.equals("")))
        {
            aPhrase = phrase.split("\\s+");
            for (int i = 0; i < aPhrase.length; i++)
            {
                aPhrase[i] = aPhrase[i].replaceAll("[^\\w]", "");
            }
            System.out.println("Looking for: " + phrase);
            System.out.println("Contains " + aPhrase.length + " words.");

            int x [];
            int y [];

            boolean found = false;



            for (int r = 0; (r < rows && !found); r++)
            {
                for (int c = 0; (c < cols && !found); c++)
                {
                    startX[0] = r;
                    startY[0] = c;
                    found = findPhrase(r, c, aPhrase, aPhrase[0], 0, theBoard);
                    if (!found)
                    {
                        for (int i = 0; i < rows; i++) {
                            for (int j = 0; j < cols; j++) {
                                theBoard[i][j] = Character.toLowerCase(theBoard[i][j]);
                            }
                        }
                    }
                }
            }



            if (found)
            {
                System.out.println("The phrase: " + phrase);
                System.out.println("was found:");
                for (int i = 0; i < aPhrase.length; i++)
                {
                    System.out.println(aPhrase[i] + ":  (" + startX[i] + "," + startY[i] + ") to (" + endX[i] + "," + endY[i] + ")");
                }

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print(theBoard[i][j] + " ");
                        theBoard[i][j] = Character.toLowerCase(theBoard[i][j]);
                    }
                    System.out.println();
                }
            }
            else
            {
                System.out.println("The phrase: " + phrase);
                System.out.println("was not found");
                for (int i = 0; i < rows; i++)
                {
                    for (int j = 0; j < cols; j++)
                    {
                        theBoard[i][j] = Character.toLowerCase(theBoard[i][j]);
                        System.out.print(theBoard[i][j] + " ");
                    }
                    System.out.println();
                }
            }

            System.out.print("\nPlease enter phrase to search for (separated by single spaces):");
            phrase = inScan.nextLine().toLowerCase();
        }
        System.out.println("Thanks for playing!");




    }
    public boolean findPhrase(int r, int c, String words[], String word, int num, char [][] grid)
    {
        boolean found = false;

        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0)
            return false;
        else if (!findWord(r, c, words[num], 0, grid, 0))
            return false;
        else
        {
            //System.out.println("x is " + ex + " y is " + ey);
            startX[num] = r;
            startY[num] = c;
            endX[num] = ex;
            endY[num] = ey;
            if (num > words.length - 2)
            {
                //System.out.println("x is " + r + " y is " + c);
                found = true;
            }
            else
            {
                found = findPhrase(ex, ey + 1, words, words[num ], num + 1, grid);  // Right
                if (!found)
                    found = findPhrase(ex + 1, ey, words, words[num], num + 1, grid);  // Down
                if (!found)
                    found = findPhrase(ex, ey - 1, words, words[num], num + 1, grid);  // Left
                if (!found)
                    found = findPhrase(ex - 1, ey, words, words[num], num + 1, grid);  // Up
            }
        }
        return found;
    }

    public boolean findWord(int r, int c, String word, int loc, char [][] grid, int way)
    {
        //System.out.println("findWord: " + r + ":" + c + " " + word + ": " + loc); // trace code

        // Check boundary conditions
        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0)
            return false;
        else if (grid[r][c] != word.charAt(loc))  // char does not match
            return false;
        else  	// current character matches
        {
            grid[r][c] = Character.toUpperCase(grid[r][c]);  // Change it to
            // upper case.  This serves two purposes:
            // 1) It will no longer match a lower case char, so it will
            //    prevent the same letter from being used twice
            // 2) It will show the word on the board when displayed

            boolean answer;
            if (loc == word.length()-1)		// base case - word found and we are done!
            {
                ex = r;
                ey = c;
                answer = true;
            }

            else // Still have more letters to match, so recurse.
            {		// Try all four directions if necessary.
                answer = false;
                if (way == 0)// || loc < 2)
                    answer = findWord(r, c + 1, word, loc + 1, grid, 0);  // Right
                if (!answer && (way == 1 || loc < 2))
                    answer = findWord(r+1, c, word, loc+1, grid, 1);  // Down
                if (!answer && (way == 2 || loc < 2))
                    answer = findWord(r, c-1, word, loc+1, grid, 2);  // Left
                if (!answer && (way == 3 || loc < 2))
                    answer = findWord(r-1, c, word, loc+1, grid, 3);  // Up

                // If answer was not found, backtrack.  Note that in order to
                // backtrack for this algorithm, we need to move back in the
                // board (r and c) and in the word index (loc) -- these are both
                // handled via the activation records, since after the current AR
                // is popped, we revert to the previous values of these variables.
                // However, we also need to explicitly change the character back
                // to lower case before backtracking.
                if (!answer)
                    grid[r][c] = Character.toLowerCase(grid[r][c]);
            }
            return answer;
        }
    }
}
