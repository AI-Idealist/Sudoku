package Sudoku;

import edu.princeton.cs.algs4.StdOut;

public class Spel {
    Bord bord;
    AISpeler aispeler;
      
    public static void main(String[] args) {
           
      Bord bord = new Bord("sudoku01.txt");
      bord.printBord("initieel");
      AISpeler aispeler  = new AISpeler();   
      
      aispeler.zoekOplossing(bord);
      if (!aispeler.vondOplossing()){
         StdOut.println("Geen oplossing mogelijk");}
      else {
         bord.oplvelden = aispeler.Oplossing();
         bord.printBord("oplossing");}
    }
}
