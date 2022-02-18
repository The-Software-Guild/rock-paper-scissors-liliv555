/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lv.assessment;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author liliv
 */
public class RockPaperScissors {
    public static int nextOption(int option) {
        int nextOption = 0;
        switch (option) {
            case 1:
                nextOption = 2;
            case 2:
                nextOption = 3;
            case 3:
                nextOption = 1;
        }
        return nextOption;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random choice = new Random();
        int rounds, usersChoice, computersChoice;
        boolean keepPlaying = true;
        
        do {
            int ties = 0;
            int usersScore = 0;
            int computersScore = 0;
            String winnerMessage;
            System.out.println("How many rounds you want to play? (1-10)");
            rounds = Integer.parseInt(input.nextLine());
            // break if rounds are invalid
            if (rounds < 1 || rounds > 10 ) {
                System.out.println("Sorry, you can only choose to have 1-10 rounds");
                break;
            }
            for (int i = rounds; i > 0; i--) {
                System.out.println("Type 1 to play rock, 2 to play paper or 3 to play scissors!");
                usersChoice = Integer.parseInt(input.nextLine());
                computersChoice = choice.nextInt(2) + 1;
                if (usersChoice == computersChoice) {
                    System.out.println("It's a tie!");
                    ties ++;
                } else if (computersChoice == nextOption(usersChoice)){  //the next choice is always winning
                    System.out.println("Computer won!");
                    computersScore++;
                } else {
                    System.out.println("You won!");
                    usersScore++;
                }
            }

            if (usersScore == computersScore) {
                winnerMessage = "It's a tie!";
            } else if (usersScore > computersScore) {
                winnerMessage = "And the final winner is you!";
            } else {
                winnerMessage = "And the final winner is the computer!"; 
            }
            
            System.out.println(winnerMessage + " You have " + usersScore + " points, the computer has " + computersScore + " points and the number of ties is: " + ties + ".");
            System.out.println("Would you like to play again? Type 1 if yes, type 2 if not.");
            usersChoice = Integer.parseInt(input.nextLine());
            if (usersChoice == 2) {
                System.out.println("Thanks for playing!");
                keepPlaying = false;
            }
        } while (keepPlaying);
    }
}
