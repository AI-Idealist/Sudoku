package Sudoku;

import edu.princeton.cs.algs4.In;

public class Bord {
    int[][] sMatrix_o={{5,3,4,6,7,8,9,1,2},
                    {6,7,2,1,9,5,3,4,8},
                    {1,9,8,3,4,2,5,6,7},
                    {8,5,9,7,6,1,4,2,3},
                    {4,2,6,8,5,3,7,9,1},
                    {7,1,3,9,2,4,8,5,6},
                    {9,6,1,5,3,7,2,8,4},
                    {2,8,7,4,1,9,6,3,5},
                    {3,4,5,2,8,6,1,7,9}
                    };
    int[][] sMatrix_n={{0,4,5,2,0,3,8,0,0},
                    {2,6,3,0,0,0,1,0,5},
                    {8,9,0,0,4,5,0,0,0},
                    {0,1,2,5,3,0,0,0,0},
                    {0,3,0,9,0,8,0,0,2},
                    {9,7,8,0,1,0,0,3,0},
                    {0,5,1,3,2,4,7,8,0},
                    {0,2,0,7,0,0,0,5,0},
                    {7,0,9,6,0,1,0,2,4}
                    };
    int[][] sMatrix = {{3,0,6,5,0,8,4,0,0},
                    {5,2,0,0,0,0,0,0,0},
                    {0,8,7,0,0,0,0,3,1},
                    {0,0,3,0,1,0,0,8,0},
                    {9,0,0,8,6,3,0,0,5},
                    {0,5,0,0,9,0,6,0,0},
                    {1,3,0,0,0,0,2,5,0},
                    {0,0,0,0,0,0,0,7,4},
                    {0,0,5,2,0,6,3,0,0}
                    };
  
   public  int[][] initvelden;
   public int[][] oplvelden;
     
public Bord(String filenaam) {
    int N = 9;
    In in = new In(filenaam);
      
    initvelden = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        initvelden[i][j] = in.readInt();
      }
    }
} 

boolean isGeldig(int[][] pmat,  int curr_x, int curr_y, int num) {
    //  komt nummer al voor in rij, kolom of box    
    return !ControleerRij(pmat, curr_x, num)&&
           !ControleerKolom(pmat, curr_y, num) &&
           !ControleerBox(pmat, curr_x-(curr_x%3),curr_y-(curr_y%3), num);
}

boolean ControleerRij(int[][] pmat, int row, int num) {
  for (int col = 0; col < 9; col++) {
     if (pmat[row][col] == num) return true;
     }
  return false;
}

boolean ControleerKolom(int[][] pmat, int col, int num) {
  for (int row = 0; row < 9; row++)
    if (pmat[row][col] == num) return true;
  return false;
}

boolean ControleerBox(int[][] pmat, int boxStartRow, int boxStartCol, int num) {
  for (int row = 0; row < 3; row++)
    for (int col = 0; col < 3; col++)
      if (pmat[row+boxStartRow][col+boxStartCol] == num) return true;
  return false;
}


void printBord(String opstelling) {
         int[][] tmp = this.initvelden;
    
         if (opstelling.equals("oplossing")) {
             tmp = this.oplvelden;
         };
         for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
           System.out.print(printCel(tmp[i][j]));
              
         }
           System.out.println("|");
       }
}
    
    String printCel(int waarde) {
       String cb = "| " + waarde;
       return cb;
   }
}
