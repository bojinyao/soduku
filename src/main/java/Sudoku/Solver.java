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


    /**
     * Add next board to be solved.
     * @param board
     */
    private synchronized void addJob(SquareBoard board) {
        jobs.push(board);
    }

    /**
     * pop from
     * @return next job to run
     */
    private synchronized SquareBoard nextJob() {
        return jobs.pop();
    }


    /**
     * A worker's job.
     * The "solve" method.
     */
    public void run() {
        if (jobs.isEmpty())
            return;
        while (! jobs.isEmpty()) {
            SquareBoard task = nextJob();

            /* need to kill other threads once a solution is found */
        }

    }

}
