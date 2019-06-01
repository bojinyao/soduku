package Sudoku;


/**
 * Program entry point
 *
 *
 * User will need to enter appropriate parameters
 *
 * arg[1] (int): number of entries. 3x3 board have 9 entries
 * arg[2] (flag):
 *      -a  find all valid solutions
 *      -f  find first valid solution
 * arg[3+] (int): actual entries of the board
 *  in the order of top to bottom, left to right
 */
public class Main {

    /** using a Thread Pool of 10 threads */
    private static final int POOLSIZE = 10;

    public static void Main(String... args) {

        int[] board = {};
        boolean findAll;
        /* parsing input */

        Solver solver = new Solver(board);
        for (int i = 0; i < POOLSIZE; i++) {
            Thread curr = new Thread(solver);
            curr.start();
        }

    }
}
