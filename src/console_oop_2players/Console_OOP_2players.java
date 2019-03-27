/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console_oop_2players;
import java.util.Scanner;

public class Console_OOP_2players {
    private Board board;
    private GameState currentState;
    private Seed currentPlayer;
    public static Scanner scanner = new Scanner(System.in);
    
    public Console_OOP_2players(){
        do{
            initGame();
            board.paint();
            do{
                playerMove(); //update currentRow va currentCol
                updateGame(); //update currentState
                board.paint();
                //print message neu game over
                if(currentState==GameState.X_WIN)
                    System.out.println("Player X win, game over");
                else if(currentState==GameState.O_WIN)
                    System.out.println("Player O win, game over");
                else if(currentState==GameState.DRAW)
                    System.out.println("It's a draw game, game over");
                //doi luot choi
                currentPlayer = (currentPlayer==Seed.X)?Seed.O:Seed.X;
            }while(currentState==GameState.PLAYING);
            System.out.print("Play again(y|n): ");
            String q_string = scanner.next();
            char q = q_string.charAt(0);
            if((q_string.length()>1)||(q!='Y'&&q!='y'))
                System.exit(0);
            else
                System.out.println("\nNew game");
        }while(true);
    }
    public void initGame()
    {
        board = new Board();
        currentState = GameState.PLAYING;
        currentPlayer = Seed.X;
    }
    public void playerMove()
    {
        int validMove=0;
        do
        {
            if(currentPlayer == Seed.X)
                System.out.print("Player X, enter your move (row/col): ");
            else
                System.out.print("Player O, enter your move (row/col): ");
            int r = scanner.nextInt() - 1;
            int c = scanner.nextInt() - 1;
            if(r>=0 && r<board.getROWS() && c>=0 && c<board.getCOLS() && board.getContentOfCell(r, c)==Seed.EMPTY)
            {
                board.setCurrentRow(r);
                board.setCurrentCol(c);
                board.setContentOfCell(r, c, currentPlayer);
                validMove = 1;
            }
            else
            {
                System.out.println("This move is not valid, Try again");
            }
            
        }while(validMove==0);
    }
    public void updateGame()
    {
        if(board.hasWon())
            currentState = (currentPlayer==Seed.X)?GameState.X_WIN : GameState.O_WIN;
        else if(board.isDraw())
            currentState = GameState.DRAW;
        else
            currentState = GameState.PLAYING;
    }
    public static void main(String[] args) {
        new Console_OOP_2players();
    }
}
