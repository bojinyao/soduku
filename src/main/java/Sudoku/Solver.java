package Sudoku;

import java.util.Stack;

/**
 * Wrapper class to solve a Square Board
 */

public class Solver implements Runnable {

    /** Board to be solved */
    private SquareBoard board;

    /** Size of SquareBoard */
    private int size;

    /** Stores each variance of SquareBoards to be solved */
    private Stack<SquareBoard> jobs;

    public Solver(SquareBoard board) {
        this.board = board;
        this.size = board.getSize();
        this.jobs = new Stack<SquareBoard>();
    }


    public void run() {

    }

}
