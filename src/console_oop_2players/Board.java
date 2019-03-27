/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console_oop_2players;
import java.util.Scanner;
/**
 *
 * @author USER
 */
public class Board {
    private int ROWS, COLS;
    private int currentRow, currentCol;
    private Cell cells[][];
    public static Scanner scanner = new Scanner(System.in);
    
    public Board(){
        setROWS();
        setCOLS();
        cells = new Cell[ROWS][COLS];
        for(int r=0; r<ROWS; r++)
            for(int c=0; c<COLS; c++)
                cells[r][c] = new Cell(r, c);
    }
    public void setROWS(){
        System.out.print("Enter Row size: ");
        ROWS = scanner.nextInt();
    }
    public void setCOLS(){
        System.out.print("Enter Col size: ");
        COLS = scanner.nextInt();
    }
    public int getROWS(){
        return ROWS;
    }
    public int getCOLS(){
        return COLS;
    }
    public void setCurrentRow(int r){
        currentRow = r;
    }
    public void setCurrentCol(int c){
        currentCol = c;
    }
    public int getCurrentRow(){
        return currentRow;
    }
    public int getCurrentCol(){
        return currentCol;
    }
    public void setContentOfCell(int r, int c, Seed theSeed){
        cells[r][c].setContent(theSeed);
    }
    public Seed getContentOfCell(int r, int c){
        return cells[r][c].getContent();
    }
    public void init(){
        for(int r=0; r<ROWS; r++)
            for(int c=0; c<COLS; c++)
                cells[r][c].setContent(Seed.EMPTY);
    }
    public boolean isDraw()
    {
        for(int r=0; r<ROWS; r++)
        {
            for(int c=0; c<COLS; c++)
            {
                if(cells[r][c].getContent() == Seed.EMPTY)
                    return false;
            }
        }
        return true;
    }
    public boolean hasWon()
    {
        int r = currentRow;
        int c = currentCol;
        //thang theo hang ngang
        if(c>=1 && c<=(COLS-2) && cells[r][c].getContent()==cells[r][c-1].getContent() && cells[r][c].getContent()==cells[r][c+1].getContent())
            return true;
        if(c>=0 && c<=(COLS-3) && cells[r][c].getContent()==cells[r][c+1].getContent() && cells[r][c].getContent()==cells[r][c+2].getContent())
            return true;
        if(c>=2 && c<=(COLS-1) && cells[r][c].getContent()==cells[r][c-1].getContent() && cells[r][c].getContent()==cells[r][c-2].getContent())
            return true;
        //thang theo hang doc
        if(r>=1 && r<=(ROWS-2) && cells[r][c].getContent()==cells[r-1][c].getContent() && cells[r][c].getContent()==cells[r+1][c].getContent())
            return true;
        if(r>=0 && r<=(ROWS-3) && cells[r][c].getContent()==cells[r+1][c].getContent() && cells[r][c].getContent()==cells[r+2][c].getContent())
            return true;
        if(r>=2 && r<=(ROWS-1) && cells[r][c].getContent()==cells[r-1][c].getContent() && cells[r][c].getContent()==cells[r-2][c].getContent())
            return true;
        //thang theo duong cheo 1
        if(r<=(ROWS-3) && c<=(COLS-3) && cells[r][c].getContent()==cells[r+1][c+1].getContent() && cells[r][c].getContent()==cells[r+2][c+2].getContent())
            return true;
        if(r>=1 && c>=1 && r<=(ROWS-2) && c<=(COLS-2) && cells[r][c].getContent()==cells[r-1][c-1].getContent() && cells[r][c].getContent()==cells[r+1][c+1].getContent())
            return true;
        if(r>=2 && c>=2 && cells[r][c].getContent()==cells[r-1][c-1].getContent() && cells[r][c].getContent()==cells[r-2][c-2].getContent())
            return true;
        //thang theo duong cheo 2
        if(c>=2 && r<=(ROWS-3) && cells[r][c].getContent()==cells[r+1][c-1].getContent() && cells[r][c].getContent()==cells[r+2][c-2].getContent())
            return true;
        if(c<=(COLS-2) && r>=1 && c>=1 && r<=(ROWS-2)&& cells[r][c].getContent()==cells[r-1][c+1].getContent() && cells[r][c].getContent()==cells[r+1][c-1].getContent())
            return true;
        if(c<=(COLS-3) && r>=2 && cells[r][c].getContent()==cells[r-1][c+1].getContent() && cells[r][c].getContent()==cells[r-2][c+2].getContent())
            return true;
        return false;
    }
    public void paint(){
          for(int i=0; i<ROWS; i++)
        {
            for(int j=0; j<COLS; j++)
            {
                cells[i][j].paint();
                if(j<COLS-1)
                    System.out.print("|");
                else
                    System.out.print("\n");
            }
            if(i<ROWS-1)
            {
                for(int k=0; k<COLS; k++)
                    System.out.print("__");
            }
            System.out.print("\n");
        }       
    }
}
