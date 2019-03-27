/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console_oop_2players;

/**
 *
 * @author USER
 */
public class Cell {
    private Seed content;
    private int col;
    private int row;
    
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        content = Seed.EMPTY;
    }
    
    public void paint(){
        if(content==Seed.EMPTY)
            System.out.print(" ");
        else if(content==Seed.X)
            System.out.print("X");
        else
            System.out.print("O");
    }
    
    public void setContent(Seed content){
        this.content = content;
    }
    
    public Seed getContent(){
        return content;
    }
}
