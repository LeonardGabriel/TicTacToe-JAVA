package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    //Variabile globale
    static int playerScore = 0;
    static int computerScore = 0;
    static  Scanner input = new Scanner(System.in);

    /*

            _ | _ | _
            _ | _ | _
              |   |

        Informatii ajutatoare

        [0][0], [0][2], [0][4]
        [1][0], [1][2], [1][4]
        [2][0], [2][2], [2][4]

        Player = 1
        Computer = 0


     */

    public static void main(String[] args) {

        char[][] gameBoard = { {'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', ' ', '|', ' '} };
        printBoard(gameBoard);
        boolean gameOver = false;
        boolean playAgain = true;

    while(playAgain) {
        while (!gameOver) {
            playerMove(gameBoard);
            gameOver = isGameOver(gameBoard);

            if (gameOver) {
                break;
            }
            computerMove(gameBoard);
            gameOver = isGameOver(gameBoard);
            if (gameOver) {
                break;
            }
        }

        System.out.println("Player Score is: " + playerScore);
        System.out.println("Computer Score is : " + playerScore);
        System.out.println("Would you like to playe again? Y/N");
        input.nextLine();
        String result = input.nextLine();

        switch (result) {

            case "Y":;
            case "y":
                playAgain = true;
                System.out.println("Let's play again!");
                resetBoard(gameBoard);
                gameOver = false;
                printBoard(gameBoard);
                break;

            case "N":
            case "n":
                playAgain = false;
                System.out.println("Thank for playing! Bye bye!");
                break;

            default:
                break;
        }

    }

        /*
        playerMove(gameBoard);
        computerMove(gameBoard);
        playerMove(gameBoard);
        computerMove(gameBoard);
        playerMove(gameBoard);
        computerMove(gameBoard);
        playerMove(gameBoard);
        computerMove(gameBoard);
        playerMove(gameBoard);

         */


    }

    public static void printBoard(char[][] gameBoard){

        for(char[] row : gameBoard){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }

    }

    public static void updateBoard(int position, int player, char[][] gameBoard){


        //Aici facem update la table dupa fiecare mutare
        char character;

        if(player == 1){
            character = 'X';
        }
        else {
            character = '0';
        }

        switch (position){

            //[0][0]
            case 1:
                gameBoard[0][0] = character;
                printBoard(gameBoard);
                break;

            //[0][2]
            case 2:
                gameBoard[0][2] = character;
                printBoard(gameBoard);
                break;

            //[0][4]
            case 3:
                gameBoard[0][4] = character;
                printBoard(gameBoard);
                break;

            //[1][0]
            case 4:
                gameBoard[1][0] = character;
                printBoard(gameBoard);
                break;

            //[1][2]
            case 5:
                gameBoard[1][2] = character;
                printBoard(gameBoard);
                break;

            //[1][4]
            case 6:
                gameBoard[1][4] = character;
                printBoard(gameBoard);
                break;

            //[2][0]
            case 7:
                gameBoard[2][0] = character;
                printBoard(gameBoard);
                break;

            //[2][2]
            case 8:
                gameBoard[2][2] = character;
                printBoard(gameBoard);
                break;

            //[2][4]
            case 9:
                gameBoard[2][4] = character;
                printBoard(gameBoard);
                break;

            default:
                break;
        }

    }

    public  static  void playerMove(char[][] gameBord){

        System.out.print("Please make a make a move (1-9): ");
        int move = input.nextInt();

        boolean result = isValidMove(move, gameBord);
        while(!result){
            System.out.print("Sorry! Invalid Move. Try again!");
            System.out.println();
            System.out.print("Your new move is: ");
            move = input.nextInt();
            result = isValidMove(move, gameBord);
        }

        System.out.println("Player moved at position " + move);

        updateBoard(move, 1, gameBord);

    }

    public static void computerMove(char[][] gameBoard){

        Random rand = new Random();
        int move = rand.nextInt(9) + 1;

        boolean result = isValidMove(move, gameBoard);
        while(!result){
            move = rand.nextInt(9) + 1;
            result = isValidMove(move, gameBoard);
        }

        System.out.println("Computer moved at position: " + move);
        updateBoard(move, 2, gameBoard);
    }

    public static boolean isValidMove(int move, char[][] gameBoard){

        switch (move){
            case 1:
                if (gameBoard[0][0] == '_'){
                    return true;
                }
                else {
                    return false;
                }

            case 2:
                if (gameBoard[0][2] == '_'){
                    return true;
                }
                else {
                    return false;
                }

            case 3:
                if (gameBoard[0][4] == '_'){
                    return true;
                }
                else {
                    return false;
                }

            case 4:
                if (gameBoard[1][0] == '_'){
                    return true;
                }
                else {
                    return false;
                }

            case 5:
                if (gameBoard[1][2] == '_'){
                    return true;
                }
                else {
                    return false;
                }

            case 6:
                if (gameBoard[1][4] == '_'){
                    return true;
                }
                else {
                    return false;
                }

            case 7:
                if (gameBoard[2][0] == ' '){
                    return true;
                }
                else {
                    return false;
                }

            case 8:
                if (gameBoard[2][2] == ' '){
                    return true;
                }
                else {
                    return false;
                }

            case 9:
                if (gameBoard[2][4] == ' '){
                    return true;
                }
                else {
                    return false;
                }


            default:
                return false;
        }

    }

    public  static boolean isGameOver(char[][] gameBoard) {

        //<----------Horizontal win----------->
        if (gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X') {
            System.out.println("Player win the game!");
            playerScore++;
            return true;
        }

        if (gameBoard[0][0] == '0' && gameBoard[0][2] == '0' && gameBoard[0][4] == '0') {
            System.out.println("Computer win the game!");
            computerScore++;
            return true;
        }

        if (gameBoard[1][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[1][4] == 'X') {
            System.out.println("Player win the game!");
            playerScore++;
            return true;
        }

        if (gameBoard[1][0] == '0' && gameBoard[1][2] == '0' && gameBoard[1][4] == '0') {
            System.out.println("Computer win the game!");
            computerScore++;
            return true;
        }

        if (gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player win the game!");
            playerScore++;
            return true;
        }

        if (gameBoard[2][0] == '0' && gameBoard[2][2] == '0' && gameBoard[2][4] == '0') {
            System.out.println("Computer win the game!");
            computerScore++;
            return true;
        }

        //<---------Vertical win----------->
        if (gameBoard[0][0] == 'X' && gameBoard[1][0] == 'X' && gameBoard[2][0] == 'X') {
            System.out.println("Player win the game!");
            playerScore++;
            return true;
        }

        if (gameBoard[0][0] == '0' && gameBoard[1][0] == '0' && gameBoard[2][0] == '0') {
            System.out.println("Computer win the game!");
            computerScore++;
            return true;
        }

        if (gameBoard[0][2] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][2] == 'X') {
            System.out.println("Player win the game!");
            playerScore++;
            return true;
        }

        if (gameBoard[0][2] == '0' && gameBoard[1][2] == '0' && gameBoard[2][2] == '0') {
            System.out.println("Computer win the game!");
            computerScore++;
            return true;
        }

        if (gameBoard[0][4] == 'X' && gameBoard[1][4] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player win the game!");
            playerScore++;
            return true;
        }

        if (gameBoard[0][4] == '0' && gameBoard[1][4] == '0' && gameBoard[2][4] == '0') {
            System.out.println("Computer win the game!");
            computerScore++;
            return true;
        }

        //<-----------Diagonal Wins---------->
        if (gameBoard[0][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player win the game!");
            playerScore++;
            return true;
        }

        if (gameBoard[0][0] == '0' && gameBoard[1][2] == '0' && gameBoard[2][4] == '0') {
            System.out.println("Computer win the game!");
            computerScore++;
            return true;
        }

        if (gameBoard[0][4] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][0] == 'X') {
            System.out.println("Player win the game!");
            playerScore++;
            return true;
        }

        if (gameBoard[0][4] == '0' && gameBoard[1][2] == '0' && gameBoard[2][0] == '0') {
            System.out.println("Computer win the game!");
            computerScore++;
            return true;
        }

        if (gameBoard[0][0] != '_' && gameBoard[0][2] != '_' && gameBoard[0][4] != '_' && gameBoard[1][0] != '_'
                && gameBoard[1][2] != '_' && gameBoard[1][4] != '_' && gameBoard[2][0] != '_' && gameBoard[2][2] != '_'
                    && gameBoard[2][4] != '_')  {
            System.out.println("It's a tie!");
            return true;
        }
        return false;
    }

    public static void resetBoard(char[][] gameBoard){
        gameBoard[0][0] = '_';
        gameBoard[0][2] = '_';
        gameBoard[0][4] = '_';
        gameBoard[1][0] = '_';
        gameBoard[1][2] = '_';
        gameBoard[1][4] = '_';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';

    }
}
