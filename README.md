# Sudoku

A Sudoku game consists of a 9x9 grid of numbers, where each number belong to
the range 1-9. Initially a subset of the grid is revealed and the goal is to fill the
remaining grid with valid numbers. The grid is divided into 9 boxes of size 3x3.
Sudoku has only one rule and that is that all regions, that is rows, columns, and
boxes, contains the numbers 1-9 exactly once.[2] In order to be regarded as a proper
Sudoku puzzle it is also required that a unique solution exists, a property which
can be determined by solving for all possible solutions

De puzzel is ontworpen door Howard Garns, een gepensioneerde architect en freelance puzzelmaker, en voor het eerst gepubliceerd in 1979 onder de naam Number Place. De puzzel werd in 1984 door Nikoli in Japan geïntroduceerd, waar hij ook de naam sudoku (samenvoeging van suuji wa dokushin ni kagiru, wat vertaald kan worden als: getallen blijven alleen ('su' betekent getal, 'doku' betekent onafhankelijk, ongetrouwd)) kreeg.

Backtrack: Backtrack is probably the most basic Sudoku solving strategy
for computer algorithms. This algorithm is a brute-force method which tries
different numbers, and if it fails it backtracks and tries a different number.

Rule-based: This method uses several rules that logically proves that a square
either must have a certain number or roles out numbers that are impossible
(which for instance could lead to a square with only one possible number).

Boltzmann machine: The Boltzmann machine algorithm models Sudoku by
using a constraint solving artificial neural network. Puzzles are seen as con-
straints describing which nodes that can not be connected to each other.
These constraints are encoded into weights of an artificial neural network and
then solved until a valid solution appears, with active nodes indicating chosen
digits.

Deze versie implementeert het Backtracking algoritme. 
Bij zoekproblemen moet er een oplossing geselecteerd worden uit een heel aantal plausibele mogelijkheden. Tijdens de oplossing van het probleem moet men keuzes maken. Als achteraf blijkt dat een genomen keuze niet leidt tot een oplossing, of niet tot een optimale oplossing, dan moet men terugkeren naar het keuzemoment. Dit terugkeren noemt men backtracking. Ook de oplossingsmethode als geheel (het algoritme) wordt backtracking genoemd. Na het maken van een nieuwe keuze gaat het algoritme verder tot opnieuw moet terugkeren, of een goede oplossing vindt.

Puzzle Backtrack(puzzle)
(x,y) = findSquare(puzzle) //Find square with least candidates
for i in puzzle[y][x].possibilities() //Loop through possible candidates
puzzle[y][x] = i //Assign guess
puzzle’ = Backtrack(puzzle) //Recursion step
if(isValidAndComplete(puzzle’)) //Check if guess lead to solution
return puzzle’
//else continue with the guessing
return null //No solution was found

