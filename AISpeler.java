
package Sudoku;

public class AISpeler {
    private Bord bord;
    private int[][] lvelden;
    Boolean foundSolution = false;
    
    public void zoekOplossing(Bord pbord) {
       bord = pbord; 
       int N = bord.initvelden.length;
       lvelden = new int[N][N];
        
    	for(int i = 0; i < N; i++) {
    	  for(int j = 0; j < N; j++) {
            lvelden[i][j] = bord.initvelden[i][j];
          }
    	}
       
        if(losOp(0, 0, lvelden)) {
	  System.out.println("Solution:");
          foundSolution = true;
        } 
  }
    
 public boolean losOp(int i, int j, int[][] input) {
 //System.out.print(input[i][j]);
    if(i == 9) {
      i = 0; // row 9 doesn't exist, overflow back to 0!
      if(++j == 9) { // col 9 doesn't exist! You've reach the end of the grid!
        return true; // By right, that must be the solution.
      }
    }

    if(input[i][j] != 0) { // Already answered, recurse somewhere else!
      return losOp(i + 1, j, input);
    }

    // Keep filling in numbers until they are valid.
    for(int v = 1; v <= 9; v++) {
      if(bord.isGeldig(input, i, j, v)) {
	input[i][j] = v;
 	// Recurse into child node.
	if(losOp(i + 1, j, input)) {
          return true;
	}
      }
    }
   // This solution failed, backtracking...
   input[i][j] = 0;
   return false;
}
  
 public boolean vondOplossing() {
   return this.foundSolution;
 }
 
 public int[][] Oplossing() {
   return lvelden;
          
 }
}


