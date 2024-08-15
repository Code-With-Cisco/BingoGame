/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bingogame;

import java.util.Scanner;

/**
 *
 * @author mtsguest
 */
public class BingoGame {

    /**
     * @param args the command line arguments
     * 
     */
    public static int totalGamesWon = 0;
    public static BingoCard myCard;
    
    public static void main(String[] args) {
        
        String playAgain = "yes";
        Scanner keyboard = new Scanner(System.in);
               
        do
        {
           myCard = new BingoCard();
           System.out.println("\nHere is your new BINGO Card...Good Luck! ");
           System.out.println(myCard);
           playGame();
           determineWinner();
           System.out.println("Would you like to play again? "); 
           playAgain = keyboard.nextLine();
        } while (playAgain.equalsIgnoreCase("yes"));
        
        System.out.println("You won " + totalGamesWon + " Bingo games.");
             
    }
    
    /**
     * 
     */
    public static void playGame()
    {
        int randomNumber = 0;
        
        for (int i = 0; i < 50; i++)
        {
            //Generate 1 random number between 1 & 75
            myCard.checkBingo(randomNumber);
            
        }
    }
    
    /**
     * 
     */
    public static void determineWinner()
    {
        boolean isWinner = false;
        isWinner = myCard.gotBingo();
        if (isWinner)
        {
            System.out.println("BINGO!");
            totalGamesWon++;
        }
        
        System.out.println("Here's your game results: ");
        System.out.println(myCard);
        
        System.out.println("So far, you have won " + totalGamesWon + ". ");
        System.out.println("***************************");
    }
   
    
}
