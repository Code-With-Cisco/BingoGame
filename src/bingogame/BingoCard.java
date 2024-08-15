package bingogame;

/**
 *
 * @author 5767275
 * Description: Bingo card game with random number generation in a 5x5 2d array
 * it then will draw random numbers and when any number matches it will turn in
 * to a 00 and when the system detects a row, col, or diag consisting of 5 array
 * index with 00 it will say you win.
 * Date: September 12, 2022
 * Professor Charters
 * COP 3804
 * 
 */
public class BingoCard 
{
    
    private int[][] bingoCardArray = new int[5][5]; 
    
    /**
    * Description: A constructor for the BingoCard class, it will create a 2d 
    * array of numbers.
    */
    public BingoCard()
    {
       for(int i = 0; i < 5; i++)
       {
          for(int j = 0; j < 5; j ++)
          {
              bingoCardArray[i][j] = (int)(Math.random() * 15) + (1 + (j * 15));
          }
       }
       for(int k = 0; k < 5; k ++)
       { // gets rid of duplicates
           for(int l = 0; l < 5; l ++)
           {
               for(int m = 0; m < 5; m ++)
               {
                   if(bingoCardArray[l][k] == bingoCardArray[m][k] && l!=m)
                   {
                       bingoCardArray[l][k] = (int) (Math.random() * 15) + (1 + 
                               (k * 15));
                       l = 0; 
                       m = 0; 
                   }
               }
           }
       }
   }
    
    /**
    * Description:  Takes in an integer, compares it to the bingo card, and 
    * replaces any matches with zeroes
    */
    public void checkBingo(int num)
    {
       int rowIndex;
       if(0 < num && num <= 15)
       {
          rowIndex = 0;
       }
       else if(15 < num && num <= 30)
       {
          rowIndex = 1;
       }
       else if(30 < num && num <= 45)
       {
          rowIndex = 2;
       }
       else if(45 < num && num <= 60)
       {
          rowIndex = 3;
       }
       else 
       {
          rowIndex = 4;
       }
       for(int i = 0; i < 5; i++)
       {
           if(num == bingoCardArray[i][rowIndex])
           {
               bingoCardArray[i][rowIndex] = 0;
            }  
        }
       
    }
    
    /**
    * Description: Will check the array for lines of zeroes that are 5 numbers 
    * long, in other words, for a "bingo"
    */
    public boolean gotBingo()
    {
        boolean gotBingo = false;
        int bingoCount1 = 0;
        int bingoCount2 = 0;
        for(int i = 0; i < 5; i ++)
        {
            for(int j = 0; j < 5; j++)
            {
                bingoCount1 += bingoCardArray[i][j];
                bingoCount2 += bingoCardArray[j][i];
            }
            if(bingoCount1 == 0 || bingoCount2 == 0)
            {
                gotBingo = true;
            }
            bingoCount1 = 0;
            bingoCount2 = 0;
        }
        for(int l = 0; l < 5; l ++)
        {
           bingoCount1 += bingoCardArray[l][l];
           bingoCount2 += bingoCardArray[4-l][l];
        }
        if(bingoCount1 == 0 || bingoCount2 == 0)
        {
            gotBingo = true;
        }
        return gotBingo;
    }
    
    
    // Description: Will turn the entire array of a bingo card into a string
    public String toString()
    {
        String bigBingoCard;
        bigBingoCard = "B  I  N  G  O" + "\n";
        for(int i = 0; i < 5; i ++){
            for(int j = 0; j < 5; j ++)
            {
                if(bingoCardArray[i][j] < 10)
                {
                   bigBingoCard += "0" + bingoCardArray[i][j] + " ";
                }
                else
                {
                bigBingoCard += bingoCardArray[i][j] + " ";
                }
            }
            bigBingoCard += "\n";
        }
        return bigBingoCard;
    }

}

