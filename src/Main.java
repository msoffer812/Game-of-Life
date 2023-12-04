/**
 * Use the game
 */
package gameOfLife;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	/**
	 * Main method that calls the others,
	 * Starts the game and loops around while the user wants to play
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int cont=1;
		/*
		 * Initialize game
		 */
		do
		{
		System.out.println("Welcome to the game of life!");
		GameOfLife currentGame = initializeGame(in);
		currentGame.runGame();
		cont = getUserInput("Press 1 to run again, any other number to exit:", in);
		} while(cont == 1);
		System.out.println("Goodbye!");
		in.close();
		System.exit(1);
	}
	/**
	 * Initialize and return the game of life
	 * @param in
	 * @return
	 */
	public static GameOfLife initializeGame(Scanner in)
	{
		int boardWidth = 0;
		int boardHeight = 0;
		int generations = 0;
		GameOfLife game = null;
		boolean cont = false;
		do
		{
			cont = false;
			boardWidth = getUserInput("Enter the width of the board", in);
			boardHeight = getUserInput("Enter the height of the board", in);
			generations = getUserInput("Enter the amount of generations you'd "
											+ "like the game to run for: ", in);
			try
			{
				game = new GameOfLife(boardHeight, boardWidth, generations);
			} catch(InputMismatchException e)
			{
				cont = true;
				System.out.println(e.getMessage());
			}
		}while(cont);
		return game;
	}
	/**
	 * Gets user input, validates and returns
	 * @param message
	 * @param in
	 * @param max
	 * @return user int input
	 */
	public static int getUserInput(String message, Scanner in)
	{
		boolean cont = false;
		int ans=0;
		do
		{
			cont = false;
			System.out.println(message);
			try
			{
				ans = in.nextInt();
			} catch(InputMismatchException e)
			{
				message = "Please enter a valid number";
				in.nextLine(); // Clear the buffer
				cont = true;
			}
			
		} while(cont);
		return ans;
	}
}
